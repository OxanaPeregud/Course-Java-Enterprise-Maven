SELECT *
FROM persondb.person
ORDER BY first_name DESC;

SELECT *
FROM persondb.person
ORDER BY first_name;

SELECT *
FROM persondb.person
WHERE first_name LIKE 'David';

DELETE
FROM persondb.address
WHERE address_id LIKE 2;

SELECT *
FROM persondb.person
WHERE person_id % 2 = 0;

UPDATE personDB.person
SET age = 11
WHERE person_id = 4;

INSERT INTO personDB.person(first_name, last_name, age)
    VALUE ('Robert', 'Smith', 23);

SELECT DISTINCT first_name
FROM persondb.person;

SELECT AVG(age)
FROM persondb.person;

SELECT *
FROM persondb.person
WHERE age > (SELECT AVG(age) FROM persondb.person);

SELECT CONCAT(first_name, last_name) AS full_name
FROM persondb.person;
