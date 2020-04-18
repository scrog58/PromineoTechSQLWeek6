CREATE DATABASE IF NOT EXISTS restaurant_db;

use restaurant_db;

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

CREATE TABLE menuItems (
	id INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY
	, restaurantid INT(20) NOT NULL
	, item VARCHAR(50) NOT NULL
	, price INT NOT NULL
	, FOREIGN KEY (restaurantid) REFERENCES restaurants(id)
);