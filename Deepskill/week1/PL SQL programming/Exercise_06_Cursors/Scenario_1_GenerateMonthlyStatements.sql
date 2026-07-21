SET SERVEROUTPUT ON;

DECLARE
	CURSOR customer_cur IS
		SELECT DISTINCT c.CustomerID, c.Name
		FROM Customers c
		JOIN Accounts a ON a.CustomerID = c.CustomerID
		JOIN Transactions t ON t.AccountID = a.AccountID
		WHERE t.TransactionDate >= TRUNC(SYSDATE, 'MM')
		  AND t.TransactionDate < ADD_MONTHS(TRUNC(SYSDATE, 'MM'), 1)
		ORDER BY c.CustomerID;

	CURSOR transaction_cur(p_customer_id NUMBER) IS
		SELECT t.TransactionDate, t.Amount, t.TransactionType, a.AccountID
		FROM Transactions t
		JOIN Accounts a ON a.AccountID = t.AccountID
		WHERE a.CustomerID = p_customer_id
		  AND t.TransactionDate >= TRUNC(SYSDATE, 'MM')
		  AND t.TransactionDate < ADD_MONTHS(TRUNC(SYSDATE, 'MM'), 1)
		ORDER BY t.TransactionDate;
BEGIN
	FOR customer_rec IN customer_cur LOOP
		DBMS_OUTPUT.PUT_LINE('Statement for ' || customer_rec.Name || ' (Customer ID ' || customer_rec.CustomerID || ')');

		FOR transaction_rec IN transaction_cur(customer_rec.CustomerID) LOOP
			DBMS_OUTPUT.PUT_LINE(
				'  ' || TO_CHAR(transaction_rec.TransactionDate, 'YYYY-MM-DD') ||
				' | Account ' || transaction_rec.AccountID ||
				' | ' || transaction_rec.TransactionType ||
				' | ' || transaction_rec.Amount
			);
		END LOOP;
	END LOOP;
END;
/
