CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
	p_loan_amount         IN NUMBER,
	p_interest_rate       IN NUMBER,
	p_loan_duration_years IN NUMBER
) RETURN NUMBER IS
	v_monthly_rate NUMBER;
	v_total_months  NUMBER;
BEGIN
	v_total_months := p_loan_duration_years * 12;

	IF v_total_months <= 0 THEN
		RETURN p_loan_amount;
	END IF;

	v_monthly_rate := (p_interest_rate / 100) / 12;

	IF v_monthly_rate = 0 THEN
		RETURN p_loan_amount / v_total_months;
	END IF;

	RETURN (
		p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_total_months)
	) / (
		POWER(1 + v_monthly_rate, v_total_months) - 1
	);
END;
/
