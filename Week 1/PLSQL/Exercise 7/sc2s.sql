CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_ID NUMBER, p_Name VARCHAR2, p_Pos VARCHAR2, p_Sal NUMBER, p_Dept VARCHAR2, p_HireDate DATE);
    PROCEDURE UpdateEmployee(p_ID NUMBER, p_Pos VARCHAR2, p_Sal NUMBER);
    FUNCTION CalculateAnnualSalary(p_ID NUMBER) RETURN NUMBER;
END EmployeeManagement;
/