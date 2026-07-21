CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
	v_balance Accounts.Balance%TYPE;
BEGIN
	IF UPPER(:NEW.TransactionType) = 'DEPOSIT' THEN
		IF :NEW.Amount <= 0 THEN
			RAISE_APPLICATION_ERROR(-20021, 'Deposit amount must be positive.');
		END IF;
	ELSIF UPPER(:NEW.TransactionType) = 'WITHDRAWAL' THEN
		IF :NEW.Amount <= 0 THEN
			RAISE_APPLICATION_ERROR(-20022, 'Withdrawal amount must be positive.');
		END IF;

		SELECT Balance
		INTO v_balance
		FROM Accounts
		WHERE AccountID = :NEW.AccountID;

		IF :NEW.Amount > v_balance THEN
			RAISE_APPLICATION_ERROR(-20023, 'Withdrawal cannot exceed the account balance.');
		END IF;
	ELSE
		RAISE_APPLICATION_ERROR(-20024, 'Transaction type must be Deposit or Withdrawal.');
	END IF;
END;
/
