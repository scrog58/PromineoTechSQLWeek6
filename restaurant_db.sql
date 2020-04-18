CREATE DATABASE IF NOT EXISTS restaurant_db;

use restaurant_db;

<<<<<<< HEAD

DROP TABLE IF EXISTS Customer_purchase;
DROP TABLE IF EXISTS customers;
=======
>>>>>>> 9d642c9497deb512555ff8117397ac723a4d0bd7
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS menuItems;
DROP TABLE IF EXISTS restaurant_category;
DROP TABLE IF EXISTS restaurants;

CREATE TABLE restaurants (
	id INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY
	, name VARCHAR(40) NOT NULL
  	, address VARCHAR(80)
  	, city VARCHAR(80)
  	, state VARCHAR(2) NOT NULL
  	, created_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE restaurant_category (
	id INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY
	, restaurantid INT(20) NOT NULL
  	, name VARCHAR(40) NOT NULL
	, FOREIGN KEY (restaurantid) REFERENCES restaurants(id)
);

CREATE TABLE employees (
	id INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY
	, restaurantid INT(20)
	, first_name VARCHAR(50) NOT NULL
	, last_name VARCHAR(50) NOT NULL
	, title VARCHAR(50) NOT NULL
	, address VARCHAR(80) NOT NULL
	, city VARCHAR(80) NOT NULL
	, state VARCHAR(2) NOT NULL
	, hire_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL
	, FOREIGN KEY (restaurantid) REFERENCES restaurants(id)
);

<<<<<<< HEAD
CREATE TABLE employees (
    id INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY
    , first_name VARCHAR(50) NOT NULL
    , last_name VARCHAR(50) NOT NULL
    , title VARCHAR(50) NOT NULL
    , address VARCHAR(80) NOT NULL
    , city VARCHAR(80) NOT NULL
    , state VARCHAR(2) NOT NULL
    , hire_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL
);
CREATE TABLE menuItems (
    id INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY
    , restaurantid INT(20) NOT NULL
    , item VARCHAR(50) NOT NULL
    , price INT NOT NULL
    , FOREIGN KEY (restaurantid) REFERENCES restaurants(id)
);

CREATE TABLE customers (
	id int(20) not null auto_increment primary key,
	restaurant_id int(20) not null,
	name varchar(25) not null,
	birth_date date not null,
	email varchar(30) not null,
	city varchar (20) not null,
	state char (2) not null,
	foreign key (restaurant_id) references restaurants(id)
);

CREATE TABLE Customer_purchase (
	id int(20) not null auto_increment primary key,
	customer_id (20) not null,
	purchase_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	foreign key (customer_id) references customers(id)
);
=======
CREATE TABLE menuItems (
	id INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY
	, restaurantid INT(20) NOT NULL
	, item VARCHAR(50) NOT NULL
	, price INT NOT NULL
	, FOREIGN KEY (restaurantid) REFERENCES restaurants(id)
);
>>>>>>> 9d642c9497deb512555ff8117397ac723a4d0bd7
