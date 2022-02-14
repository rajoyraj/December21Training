-- 1 Get 10 cities in descending alphabetical order.
SELECT city FROM sakila.city ORDER BY city DESC LIMIT 10;

-- 2 Get all films with "airplane" in the title.
SELECT title FROM sakila.film WHERE title LIKE '%airplane%';

-- 3 Get the highest payment amount.
SELECT MAX(amount) FROM payment;

-- 4 Get the number of records in the customer table for store id #1.
SELECT COUNT(*)
FROM customer AS c
WHERE c.store_id = 1;

-- 5 Get all payment records for customer with email address "NANCY.THOMAS@sakilacustomer.org"
SELECT p.* 
FROM payment AS p
JOIN customer AS c ON c.customer_id = p.customer_id
WHERE c.email = 'NANCY.THOMAS@sakilacustomer.org';

-- 6 Use a View to get the film info for actor Bob Fawcett.
SELECT * FROM film_list WHERE actors LIKE '%BOB FAWCETT%';

-- 7 Use a Stored Procedure to get the 4 inventory ids for the film "Alien Center" at Store #2. 
SET @filmId = (SELECT f.film_id 
FROM film AS f
WHERE f.title = 'Alien Center');

SET @filmCount = 0;

CALL film_in_stock(@filmId, 2, @filmCount);

-- 8 Insert a new store. Ensure that you use TRANSACTION. (This one is possible but it's tough! Pay attention to constraints and the order that you are inserting data.)

START TRANSACTION;

INSERT INTO staff (first_name, last_name, address_id, email, store_id, `active`, username) 
VALUES ("John", "Doe", "18", "rando@gmail.com", "2", "1", "newJohn");

SET @staffId = LAST_INSERT_ID();

INSERT INTO address (address, district, city_id, phone, location) 
VALUES ('110 Main', 'Dime Box', 300, 7137778888, ST_GeomFromText('POINT(1 1)'));

SET @addressId = LAST_INSERT_ID();

INSERT INTO store (manager_staff_id, address_id) 
VALUES (@staffId, @addressId);

SET @storeId = LAST_INSERT_ID();

UPDATE staff 
SET store_id = @storeId
WHERE staff_id = @staffId;

ROLLBACK;

-- 9 Update the timestamp to the current date/time for the new store you entered in the previous question.
START TRANSACTION;

SET SQL_SAFE_UPDATES = 0;

UPDATE store AS s
INNER JOIN address AS a ON a.address_id = s.address_id
SET s.last_update = CURDATE()
WHERE a.address = '110 Main';

SET SQL_SAFE_UPDATES = 1;

ROLLBACK;

-- 10 Delete the new store. 
START TRANSACTION;

SET SQL_SAFE_UPDATES = 0;

DELETE s.*
FROM store AS s
INNER JOIN address AS a ON a.address_id = s.address_id
WHERE a.address = '110 Main';

SET SQL_SAFE_UPDATES = 1;

ROLLBACK;
