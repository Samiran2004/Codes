SELECT c.First_name as FIRST_NAME,
	c.Contact as CONTACT,
	a.balance as “BALANCE”
FROM customer c
JOIN
account a ON c.customer_id = a.coustomer_id
JOIN
account_type at ON a.account_type_id = at.account_type_id
WHERE at.account_type_name like ‘Sa%’
ORDER BY c.first_name desc;