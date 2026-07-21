CREATE OR REPLACE PROCEDURE TransferFunds (
	p_from_account_id IN Accounts.AccountID%TYPE,
	p_to_account_id   IN Accounts.AccountID%TYPE,
	p_amount          IN NUMBER
) IS
	v_source_balance Accounts.Balance%TYPE;
BEGIN
	IF p_amount <= 0 THEN
		RAISE_APPLICATION_ERROR(-20011, 'Transfer amount must be greater than zero.');
	END IF;

	IF p_from_account_id = p_to_account_id THEN
		RAISE_APPLICATION_ERROR(-20012, 'Source and destination accounts must be different.');
	END IF;

	SELECT Balance
	INTO v_source_balance
	FROM Accounts
	WHERE AccountID = p_from_account_id
	FOR UPDATE;

	IF v_source_balance < p_amount THEN
		RAISE_APPLICATION_ERROR(-20013, 'Insufficient funds in the source account.');
	END IF;

	UPDATE Accounts
	SET Balance = Balance - p_amount,
		LastModified = SYSDATE
	WHERE AccountID = p_from_account_id;

	UPDATE Accounts
	SET Balance = Balance + p_amount,
		LastModified = SYSDATE
	WHERE AccountID = p_to_account_id;

	COMMIT;
EXCEPTION
	WHEN OTHERS THEN
		ROLLBACK;
		RAISE;
END;
/
