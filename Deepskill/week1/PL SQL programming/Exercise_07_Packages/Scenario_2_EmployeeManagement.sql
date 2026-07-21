CREATE OR REPLACE PACKAGE EmployeeManagement IS
	PROCEDURE HireEmployee(
		p_employee_id IN Employees.EmployeeID%TYPE,
		p_name        IN Employees.Name%TYPE,
		p_position    IN Employees.Position%TYPE,
		p_salary      IN Employees.Salary%TYPE,
		p_department  IN Employees.Department%TYPE,
		p_hire_date   IN Employees.HireDate%TYPE
	);

	PROCEDURE UpdateEmployeeDetails(
		p_employee_id IN Employees.EmployeeID%TYPE,
		p_name        IN Employees.Name%TYPE,
		p_position    IN Employees.Position%TYPE,
		p_salary      IN Employees.Salary%TYPE,
		p_department  IN Employees.Department%TYPE
	);

	FUNCTION CalculateAnnualSalary(
		p_employee_id IN Employees.EmployeeID%TYPE
	) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement IS
	PROCEDURE HireEmployee(
		p_employee_id IN Employees.EmployeeID%TYPE,
		p_name        IN Employees.Name%TYPE,
		p_position    IN Employees.Position%TYPE,
		p_salary      IN Employees.Salary%TYPE,
		p_department  IN Employees.Department%TYPE,
		p_hire_date   IN Employees.HireDate%TYPE
	) IS
	BEGIN
		INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
		VALUES (p_employee_id, p_name, p_position, p_salary, p_department, p_hire_date);

		COMMIT;
	END;

	PROCEDURE UpdateEmployeeDetails(
		p_employee_id IN Employees.EmployeeID%TYPE,
		p_name        IN Employees.Name%TYPE,
		p_position    IN Employees.Position%TYPE,
		p_salary      IN Employees.Salary%TYPE,
		p_department  IN Employees.Department%TYPE
	) IS
	BEGIN
		UPDATE Employees
		SET Name = p_name,
			Position = p_position,
			Salary = p_salary,
			Department = p_department
		WHERE EmployeeID = p_employee_id;

		COMMIT;
	END;

	FUNCTION CalculateAnnualSalary(
		p_employee_id IN Employees.EmployeeID%TYPE
	) RETURN NUMBER IS
		v_salary Employees.Salary%TYPE;
	BEGIN
		SELECT Salary
		INTO v_salary
		FROM Employees
		WHERE EmployeeID = p_employee_id;

		RETURN v_salary * 12;
	EXCEPTION
		WHEN NO_DATA_FOUND THEN
			RETURN 0;
	END;
END EmployeeManagement;
/
