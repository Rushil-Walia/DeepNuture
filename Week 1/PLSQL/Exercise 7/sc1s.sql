CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_ID NUMBER, p_Name VARCHAR2, p_DOB DATE, p_Balance NUMBER);
    PROCEDURE UpdateCustomerDetails(p_ID NUMBER, p_Name VARCHAR2, p_Balance NUMBER);
    FUNCTION GetCustomerBalance(p_ID NUMBER) RETURN NUMBER;
END CustomerManagement;
/