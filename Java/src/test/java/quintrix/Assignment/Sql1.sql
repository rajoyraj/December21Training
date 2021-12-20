1.Get 10 cities in descending alphabetical order.

SELECT * FROM sakila.city ORDER BY city DESC limit 10;

2.Get all films with "airplane" in the title.

SELECT * FROM sakila.film WHERE title='AIRPLANE';

3.Get the highest payment amount.

SELECT MAX(amount) AS HighestPaymentAmount FROM sakila.payment;

4.Get the number of records in the customer table for store id #1.

SELECT COUNT(store_id) FROM customer WHERE store_id = 1;

5.Get all payment records for customer with email address "NANCY.THOMAS@sakilacustomer.org"

SELECT * from payment WHERE customer_id =(SELECT customer_id FROM customer WHERE email = "NANCY.THOMAS@sakilacustomer.org");

6.Use a View to get the film info for actor Bob Fawcett.

SELECT film_info FROM sakila.actor_info WHERE first_name="BOB" AND last_name="FAWCETT";

7.Use a Stored Procedure to get the 4 inventory ids for the film "Alien Center" at Store #2. 
 
IDELIMITER //
CREATE PROCEDURE GetInventoryIds (in store_id varchar(10)) 
BEGIN
	SELECT inventory_id FROM inventory WHERE store_id = store_id and film_id = (SELECT film_id FROM film WHERE title = "Alien Center") LIMIT 4; 
END //
DELIMITER ;
CALL GetInventoryIds(2);
8.Insert a new store. Ensure that you use TRANSACTION. (This one is possible but it's tough! Pay attention to constraints and the order that you are inserting data.) 

begin;
	insert into staff value (3, 'James', 'Anderson', 5,null,'Jamesanderson112@sakilastaff.com',2,1,'Joe',NULL, '2S006-02-15 04:57:12');
	insert into store (store_id, manager_staff_id,address_id,last_update) values (3,3,3,'2006-02-15 04:57:12');
    update staff set store_id = 3 where staff_id = 3;
commit

9.Update the timestamp to the current date/time for the new store you entered in the previous question. 


update store set last_update = current_timestamp() where store_id = 3;

10.Delete the new store. 

begin;
	update staff set store_id = 0 where staff_id = 3;
    delete from store where store_id = 3;
commit