DQL COMMANDS(SELECT):Inorder to retrieve the data

SELECT * FROM customer;

SELECT firstname, lastname, country FROM customer;

SELECT * FROM customer WHERE country = 'Malaysia';

SELECT * FROM customer ORDER BY lastname ASC;

SELECT country, COUNT(*) AS total_customers FROM customer GROUP BY country;