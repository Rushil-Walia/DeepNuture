BEGIN
    FOR rec IN (
        SELECT l.LoanID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.Name || ' has loan ID ' || rec.LoanID || ' due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/