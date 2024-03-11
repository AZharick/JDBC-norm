create table customers (
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR(50) NOT NULL,
	surname VARCHAR(50) NOT NULL,
	age INT NOT NULL,
	phone_number VARCHAR(50)
);
create table orders (
	id SERIAL NOT NULL,
	date DATE NOT NULL,
	customer_id INT NOT NULL,
	product_name VARCHAR(50) NOT NULL,
	amount INT NOT NULL,
	FOREIGN KEY (customer_id) REFERENCES customers (id)
);