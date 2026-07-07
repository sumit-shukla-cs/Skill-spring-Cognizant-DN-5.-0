CREATE OR REPLACE PACKAGE AccountOperations IS
	PROCEDURE OpenNewAccount(
		p_account_id   IN Accounts.AccountID%TYPE,
		p_customer_id  IN Accounts.CustomerID%TYPE,
		p_account_type IN Accounts.AccountType%TYPE,
		p_balance      IN Accounts.Balance%TYPE DEFAULT 0
	);

	PROCEDURE CloseAccount(
		p_account_id IN Accounts.AccountID%TYPE
	);

	FUNCTION GetTotalCustomerBalance(
		p_customer_id IN Accounts.CustomerID%TYPE
	) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations IS
	PROCEDURE OpenNewAccount(
		p_account_id   IN Accounts.AccountID%TYPE,
		p_customer_id  IN Accounts.CustomerID%TYPE,
		p_account_type IN Accounts.AccountType%TYPE,
		p_balance      IN Accounts.Balance%TYPE DEFAULT 0
	) IS
	BEGIN
		INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
		VALUES (p_account_id, p_customer_id, p_account_type, p_balance, SYSDATE);

		COMMIT;
	END;

	PROCEDURE CloseAccount(
		p_account_id IN Accounts.AccountID%TYPE
	) IS
	BEGIN
		DELETE FROM Accounts
		WHERE AccountID = p_account_id;

		COMMIT;
	END;

	FUNCTION GetTotalCustomerBalance(
		p_customer_id IN Accounts.CustomerID%TYPE
	) RETURN NUMBER IS
		v_total_balance NUMBER;
	BEGIN
		SELECT NVL(SUM(Balance), 0)
		INTO v_total_balance
		FROM Accounts
		WHERE CustomerID = p_customer_id;

		RETURN v_total_balance;
	END;
END AccountOperations;
/
