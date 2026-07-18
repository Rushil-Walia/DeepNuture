CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_LoanAmount   IN NUMBER,
    p_InterestRate IN NUMBER,
    p_DurationYrs  IN NUMBER
) RETURN NUMBER IS
    v_MonthlyRate NUMBER;
    v_TotalMonths NUMBER;
    v_EMI         NUMBER;
BEGIN
    v_MonthlyRate := (p_InterestRate / 100) / 12;
    v_TotalMonths := p_DurationYrs * 12;
    
    IF v_MonthlyRate = 0 THEN
        v_EMI := p_LoanAmount / v_TotalMonths;
    ELSE
        v_EMI := p_LoanAmount * v_MonthlyRate * POWER(1 + v_MonthlyRate, v_TotalMonths) / 
                 (POWER(1 + v_MonthlyRate, v_TotalMonths) - 1);
    END IF;
    
    RETURN ROUND(v_EMI, 2);
END CalculateMonthlyInstallment;
/