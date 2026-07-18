CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE OpenAccount(p_AccountID NUMBER, p_CustomerID NUMBER, p_Type VARCHAR2, p_Balance NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_AccountID, p_CustomerID, p_Type, p_Balance, SYSDATE);
        COMMIT;
    END OpenAccount;

    PROCEDURE CloseAccount(p_AccountID NUMBER) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_AccountID;
        COMMIT;
    END CloseAccount;

    FUNCTION GetTotalBalance(p_CustomerID NUMBER) RETURN NUMBER IS
        v_TotalBalance NUMBER;
    BEGIN
        SELECT NVL(SUM(Balance), 0) INTO v_TotalBalance FROM Accounts WHERE CustomerID = p_CustomerID;
        RETURN v_TotalBalance;
    END GetTotalBalance;
END AccountOperations;
/