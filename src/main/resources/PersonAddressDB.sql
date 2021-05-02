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

SELECT *
FROM persondb.person,
     persondb.address,
     persondb.person_address
WHERE persondb.person_address.person_id = persondb.person.person_id
  AND persondb.person_address.address_id = persondb.address.address_id;

SELECT persondb.person.last_name, persondb.address.street
FROM persondb.person,
     persondb.address,
     persondb.person_address
WHERE persondb.person_address.person_id = persondb.person.person_id
  AND persondb.person_address.address_id = persondb.address.address_id
  AND persondb.person.age > 18;

SELECT persondb.person.first_name, persondb.person.age
FROM persondb.person
WHERE persondb.person.age BETWEEN 20 AND 30;

SELECT persondb.person.age,
       CASE
           WHEN persondb.person.age > 20 AND persondb.person.age < 25 THEN 'Result_1'
           WHEN persondb.person.age > 25 AND persondb.person.age < 30 THEN 'Result_2'
           ELSE 'Result_3'
           END
FROM persondb.person;

SELECT persondb.person.first_name
FROM persondb.person
WHERE persondb.person.first_name IS NULL;

SELECT persondb.address.apartment
FROM persondb.address
LIMIT 2;

SELECT persondb.address.street
FROM persondb.address
WHERE persondb.address.street = 'Bowery'
   OR persondb.address.street = 'Broadway';

SELECT persondb.person.person_id,
       persondb.person.last_name,
       persondb.person.first_name,
       persondb.address.street,
       persondb.address.house,
       persondb.address.apartment
FROM persondb.person
         LEFT OUTER JOIN persondb.person_address
                         ON persondb.person.person_id = persondb.person_address.person_id
         LEFT OUTER JOIN persondb.address
                         ON persondb.person_address.address_id = persondb.address.address_id;

DROP VIEW IF EXISTS persondb.person_address_view;
CREATE VIEW persondb.person_address_view AS
SELECT persondb.person.last_name,
       persondb.person.first_name,
       persondb.address.street
FROM persondb.person,
     persondb.address,
     persondb.person_address
WHERE persondb.person_address.person_id = persondb.person.person_id
  AND persondb.person_address.address_id = persondb.address.address_id;

SELECT persondb.person.last_name AS temp1,
       persondb.person.age       AS temp2
FROM persondb.person
WHERE persondb.person.age IN (20, 73)
UNION
SELECT persondb.address.street,
       persondb.address.house
FROM persondb.address
WHERE persondb.address.apartment IN (104, 220);

SELECT persondb.person.first_name,
       persondb.person.last_name,
       persondb.address.street
FROM persondb.person
         JOIN persondb.person_address
              ON persondb.person.person_id = persondb.person_address.person_id
         JOIN persondb.address
              ON persondb.address.address_id = persondb.person_address.address_id;
