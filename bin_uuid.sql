USE student_service_uuid;

INSERT INTO `student_service_uuid`.`student_uuid`(`id`, `firstName`, `lastName`, `age`)VALUES(UUID_TO_BIN('3f06af63-a93c-11e4-9797-00505690773f', true),'firstName','lastName','10');
SELECT * FROM `student_service_uuid`.`student_uuid`;

SELECT HEX(id) AS id, firstName, lastName, age FROM `student_service_uuid`.`student_uuid`;