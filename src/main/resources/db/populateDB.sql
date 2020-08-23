DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM restaurants;
DELETE FROM users;
DELETE FROM votes;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
        ('USER', 100001),
       ('ADMIN', 100001);

INSERT INTO restaurants (name, votes)
VALUES ('McDonalds', 0),
       ('KFC', 0),
       ('Sushi-Oki', 0);

INSERT INTO meals (description, price, local_date, restaurant_id)
VALUES ('McD Happy Meal', 150.0, '2020-08-22', 100002),
       ('McD UnHappy Meal', 250.0, '2020-08-23', 100002),
       ('McD Tripple HamBurger', 220.0, '2020-08-21', 100002),
       ('KFC Chicken McNuggets', 180.0, '2020-08-22', 100003),
       ('KFC Chicken Bresasts', 190.0, '2020-08-23', 100003),
       ('KFC Chicken Bucket', 390.0, '2020-08-21', 100003),
       ('California Roll', 260.0, '2020-08-22', 100004),
       ('Philadelphia Roll', 270.0, '2020-08-23', 100004),
       ('Salmon Boke', 280.0, '2020-08-21', 100004);

INSERT INTO votes (local_date, user_id, restaurant_id)
VALUES ('2020-08-21', 100000, 100002),
       ('2020-08-21', 100001, 100003),
       ('2020-08-22', 100000, 100004),
       ('2020-08-22', 100001, 100003),
       ('2020-08-23', 100001, 100003);
