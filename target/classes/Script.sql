-- Script para crear la tabla Person
CREATE TABLE person (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(20) NOT NULL DEFAULT '',
  country varchar(20) DEFAULT NULL,
  PRIMARY KEY (id)
); 