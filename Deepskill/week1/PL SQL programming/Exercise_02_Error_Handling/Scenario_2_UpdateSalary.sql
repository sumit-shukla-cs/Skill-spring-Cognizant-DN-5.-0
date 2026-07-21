CREATE OR REPLACE PROCEDURE UpdateSalary (
	p_employee_id IN Employees.EmployeeID%TYPE,
	p_percentage  IN NUMBER
) IS
	PROCEDURE log_error(p_message IN VARCHAR2) IS
		PRAGMA AUTONOMOUS_TRANSACTION;
	BEGIN
		INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
		VALUES (p_message, SYSDATE);
		COMMIT;
	END;
BEGIN
	UPDATE Employees
	SET Salary = Salary + (Salary * p_percentage / 100)
	WHERE EmployeeID = p_employee_id;

	IF SQL%ROWCOUNT = 0 THEN
		RAISE NO_DATA_FOUND;
	END IF;

	COMMIT;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		log_error('UpdateSalary failed: Employee ID ' || p_employee_id || ' does not exist.');
		ROLLBACK;
	WHEN OTHERS THEN
		log_error('UpdateSalary failed: ' || SQLERRM);
		ROLLBACK;
END;
/
