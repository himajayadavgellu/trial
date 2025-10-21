 //Data Defination Language(create).creating a table customer.
 
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