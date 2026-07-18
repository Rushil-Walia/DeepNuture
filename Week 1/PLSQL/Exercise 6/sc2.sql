DECLARE
    CURSOR c_Accounts IS
        SELECT AccountID, Balance FROM Accounts FOR UPDATE;
    v_Fee CONSTANT NUMBER := 50;
BEGIN
    FOR rec IN c_Accounts LOOP
        UPDATE Accounts
        SET Balance = Balance - v_Fee,
            LastModified = SYSDATE
        WHERE CURRENT OF c_Accounts;
    END LOOP;
    COMMIT;
END;
/