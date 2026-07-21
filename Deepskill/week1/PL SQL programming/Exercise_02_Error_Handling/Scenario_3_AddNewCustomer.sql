CREATE OR REPLACE PROCEDURE AddNewCustomer (
	p_customer_id IN Customers.CustomerID%TYPE,
	p_name        IN Customers.Name%TYPE,
	p_dob         IN Customers.DOB%TYPE,
	p_balance     IN Customers.Balance%TYPE
) IS
	PROCEDURE log_error(p_message IN VARCHAR2) IS
		PRAGMA AUTONOMOUS_TRANSACTION;
	BEGIN
		INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
		VALUES (p_message, SYSDATE);
		COMMIT;
	END;
BEGIN
	INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
	VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

	COMMIT;
EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
		log_error('AddNewCustomer failed: Customer ID ' || p_customer_id || ' already exists.');
		ROLLBACK;
	WHEN OTHERS THEN
		log_error('AddNewCustomer failed: ' || SQLERRM);
		ROLLBACK;
END;
/
