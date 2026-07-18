CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_EmployeeID IN NUMBER,
    p_Percentage IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * (p_Percentage / 100))
    WHERE EmployeeID = p_EmployeeID;

    IF SQL%NOTFOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_EmployeeID || ' does not exist.');
    ELSE
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating salary: ' || SQLERRM);
END UpdateSalary;
/