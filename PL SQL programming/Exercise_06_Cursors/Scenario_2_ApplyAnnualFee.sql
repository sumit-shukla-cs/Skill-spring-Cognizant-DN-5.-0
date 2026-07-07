DECLARE
	CURSOR account_cur IS
		SELECT AccountID, Balance
		FROM Accounts;
	v_annual_fee NUMBER := 50;
BEGIN
	FOR account_rec IN account_cur LOOP
		UPDATE Accounts
		SET Balance = GREATEST(account_rec.Balance - v_annual_fee, 0),
			LastModified = SYSDATE
		WHERE AccountID = account_rec.AccountID;
	END LOOP;

	COMMIT;
END;
/
