INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', TO_DATE('1955-05-15', 'YYYY-MM-DD'), 12000, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (3, 'Robert Lee', TO_DATE('1960-01-10', 'YYYY-MM-DD'), 8000, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 12000, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 1500, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (3, 3, 'Savings', 8000, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (4, 1, 'Savings', 3000, SYSDATE);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 1) - 5);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 2, 12000, 7, SYSDATE, ADD_MONTHS(SYSDATE, 6));

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (3, 3, 9000, 6, SYSDATE, ADD_MONTHS(SYSDATE, 1) - 10);

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (3, 'Carol White', 'Analyst', 55000, 'Finance', TO_DATE('2018-09-10', 'YYYY-MM-DD'));

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, SYSDATE, 200, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (3, 3, SYSDATE, 500, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (4, 1, SYSDATE, 100, 'Withdrawal');

COMMIT;
INSERT INTO Customers
(CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES
(1, 'John Doe', TO_DATE('1985-05-15','YYYY-MM-DD'),
1000, SYSDATE, 'N');

INSERT INTO Customers
(CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES
(2, 'Jane Smith', TO_DATE('1990-07-20','YYYY-MM-DD'),
1500, SYSDATE, 'N');

INSERT INTO Customers
(CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES
(3, 'Robert Wilson', TO_DATE('1955-04-10','YYYY-MM-DD'),
25000, SYSDATE, 'N');

INSERT INTO Customers
(CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES
(4, 'Emily Davis', TO_DATE('1960-08-12','YYYY-MM-DD'),
12000, SYSDATE, 'N');

INSERT INTO Accounts
(AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES
(1, 1, 'Savings', 1000, SYSDATE);

INSERT INTO Accounts
(AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES
(2, 2, 'Checking', 1500, SYSDATE);

INSERT INTO Accounts
(AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES
(3, 3, 'Savings', 25000, SYSDATE);

INSERT INTO Accounts
(AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES
(4, 4, 'Savings', 12000, SYSDATE);

INSERT INTO Transactions
(TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES
(1, 1, SYSDATE, 200, 'Deposit');

INSERT INTO Transactions
(TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES
(2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Transactions
(TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES
(3, 3, SYSDATE, 1000, 'Deposit');

INSERT INTO Transactions
(TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES
(4, 4, SYSDATE, 500, 'Withdrawal');


INSERT INTO Loans
(LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES
(1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

INSERT INTO Loans
(LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES
(2, 3, 10000, 7, SYSDATE, SYSDATE + 20);

INSERT INTO Loans
(LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES
(3, 4, 8000, 6.5, SYSDATE, SYSDATE + 15);


INSERT INTO Employees
(EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES
(1, 'Alice Johnson', 'Manager', 70000, 'HR',
TO_DATE('2015-06-15','YYYY-MM-DD'));

INSERT INTO Employees
(EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES
(2, 'Bob Brown', 'Developer', 60000, 'IT',
TO_DATE('2017-03-20','YYYY-MM-DD'));

INSERT INTO Employees
(EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES
(3, 'David Miller', 'Analyst', 50000, 'Finance',
TO_DATE('2018-09-10','YYYY-MM-DD'));

COMMIT;