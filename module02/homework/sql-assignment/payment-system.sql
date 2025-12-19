-- SELECT * FROM users WHERE id = 1;
-- SELECT * FROM accounts WHERE user_id = 1;
-- SELECT * FROM users WHERE id = 1;

-- task 1
SELECT users.id, accounts.id, transactions.initiated_at
FROM users
JOIN accounts  ON accounts.user_id = users.id
JOIN transactions ON transactions.account_id = accounts.id
WHERE users.id = 1
ORDER BY transactions.initiated_at DESC;

-- task 2
SELECT * FROM transactions
JOIN accounts ON accounts.id = transactions.account_id
WHERE accounts.account_number = 'ACC101'
ORDER BY transactions.initiated_at DESC;

-- task 3
SELECT * FROM payments
WHERE transaction_id = 1
ORDER BY paid_at DESC;

-- task 4
SELECT * FROM transactions
JOIN payments ON transactions.id = payments.transaction_id
JOIN invoices ON payments.id = invoices.payment_id
WHERE transactions.id = 1
ORDER BY invoices.issued_at DESC;

-- SELECT * FROM users WHERE users.id = 1;
-- SELECT * FROM accounts;

-- task 5
SELECT * FROM users
JOIN accounts ON accounts.user_id = users.id
JOIN transactions ON transactions.account_id = accounts.id
JOIN payments ON payments.transaction_id = transactions.id
JOIN invoices ON invoices.payment_id = payments.id
WHERE users.id = 1
AND transactions.status = 'SUCCESS'
AND payments.payment_status = 'PAID';

-- task 6
SELECT users.id,
    CONCAT(users.first_name, ' ', users.last_name) AS full_name,
    SUM(accounts.balance) AS total_balance,
    AVG(accounts.balance) AS average_balance

FROM users
JOIN accounts ON accounts.user_id = users.id
GROUP BY users.id, users.first_name, users.last_name
ORDER BY total_balance DESC;

-- task 7

SELECT accounts.account_number,

    COUNT(transactions.id) AS transaction_count,
    SUM(transactions.total_amount) AS total_amount,
    AVG(transactions.total_amount) AS average_amount

FROM accounts
JOIN transactions ON transactions.account_id = accounts.id
GROUP BY accounts.id, accounts.account_number
ORDER BY total_amount DESC;


-- task 8

SELECT
    CONCAT(users.first_name, ' ', users.last_name) AS full_name,
    SUM(transactions.total_amount) AS total_paid,
    AVG(transactions.total_amount) AS average_paid

FROM users

JOIN accounts ON accounts.user_id = users.id

JOIN transactions ON transactions.account_id = accounts.id

JOIN payments ON payments.transaction_id = transactions.id

WHERE payments.payment_status = 'PAID'
GROUP BY users.id, users.first_name, users.last_name
ORDER BY total_paid DESC;