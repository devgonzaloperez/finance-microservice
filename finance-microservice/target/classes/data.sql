-- TRANSACTION TYPES --
-- INSERT INTO transaction_type (name) VALUES ('Income');
-- INSERT INTO transaction_type (name) VALUES ('Expense');

-- TRANSACTIONS --
-- INSERT INTO transaction (description, amount, type_id, date, created_at, updated_at) 
-- VALUES ('Salary payment', 3000.00, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
-- INSERT INTO transaction (description, amount, type_id, date, created_at, updated_at) 
-- VALUES ('Grocery shopping', 150.50, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO transaction (description, amount, date, created_at, updated_at) 
VALUES ('Salary payment', 3000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO transaction (description, amount, date, created_at, updated_at) 
VALUES ('Grocery shopping', 150.50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);