BEGIN
    -- Loop through all customers
    FOR cust_rec IN (SELECT CustomerID, Name, Balance FROM Customers) LOOP
        
        -- Check if the balance exceeds the threshold
        IF cust_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = cust_rec.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('Customer ' || cust_rec.Name || ' has been promoted to VIP status.');
        END IF;
    END LOOP;
    
    COMMIT;
END;
/