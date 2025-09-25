SELECT transaction_id as TRANSACTION_ID,
	amount as AMOUNT
	Transaction_type as TRANSACTION_METHOD
FROM transaction
WHERE
	Transaction_type = ‘Debit’
	AND amount > 10000 AND amount < 50000;