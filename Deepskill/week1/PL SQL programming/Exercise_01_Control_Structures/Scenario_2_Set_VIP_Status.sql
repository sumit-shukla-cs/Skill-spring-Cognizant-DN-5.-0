SET SERVEROUTPUT ON;

DECLARE
	CURSOR customer_cur IS
		SELECT CustomerID, Balance
		FROM Customers;
BEGIN
	FOR customer_rec IN customer_cur LOOP
		IF customer_rec.Balance > 10000 THEN
			UPDATE Customers
			SET IsVIP = 'Y'
			WHERE CustomerID = customer_rec.CustomerID;

			DBMS_OUTPUT.PUT_LINE('Customer ID ' || customer_rec.CustomerID || ' promoted to VIP status.');
		END IF;
	END LOOP;

	COMMIT;
END;
/
