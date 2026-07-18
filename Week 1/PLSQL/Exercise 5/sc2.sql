CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, ActionDate, Message)
    VALUES (:NEW.TransactionID, SYSDATE, 'Inserted transaction of type: ' || :NEW.TransactionType);
END;
/
