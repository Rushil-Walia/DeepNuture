CREATE OR REPLACE PROCEDURE TransferFunds (
    p_FromAccountID IN NUMBER,
    p_ToAccountID   IN NUMBER,
    p_Amount        IN NUMBER
) IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance INTO v_Balance FROM Accounts WHERE AccountID = p_FromAccountID;

    IF v_Balance >= p_Amount THEN
        UPDATE Accounts SET Balance = Balance - p_Amount WHERE AccountID = p_FromAccountID;
        UPDATE Accounts SET Balance = Balance + p_Amount WHERE AccountID = p_ToAccountID;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient funds.');
    END IF;
END TransferFunds;
/