DECLARE
    CURSOR c_MonthlyTxns IS
        SELECT t.TransactionID, t.AccountID, t.Amount, t.TransactionType, t.TransactionDate, c.Name
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM');
BEGIN
    FOR rec IN c_MonthlyTxns LOOP
        DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name || ' | Account: ' || rec.AccountID ||
                             ' | Txn ID: ' || rec.TransactionID || ' | Type: ' || rec.TransactionType ||
                             ' | Amount: ' || rec.Amount || ' | Date: ' || TO_CHAR(rec.TransactionDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/