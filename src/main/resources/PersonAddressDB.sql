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

INSERT INTO personDB.person(first_name, last_name, age, address_id)
    VALUE ('Robert', 'Smith', 23, 5);

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
FROM persondb.person
         LEFT JOIN persondb.address
                   ON persondb.person.address_id = persondb.address.address_id;

SELECT persondb.person.last_name, persondb.address.street
FROM persondb.person
         INNER JOIN persondb.address
                    ON persondb.person.address_id = persondb.address.address_id;

SELECT count(*)
FROM persondb.person;

SELECT *
FROM persondb.person
ORDER BY persondb.person.last_name
LIMIT 3 OFFSET 1;

SELECT *
FROM persondb.person
WHERE persondb.person.address_id IN (2, 3);

SELECT *
FROM persondb.address
WHERE persondb.address.street IN ('Bowery', 'Canal Street');

SELECT max(persondb.person.age)
FROM persondb.person;

SELECT min(persondb.person.age)
FROM persondb.person;

SELECT persondb.address.street, persondb.address.house
FROM persondb.address
WHERE persondb.address.address_id LIKE 3;

SELECT *
FROM persondb.person
WHERE persondb.person.last_name = 'Smith'
  AND persondb.person.first_name NOT IN ('Robert', 'James')
  AND persondb.person.age > 20;

SELECT persondb.person.last_name,
       count(persondb.person.person_id)
           AS number_of_same_last_name
FROM persondb.person
GROUP BY persondb.person.last_name;

SELECT persondb.person.last_name,
       count(persondb.person.person_id)
           AS number_of_same_last_name
FROM persondb.person
GROUP BY persondb.person.last_name
HAVING count(persondb.person.person_id) >= 2;

SELECT *
FROM persondb.person
         JOIN persondb.address
              ON persondb.person.address_id = persondb.address.address_id
WHERE persondb.person.person_id > 5;

SELECT persondb.person.person_id, persondb.address.street
FROM persondb.person
         JOIN persondb.address
              ON persondb.person.address_id = persondb.address.address_id;

SELECT persondb.person.last_name, persondb.address.street
FROM persondb.person
         LEFT OUTER JOIN persondb.address
                         ON persondb.person.address_id = persondb.address.address_id;

DROP VIEW IF EXISTS persondb.person_address;
CREATE VIEW persondb.person_address AS
SELECT persondb.person.person_id,
       first_name,
       last_name,
       age,
       persondb.address.street,
       house,
       apartment
FROM persondb.person,
     persondb.address
WHERE persondb.person.address_id = persondb.address.address_id;

SELECT *, MAX(age)
FROM persondb.person
GROUP BY persondb.person.last_name
ORDER BY MAX(age);
