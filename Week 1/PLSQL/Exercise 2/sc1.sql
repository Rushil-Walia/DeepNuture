CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_FromAccountID IN NUMBER,
    p_ToAccountID   IN NUMBER,
    p_Amount        IN NUMBER
) IS
    v_Balance NUMBER;
    e_InsufficientFunds EXCEPTION;
BEGIN
    SELECT Balance INTO v_Balance 
    FROM Accounts 
    WHERE AccountID = p_FromAccountID 
    FOR UPDATE;

    IF v_Balance < p_Amount THEN
        RAISE e_InsufficientFunds;
    END IF;

    UPDATE Accounts 
    SET Balance = Balance - p_Amount 
    WHERE AccountID = p_FromAccountID;

    UPDATE Accounts 
    SET Balance = Balance + p_Amount 
    WHERE AccountID = p_ToAccountID;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer successful.');
EXCEPTION
    WHEN e_InsufficientFunds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in source account.');
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: One or both Account IDs do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Transfer failed due to an unexpected issue. ' || SQLERRM);
END SafeTransferFunds;
/