select sum(purchase_amount) as total from orders;

select avg(purchase_amount) as avg_purchase_amount from orders;

select max(purchase_amount) as max_purchase_amount from orders;

select min(purchase_amount) as min_purchase_amount from orders;

select count(distinct salesman_id) as total_salesman from orders;


