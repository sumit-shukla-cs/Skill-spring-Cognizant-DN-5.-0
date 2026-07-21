SET SERVEROUTPUT ON;

DECLARE
	CURSOR loan_cur IS
		SELECT l.LoanID, l.CustomerID, c.Name, l.EndDate
		FROM Loans l
		JOIN Customers c ON c.CustomerID = l.CustomerID
		WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
		ORDER BY l.EndDate;
BEGIN
	FOR loan_rec IN loan_cur LOOP
		DBMS_OUTPUT.PUT_LINE(
			'Reminder: ' || loan_rec.Name || ' (Customer ID ' || loan_rec.CustomerID ||
			') loan ' || loan_rec.LoanID || ' is due on ' || TO_CHAR(loan_rec.EndDate, 'YYYY-MM-DD')
		);
	END LOOP;
END;
/
