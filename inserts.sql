use efka;

INSERT INTO specialties
VALUES
(1,'Anesthesiology'),
(2,'Cardiology'),
(3,'Dermatology'),
(4,'Nephrology'),
(5,'Pathology');

INSERT INTO users
VALUES
(1,0,'$2a$10$sjuSWjL5HuIqWfzPkLnMY.xN8vhajFtNGCa/JzXvR9LTFUhf0xS5G','doctor1'),
(2,0,'$2a$10$sjuSWjL5HuIqWfzPkLnMY.xN8vhajFtNGCa/JzXvR9LTFUhf0xS5G','doctor2'),
(3,0,'$2a$10$sjuSWjL5HuIqWfzPkLnMY.xN8vhajFtNGCa/JzXvR9LTFUhf0xS5G','doctor3'),
(4,0,'$2a$10$sjuSWjL5HuIqWfzPkLnMY.xN8vhajFtNGCa/JzXvR9LTFUhf0xS5G','doctor4'),
(5,0,'$2a$10$sjuSWjL5HuIqWfzPkLnMY.xN8vhajFtNGCa/JzXvR9LTFUhf0xS5G','doctor5'),
(6,0,'$2a$10$sjuSWjL5HuIqWfzPkLnMY.xN8vhajFtNGCa/JzXvR9LTFUhf0xS5G','doctor6'),
(7,0,'$2a$10$sjuSWjL5HuIqWfzPkLnMY.xN8vhajFtNGCa/JzXvR9LTFUhf0xS5G','doctor7'),
(8,0,'$2a$10$sjuSWjL5HuIqWfzPkLnMY.xN8vhajFtNGCa/JzXvR9LTFUhf0xS5G','doctor8'),
(9,0,'$2a$10$sjuSWjL5HuIqWfzPkLnMY.xN8vhajFtNGCa/JzXvR9LTFUhf0xS5G','doctor9'),
(10,0,'$2a$10$sjuSWjL5HuIqWfzPkLnMY.xN8vhajFtNGCa/JzXvR9LTFUhf0xS5G','doctor10');

INSERT INTO doctors
VALUES 
(1,'doctor1@gmail.com','Thodoris','6911111111','Karolidis',1,1),
(2,'doctor2@gmail.com','Thanasis','6922222222','Bilero',2,2),
(3,'doctor3@gmail.com','Hlias','6933333333','Papadopoulos',3,3),
(4,'doctor4@gmail.com','Korina','6944444444','Chatzigeorgiou',4,4),
(5,'doctor5@gmail.com','Patroklos','6955555555','Papapetrou',5,5),
(6,'doctor6@gmail.com','Xristos','6966666666','Argyriadis',5,6),
(7,'doctor7@gmail.com','Giorgos','6977777777','Tzinos',4,7),
(8,'doctor8@gmail.com','Ioannis','6988888888','Xatzinikolaou',3,8),
(9,'doctor9@gmail.com','Maria','6999999999','Korinthiou',2,9),
(10,'doctor10@gmail.com','Dimitra','6900000000','Ioannou',1,10);

select * from users;
select * from citizens;
select * from doctors;
select * from specialties;
select * from appointments;
