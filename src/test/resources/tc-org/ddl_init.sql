CREATE TABLE person (
	id int8 NOT NULL,
	prename varchar(64) NULL,
	lastname varchar(64) NULL,
	CONSTRAINT person_pkey PRIMARY KEY (id)
);

COPY person FROM '/docker-entrypoint-initdb.d/dml_person.csv' DELIMITER ',' CSV HEADER;
