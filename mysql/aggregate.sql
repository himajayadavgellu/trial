Aggregate Functions: count, sum, avg, min, max

SELECT COUNT(*) AS total_customers FROM customer;

SELECT country, COUNT(*) AS total_customers FROM customer GROUP BY country;

SELECT SUM(areacode) AS total_areacode FROM customer;

SELECT country, SUM(areacode) AS total_areacode FROM customer GROUP BY country;

SELECT AVG(areacode) AS avg_areacode FROM customer;

SELECT country, AVG(areacode) AS avg_areacode FROM customer GROUP BY country;

SELECT MAX(areacode) AS max_areacode FROM customer;

SELECT country, MAX(areacode) AS max_areacode FROM customer GROUP BY country;

SELECT MIN(areacode) AS min_areacode FROM customer;

SELECT country, MIN(areacode) AS min_areacode FROM customer GROUP BY country;

SELECT country, COUNT(*) AS total_customers, SUM(areacode) AS total_areacode, 
				AVG(areacode) AS avg_areacode, MIN(areacode) AS min_areacode, 
				MAX(areacode) AS max_areacode FROM customer GROUP BY country;