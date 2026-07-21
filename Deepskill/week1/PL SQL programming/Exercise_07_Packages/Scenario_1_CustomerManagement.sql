CREATE OR REPLACE PACKAGE CustomerManagement IS
	PROCEDURE AddNewCustomer(
		p_customer_id IN Customers.CustomerID%TYPE,
		p_name        IN Customers.Name%TYPE,
		p_dob         IN Customers.DOB%TYPE,
		p_balance     IN Customers.Balance%TYPE
	);

	PROCEDURE UpdateCustomerDetails(
		p_customer_id IN Customers.CustomerID%TYPE,
		p_name        IN Customers.Name%TYPE,
		p_dob         IN Customers.DOB%TYPE,
		p_balance     IN Customers.Balance%TYPE,
		p_isvip       IN Customers.IsVIP%TYPE
	);

	FUNCTION GetCustomerBalance(
		p_customer_id IN Customers.CustomerID%TYPE
	) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement IS
	PROCEDURE AddNewCustomer(
		p_customer_id IN Customers.CustomerID%TYPE,
		p_name        IN Customers.Name%TYPE,
		p_dob         IN Customers.DOB%TYPE,
		p_balance     IN Customers.Balance%TYPE
	) IS
	BEGIN
		INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
		VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE, 'N');

		COMMIT;
	END;

	PROCEDURE UpdateCustomerDetails(
		p_customer_id IN Customers.CustomerID%TYPE,
		p_name        IN Customers.Name%TYPE,
		p_dob         IN Customers.DOB%TYPE,
		p_balance     IN Customers.Balance%TYPE,
		p_isvip       IN Customers.IsVIP%TYPE
	) IS
	BEGIN
		UPDATE Customers
		SET Name = p_name,
			DOB = p_dob,
			Balance = p_balance,
			IsVIP = p_isvip,
			LastModified = SYSDATE
		WHERE CustomerID = p_customer_id;

		COMMIT;
	END;

	FUNCTION GetCustomerBalance(
		p_customer_id IN Customers.CustomerID%TYPE
	) RETURN NUMBER IS
		v_balance Customers.Balance%TYPE;
	BEGIN
		SELECT Balance
		INTO v_balance
		FROM Customers
		WHERE CustomerID = p_customer_id;

		RETURN v_balance;
	EXCEPTION
		WHEN NO_DATA_FOUND THEN
			RETURN 0;
	END;
END CustomerManagement;
/
