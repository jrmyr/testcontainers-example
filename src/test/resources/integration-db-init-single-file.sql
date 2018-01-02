CREATE TABLE person (
	id int8 NOT NULL,
	prename varchar(64) NULL,
	lastname varchar(64) NULL,
	CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO person VALUES
(101,'Hans','Schmidt'),
(102,'Karl','Müller'),
(103,'Gustav','Müllershausen'),
(104,'Frank','Schmitz')
