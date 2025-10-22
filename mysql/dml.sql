//Data Manipulation Language(DML):insert, select, update, delete, other data operations

INSERT INTO customer (customernumber, lastname, firstname, address)
VALUES 
	(101, 'Yadav', 'Himaja', '123 Street, Kuala Lumpur'),
	(102, 'Tan', 'Wei', '456 Jalan Bukit, Kuala Lumpur'),
	(103, 'Smith', 'John', '789 Avenue, Kuala Lumpur'),
	(104, 'Lee', 'Siti', '101 Jalan Ampang, Kuala Lumpur');

SELECT * FROM customer;

SELECT firstname, lastname, country FROM customer;

SELECT * FROM customer WHERE country = 'Malaysia';

SELECT * FROM customer ORDER BY lastname ASC;

SELECT COUNT(*) AS total_customers FROM customer;

UPDATE customer
SET address = '999 Jalan Baru, Kuala Lumpur'
WHERE customerid = 101;

DELETE FROM customer WHERE customerid = 104;