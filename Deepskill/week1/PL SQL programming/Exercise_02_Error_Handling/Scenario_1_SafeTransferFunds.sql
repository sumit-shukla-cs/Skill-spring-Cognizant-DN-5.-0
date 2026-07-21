CREATE OR REPLACE PROCEDURE SafeTransferFunds (
	p_from_account_id IN Accounts.AccountID%TYPE,
	p_to_account_id   IN Accounts.AccountID%TYPE,
	p_amount          IN NUMBER
) IS
	v_source_balance Accounts.Balance%TYPE;
	v_target_balance Accounts.Balance%TYPE;

	PROCEDURE log_error(p_message IN VARCHAR2) IS
		PRAGMA AUTONOMOUS_TRANSACTION;
	BEGIN
		INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
		VALUES (p_message, SYSDATE);
		COMMIT;
	END;
BEGIN
	IF p_amount <= 0 THEN
		RAISE_APPLICATION_ERROR(-20001, 'Transfer amount must be greater than zero.');
	END IF;

	IF p_from_account_id = p_to_account_id THEN
		RAISE_APPLICATION_ERROR(-20002, 'Source and destination accounts must be different.');
	END IF;

	SELECT Balance
	INTO v_source_balance
	FROM Accounts
	WHERE AccountID = p_from_account_id
	FOR UPDATE;

	SELECT Balance
	INTO v_target_balance
	FROM Accounts
	WHERE AccountID = p_to_account_id
	FOR UPDATE;

	IF v_source_balance < p_amount THEN
		RAISE_APPLICATION_ERROR(-20003, 'Insufficient funds in the source account.');
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
		log_error('SafeTransferFunds failed: ' || SQLERRM);
		ROLLBACK;
END;
/
