CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddCustomer(p_ID NUMBER, p_Name VARCHAR2, p_DOB DATE, p_Balance NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_ID, p_Name, p_DOB, p_Balance, SYSDATE);
        COMMIT;
    END AddCustomer;

    PROCEDURE UpdateCustomerDetails(p_ID NUMBER, p_Name VARCHAR2, p_Balance NUMBER) IS
    BEGIN
        UPDATE Customers
        SET Name = p_Name, Balance = p_Balance, LastModified = SYSDATE
        WHERE CustomerID = p_ID;
        COMMIT;
    END UpdateCustomerDetails;

    FUNCTION GetCustomerBalance(p_ID NUMBER) RETURN NUMBER IS
        v_Balance NUMBER;
    BEGIN
        SELECT Balance INTO v_Balance FROM Customers WHERE CustomerID = p_ID;
        RETURN v_Balance;
    END GetCustomerBalance;
END CustomerManagement;
/