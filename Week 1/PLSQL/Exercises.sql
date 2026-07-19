-- PL/SQL Exercises Solution

-- ==========================================
-- Schema and Sample Data
-- ==========================================
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);
CREATE TABLE AuditLog (
    LogID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    ActionDate DATE,
    Description VARCHAR2(200)
);

-- ==========================================
-- Exercise 1: Control Structures
-- ==========================================
-- Scenario 1
DECLARE
    v_age NUMBER;
BEGIN
    FOR cust IN (SELECT CustomerID, DOB FROM Customers) LOOP
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, cust.DOB) / 12);
        IF v_age > 60 THEN
            UPDATE Loans SET InterestRate = InterestRate - 1 WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2
ALTER TABLE Customers ADD IsVIP VARCHAR2(5) DEFAULT 'FALSE';
BEGIN
    FOR cust IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF cust.Balance > 10000 THEN
            UPDATE Customers SET IsVIP = 'TRUE' WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3
BEGIN
    FOR loan IN (SELECT CustomerID, EndDate FROM Loans WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan due for customer ' || loan.CustomerID || ' on ' || TO_CHAR(loan.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/

-- ==========================================
-- Exercise 2: Error Handling
-- ==========================================
-- Scenario 1
CREATE OR REPLACE PROCEDURE SafeTransferFunds(p_FromAccountID NUMBER, p_ToAccountID NUMBER, p_Amount NUMBER) AS
    v_FromBalance NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    SELECT Balance INTO v_FromBalance FROM Accounts WHERE AccountID = p_FromAccountID FOR UPDATE;
    IF v_FromBalance < p_Amount THEN
        RAISE insufficient_funds;
    END IF;
    UPDATE Accounts SET Balance = Balance - p_Amount WHERE AccountID = p_FromAccountID;
    UPDATE Accounts SET Balance = Balance + p_Amount WHERE AccountID = p_ToAccountID;
    COMMIT;
EXCEPTION
    WHEN insufficient_funds THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds for transfer.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK;
END;
/

-- Scenario 2
CREATE OR REPLACE PROCEDURE UpdateSalary(p_EmployeeID NUMBER, p_Percentage NUMBER) AS
    v_count NUMBER;
    emp_not_found EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO v_count FROM Employees WHERE EmployeeID = p_EmployeeID;
    IF v_count = 0 THEN
        RAISE emp_not_found;
    END IF;
    UPDATE Employees SET Salary = Salary + (Salary * p_Percentage / 100) WHERE EmployeeID = p_EmployeeID;
    COMMIT;
EXCEPTION
    WHEN emp_not_found THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_EmployeeID || ' not found.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

-- Scenario 3
CREATE OR REPLACE PROCEDURE AddNewCustomer(p_CustomerID NUMBER, p_Name VARCHAR2, p_DOB DATE, p_Balance NUMBER) AS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);
    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_CustomerID || ' already exists.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

-- ==========================================
-- Exercise 3: Stored Procedures
-- ==========================================
-- Scenario 1
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts SET Balance = Balance + (Balance * 0.01) WHERE AccountType = 'Savings';
    COMMIT;
END;
/

-- Scenario 2
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(p_Department VARCHAR2, p_BonusPercentage NUMBER) AS
BEGIN
    UPDATE Employees SET Salary = Salary + (Salary * p_BonusPercentage / 100) WHERE Department = p_Department;
    COMMIT;
END;
/

-- Scenario 3
CREATE OR REPLACE PROCEDURE TransferFunds(p_FromAccountID NUMBER, p_ToAccountID NUMBER, p_Amount NUMBER) AS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_FromAccountID;
    IF v_balance >= p_Amount THEN
        UPDATE Accounts SET Balance = Balance - p_Amount WHERE AccountID = p_FromAccountID;
        UPDATE Accounts SET Balance = Balance + p_Amount WHERE AccountID = p_ToAccountID;
        COMMIT;
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
    END IF;
END;
/

-- ==========================================
-- Exercise 4: Functions
-- ==========================================
-- Scenario 1
CREATE OR REPLACE FUNCTION CalculateAge(p_DOB DATE) RETURN NUMBER IS
BEGIN
    RETURN FLOOR(MONTHS_BETWEEN(SYSDATE, p_DOB) / 12);
END;
/

-- Scenario 2
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(p_LoanAmount NUMBER, p_InterestRate NUMBER, p_Years NUMBER) RETURN NUMBER IS
    v_MonthlyRate NUMBER;
    v_TotalMonths NUMBER;
    v_Installment NUMBER;
BEGIN
    v_MonthlyRate := p_InterestRate / 100 / 12;
    v_TotalMonths := p_Years * 12;
    v_Installment := p_LoanAmount * (v_MonthlyRate * POWER(1 + v_MonthlyRate, v_TotalMonths)) / (POWER(1 + v_MonthlyRate, v_TotalMonths) - 1);
    RETURN ROUND(v_Installment, 2);
END;
/

-- Scenario 3
CREATE OR REPLACE FUNCTION HasSufficientBalance(p_AccountID NUMBER, p_Amount NUMBER) RETURN BOOLEAN IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance INTO v_Balance FROM Accounts WHERE AccountID = p_AccountID;
    RETURN v_Balance >= p_Amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/

-- ==========================================
-- Exercise 5: Triggers
-- ==========================================
-- Scenario 1
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

-- Scenario 2
CREATE SEQUENCE log_seq START WITH 1;
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (LogID, TransactionID, ActionDate, Description)
    VALUES (log_seq.NEXTVAL, :NEW.TransactionID, SYSDATE, 'Transaction of ' || :NEW.Amount || ' inserted.');
END;
/

-- Scenario 3
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    IF :NEW.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = :NEW.AccountID;
        IF :NEW.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20001, 'Withdrawal exceeds balance.');
        END IF;
    ELSIF :NEW.TransactionType = 'Deposit' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
        END IF;
    END IF;
END;
/

-- ==========================================
-- Exercise 6: Cursors
-- ==========================================
-- Scenario 1
DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT t.TransactionID, t.AccountID, c.Name, t.Amount, t.TransactionType 
        FROM Transactions t JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE);
BEGIN
    FOR stmt IN GenerateMonthlyStatements LOOP
        DBMS_OUTPUT.PUT_LINE('Customer: ' || stmt.Name || ', Account: ' || stmt.AccountID || ', Txn: ' || stmt.TransactionType || ' ' || stmt.Amount);
    END LOOP;
END;
/

-- Scenario 2
DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance FROM Accounts;
BEGIN
    FOR acc IN ApplyAnnualFee LOOP
        UPDATE Accounts SET Balance = Balance - 50 WHERE AccountID = acc.AccountID;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3
DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, InterestRate FROM Loans;
BEGIN
    FOR loan IN UpdateLoanInterestRates LOOP
        UPDATE Loans SET InterestRate = InterestRate + 0.5 WHERE LoanID = loan.LoanID;
    END LOOP;
    COMMIT;
END;
/

-- ==========================================
-- Exercise 7: Packages
-- ==========================================
-- Scenario 1
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_CustomerID NUMBER, p_Name VARCHAR2, p_DOB DATE, p_Balance NUMBER);
    PROCEDURE UpdateCustomer(p_CustomerID NUMBER, p_Name VARCHAR2);
    FUNCTION GetCustomerBalance(p_CustomerID NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddCustomer(p_CustomerID NUMBER, p_Name VARCHAR2, p_DOB DATE, p_Balance NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);
        COMMIT;
    END AddCustomer;

    PROCEDURE UpdateCustomer(p_CustomerID NUMBER, p_Name VARCHAR2) IS
    BEGIN
        UPDATE Customers SET Name = p_Name, LastModified = SYSDATE WHERE CustomerID = p_CustomerID;
        COMMIT;
    END UpdateCustomer;

    FUNCTION GetCustomerBalance(p_CustomerID NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_CustomerID;
        RETURN v_balance;
    END GetCustomerBalance;
END CustomerManagement;
/

-- Scenario 2
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_EmployeeID NUMBER, p_Name VARCHAR2, p_Position VARCHAR2, p_Salary NUMBER, p_Department VARCHAR2);
    PROCEDURE UpdateEmployeeDetails(p_EmployeeID NUMBER, p_Position VARCHAR2);
    FUNCTION CalculateAnnualSalary(p_EmployeeID NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireEmployee(p_EmployeeID NUMBER, p_Name VARCHAR2, p_Position VARCHAR2, p_Salary NUMBER, p_Department VARCHAR2) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate) VALUES (p_EmployeeID, p_Name, p_Position, p_Salary, p_Department, SYSDATE);
        COMMIT;
    END HireEmployee;

    PROCEDURE UpdateEmployeeDetails(p_EmployeeID NUMBER, p_Position VARCHAR2) IS
    BEGIN
        UPDATE Employees SET Position = p_Position WHERE EmployeeID = p_EmployeeID;
        COMMIT;
    END UpdateEmployeeDetails;

    FUNCTION CalculateAnnualSalary(p_EmployeeID NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_EmployeeID;
        RETURN v_salary * 12;
    END CalculateAnnualSalary;
END EmployeeManagement;
/

-- Scenario 3
CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_AccountID NUMBER, p_CustomerID NUMBER, p_AccountType VARCHAR2, p_Balance NUMBER);
    PROCEDURE CloseAccount(p_AccountID NUMBER);
    FUNCTION GetTotalBalance(p_CustomerID NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE OpenAccount(p_AccountID NUMBER, p_CustomerID NUMBER, p_AccountType VARCHAR2, p_Balance NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified) VALUES (p_AccountID, p_CustomerID, p_AccountType, p_Balance, SYSDATE);
        COMMIT;
    END OpenAccount;

    PROCEDURE CloseAccount(p_AccountID NUMBER) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_AccountID;
        COMMIT;
    END CloseAccount;

    FUNCTION GetTotalBalance(p_CustomerID NUMBER) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = p_CustomerID;
        RETURN v_total;
    END GetTotalBalance;
END AccountOperations;
/
