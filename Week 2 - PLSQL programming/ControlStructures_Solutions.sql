-- Exercise 1: Control Structures

-- Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
-- 	•	Question: Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.

        BEGIN
            FOR customer_rec IN (
                SELECT CustomerID, LoanInterestRate
                FROM customers where Age > 60
            ) LOOP
                UPDATE Customers
                SET LoanInterestRate = LoanInterestRate - 1
                WHERE CustomerID = customer_rec.CustomerID;
            END LOOP;

            COMMIT;
        END;
    /

-- Scenario 2: A customer can be promoted to VIP status based on their balance.
-- 	•	Question: Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000.
        BEGIN 
            FOR customer_rec IN(
                SELECT CustomerID
                FROM Customers
                WHERE Balance > 10000
            ) LOOP
                UPDATE Customers
                SET IsVIP = 'TRUE'
                WHERE CustomerID = customer_rec.CustomerID;
            END LOOP;

            COMMIT;
        END;
    /
-- Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.
-- 	•	Question: Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer.

BEGIN
    FOR loan_rec IN (
        SELECT LoanID, Customer_ID, DueDate
        FROM Loans
        WHERE DueDate BETWEEN SYSDATE and SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Remainder: Loan ID ' || loan_rec.LoanID ||
            'for Customer ID ' || loan_rec.CustomerID ||
            'is due on ' || TO_CHAR(loan_rec.DueDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
