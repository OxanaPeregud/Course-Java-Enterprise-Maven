DROP PROCEDURE IF EXISTS updateAddress;
CREATE PROCEDURE updateAddress(IN addressId INT,
                               OUT street_name VARCHAR(20),
                               OUT house_number INT,
                               OUT apartment_number INT)
BEGIN
UPDATE persondb.address
SET persondb.address.street = 'New address'
WHERE address_id = addressId;
SELECT persondb.address.street
INTO street_name
FROM persondb.address
WHERE persondb.address.address_id = addressId;
UPDATE persondb.address
SET persondb.address.house = persondb.address.house + 1
WHERE address_id = addressId;
SELECT persondb.address.house
INTO house_number
FROM persondb.address
WHERE persondb.address.address_id = addressId;
UPDATE persondb.address
SET persondb.address.apartment = persondb.address.apartment + 2
WHERE address_id = addressId;
SELECT persondb.address.apartment
INTO apartment_number
FROM persondb.address
WHERE persondb.address.address_id = addressId;
END;

SET @street = '1';
SELECT @street;

SET @house = 1;
SELECT @house;

SET @apartment = 1;
SELECT @apartment;

CALL updateAddress(2, @street, @house, @apartment);

SELECT @street, @house, @apartment;

DROP PROCEDURE IF EXISTS updateAge;
CREATE PROCEDURE updateAge(IN personId INT,
                           OUT person_age INT)
BEGIN
UPDATE persondb.person
SET persondb.person.age = persondb.person.age + 1
WHERE person_id = personId;
SELECT persondb.person.age
INTO person_age
FROM persondb.person
WHERE persondb.person.person_id = personId;
END;

SET @age = 1;
SELECT @age;

CALL updateAge(2, @age);

SELECT @age;

DROP PROCEDURE IF EXISTS deletePersonAddress;
CREATE PROCEDURE deletePersonAddress(IN personId INT,
                                     IN addressId INT)
BEGIN
DELETE
FROM personDB.person
WHERE person_id = personId;
DELETE
FROM personDB.address
WHERE address_id = addressId;
END;

DROP PROCEDURE IF EXISTS deleteAndUpdate;
CREATE PROCEDURE deleteAndUpdate(IN personId INT,
                                 IN addressId INT,
                                 OUT house_number INT,
                                 OUT apartment_number INT)
BEGIN
    DELETE
    FROM personDB.person
    WHERE person_id = personId;
    UPDATE persondb.address
    SET persondb.address.house = persondb.address.house + 1
    WHERE address_id = addressId;
    SELECT persondb.address.house
    INTO house_number
    FROM persondb.address
    WHERE persondb.address.address_id = addressId;
    UPDATE persondb.address
    SET persondb.address.apartment = persondb.address.apartment + 2
    WHERE address_id = addressId;
    SELECT persondb.address.apartment
    INTO apartment_number
    FROM persondb.address
    WHERE persondb.address.address_id = addressId;
END;
