-- The format of the createdAt and modifiedAt dates is 'AAAA-MM-DD HH:MM:SS', as can be seen,
-- for example, at https://springbootdev.com/2018/03/13/spring-data-jpa-auditing-with-createdby-createddate-lastmodifiedby-and-lastmodifieddate/
-- The exact name of the table fields can be seen at the H2 console
INSERT INTO MANUFACTURER (CODE, NAME) VALUES (100, 'Audi');
INSERT INTO MANUFACTURER (CODE, NAME) VALUES (101, 'Chevrolet');
INSERT INTO MANUFACTURER (CODE, NAME) VALUES (102, 'Ford');
INSERT INTO MANUFACTURER (CODE, NAME) VALUES (103, 'BMW');
INSERT INTO MANUFACTURER (CODE, NAME) VALUES (104, 'Dodge');

-- INSERT INTO CAR (ID, CREATED_AT, MODIFIED_AT, CONDITION, BODY, MODEL, MANUFACTURER_CODE, NUMBER_OF_DOORS,
--                FUEL_TYPE, ENGINE, MILEAGE, MODEL_YEAR, PRODUCTION_YEAR, EXTERNAL_COLOR,
--                LAT, LON)
--        VALUES (1, '2018-06-01 15:46:36.951', '2018-06-01 15:46:36.951', 'USED', 'sedan', 'Impala', 101,
--                4, 'Gasoline', '3.6L V6', 32280, 2018, 2018, 'white', 40.73061, -73.935242);