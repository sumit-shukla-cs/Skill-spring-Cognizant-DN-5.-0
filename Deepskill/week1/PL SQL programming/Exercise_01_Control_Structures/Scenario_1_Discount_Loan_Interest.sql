SET SERVEROUTPUT ON;

DECLARE
	CURSOR customer_cur IS
		SELECT CustomerID, DOB
		FROM Customers;
	v_age NUMBER;
BEGIN
	FOR customer_rec IN customer_cur LOOP
		v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, customer_rec.DOB) / 12);

		IF v_age > 60 THEN
			UPDATE Loans
			SET InterestRate = InterestRate * 0.99
			WHERE CustomerID = customer_rec.CustomerID;

			DBMS_OUTPUT.PUT_LINE('Applied 1% loan interest discount for Customer ID ' || customer_rec.CustomerID);
		END IF;
	END LOOP;

	COMMIT;
END;
/
