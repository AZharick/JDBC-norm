SELECT orders.product_name
FROM customers
JOIN orders ON customers.id = orders.customer_id
WHERE LOWER(customers.name) = LOWER(:name);