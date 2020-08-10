DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM restaurants;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO restaurants (id, name, votes)
VALUES (100002, 'McDonalds', 1),
       (100003, 'KFC', 1),
       (100004, 'Sushi-Oki', 1);

/*=========Up to here everything is good!!!============*/

INSERT INTO meals (name, price, local_date, restaurant_id)
VALUES ('McD Happy Meal', 150.0, '2020-01-30 13:00:00', 100002),
       ('McD UnHappy Meal', 250.0, '2020-01-30 13:00:00', 100002),
       ('McD Tripple HamBurger', 220.0, '2020-01-30 13:00:00', 100002),
       ('KFC Chicken McNuggets', 180.0, '2020-01-30 13:00:00', 100003),
       ('KFC Chicken Bresasts', 190.0, '2020-01-30 13:00:00', 100003),
       ('KFC Chicken Bucket', 390.0, '2020-01-30 13:00:00', 100003),
       ('California Roll', 260.0, '2020-01-30 13:00:00', 100004),
       ('Philadelphia Roll', 270.0, '2020-01-30 13:00:00', 100004),
       ('Salmon Boke', 280.0, '2020-01-30 13:00:00', 100004);