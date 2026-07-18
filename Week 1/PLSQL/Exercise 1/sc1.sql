SET SERVEROUTPUT ON;

DECLARE
    v_age NUMBER;
BEGIN
    -- Loop through all loans and join with customers to get the DOB
    FOR loan_rec IN (
        SELECT l.LoanID, l.InterestRate, c.DOB 
        FROM Loans l 
        JOIN Customers c ON l.CustomerID = c.CustomerID
    ) LOOP
        -- Calculate the customer's age in years
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, loan_rec.DOB) / 12);
        
        -- Apply the discount if they are over 60
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = loan_rec.LoanID;
            
            DBMS_OUTPUT.PUT_LINE('1% discount applied to Loan ID: ' || loan_rec.LoanID || '. New Rate: ' || (loan_rec.InterestRate - 1) || '%');
        END IF;
    END LOOP;
    
    COMMIT;
END;
/
