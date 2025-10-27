clauses:WHERE, LIMIT, GROUP BY, HAVING, ORDER BY

select* from customer;
select* from customer where customerid=1;
select* from customer where areacode=71000 AND country="malaysia";
select* from customer where areacode=71000 AND country="singapore";
select* from customer where areacode=71000 OR country="malaysia";
select* from customer where customerid between 1 and 2;
select* from customer where country in("malaysia");
select* from customer where country NOT IN("malaysia");
select* from customer where country IS NULL;
select* from customer where country IS NOT NULL;
select* from customer where areacode=71000 limit 2;
select* from customer;
select country, count(areacode) from customer group by country having count(areacode)>1;
select* from customer group by customerid having customernumber>102;
select* from customer order by customerid desc;
select lname as lastname,fname as firstname from customer;
select * from customer where fname LIKE 'h%';
select * from customer where fname LIKE '%n';
select * from customer where fname LIKE  '%i_';
select * from customer where fname LIKE  '_i%';
select * from customer where fname LIKE  '_%i';
select * from customer where fname LIKE  '%i%';
select * from customer where fname NOT LIKE  '%i%';
select * from customer where lname LIKE   'S%';