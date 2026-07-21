DECLARE
	CURSOR loan_cur IS
		SELECT LoanID, LoanAmount, InterestRate
		FROM Loans
		FOR UPDATE OF InterestRate;
	v_new_rate NUMBER;
BEGIN
	FOR loan_rec IN loan_cur LOOP
		IF loan_rec.LoanAmount >= 10000 THEN
			v_new_rate := loan_rec.InterestRate + 0.75;
		ELSE
			v_new_rate := loan_rec.InterestRate + 0.50;
		END IF;

		UPDATE Loans
		SET InterestRate = v_new_rate
		WHERE CURRENT OF loan_cur;
	END LOOP;

	COMMIT;
END;
/
