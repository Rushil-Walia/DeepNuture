CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireEmployee(p_ID NUMBER, p_Name VARCHAR2, p_Pos VARCHAR2, p_Sal NUMBER, p_Dept VARCHAR2, p_HireDate DATE) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_ID, p_Name, p_Pos, p_Sal, p_Dept, p_HireDate);
        COMMIT;
    END HireEmployee;

    PROCEDURE UpdateEmployee(p_ID NUMBER, p_Pos VARCHAR2, p_Sal NUMBER) IS
    BEGIN
        UPDATE Employees
        SET Position = p_Pos, Salary = p_Sal
        WHERE EmployeeID = p_ID;
        COMMIT;
    END UpdateEmployee;

    FUNCTION CalculateAnnualSalary(p_ID NUMBER) RETURN NUMBER IS
        v_Salary NUMBER;
    BEGIN
        SELECT Salary INTO v_Salary FROM Employees WHERE EmployeeID = p_ID;
        RETURN v_Salary * 12;
    END CalculateAnnualSalary;
END EmployeeManagement;
/