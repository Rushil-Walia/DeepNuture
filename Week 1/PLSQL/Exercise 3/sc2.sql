CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_Department IN VARCHAR2,
    p_BonusPct   IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * (p_BonusPct / 100))
    WHERE Department = p_Department;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus updated for department: ' || p_Department);
END UpdateEmployeeBonus;
/