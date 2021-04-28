CREATE TABLE addresses (
     id int NOT NULL AUTO_INCREMENT,
     city varchar(20) NOT NULL,
     street varchar(40) NOT NULL,
     house_number int NOT NULL,
     block int,
     appartment int,
     PRIMARY KEY(id)
     );
