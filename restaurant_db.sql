CREATE DATABASE IF NOT EXISTS restaurant_db;

use restaurant_db;

DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS restaurant_category;

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
