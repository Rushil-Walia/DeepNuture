DECLARE
    CURSOR c_Loans IS
        SELECT LoanID, InterestRate FROM Loans FOR UPDATE;
BEGIN
    FOR rec IN c_Loans LOOP
        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE CURRENT OF c_Loans;
    END LOOP;
    COMMIT;
END;
/