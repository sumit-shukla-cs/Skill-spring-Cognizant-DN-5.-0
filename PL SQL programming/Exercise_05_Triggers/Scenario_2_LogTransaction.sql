CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
	INSERT INTO AuditLog (
		TransactionID,
		AccountID,
		Amount,
		TransactionType,
		AuditDate
	) VALUES (
		:NEW.TransactionID,
		:NEW.AccountID,
		:NEW.Amount,
		:NEW.TransactionType,
		SYSDATE
	);
END;
/
