DROP TABLE IF EXISTS `person`;

create table person (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    birthDay date not null,
    active boolean,
    city varchar(255),
      PRIMARY KEY (id)
);
