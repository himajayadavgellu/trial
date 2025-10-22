 //Data Defination Languag(DDL):Create, alter, describe, truncate, drop table
 
 CREATE TABLE customer (
         customerid INT AUTO_INCREMENT PRIMARY KEY,
         customernumber INT NOT NULL UNIQUE,
         lastname VARCHAR(30) NOT NULL,
         firstname VARCHAR(30) NOT NULL,
         areacode INT DEFAULT 71000,
         address VARCHAR(50),
         country VARCHAR(50) DEFAULT 'Malaysia',
         CHECK (customernumber > 0)
     );
DESC customer;

ALTER TABLE customer ADD email VARCHAR(50);

ALTER TABLE customer MODIFY address VARCHAR(100);

ALTER TABLE customer DROP COLUMN email;

ALTER TABLE customer RENAME COLUMN firstname TO fname;

ALTER TABLE customer ADD CONSTRAINT chk_areacode CHECK (areacode > 0);

RENAME TABLE customer TO client;

TRUNCATE TABLE customer;

DROP TABLE customer;


 