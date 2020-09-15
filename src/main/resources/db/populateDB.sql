DELETE FROM user_role;
DELETE FROM dish;
DELETE FROM restaurant;
DELETE FROM users;
DELETE FROM vote;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_role (role, user_id)
VALUES ('USER', 100000),
        ('USER', 100001),
       ('ADMIN', 100001);

INSERT INTO restaurant (name)
VALUES ('McDonalds'),
       ('KFC'),
       ('Sushi-Oki');

INSERT INTO dish (description, price, local_date, restaurant_id)
VALUES ('McD Happy Dish', 150.0, '2020-08-22', 100002),
       ('McD UnHappy Dish', 250.0, '2020-08-23', 100002),
       ('McD Tripple HamBurger', 220.0, '2020-08-21', 100002),
       ('KFC Chicken McNuggets', 180.0, '2020-08-22', 100003),
       ('KFC Chicken Bresasts', 190.0, '2020-08-23', 100003),
       ('KFC Chicken Bucket', 390.0, '2020-08-21', 100003),
       ('California Roll', 260.0, '2020-08-22', 100004),
       ('Philadelphia Roll', 270.0, '2020-08-23', 100004),
       ('Salmon Boke', 280.0, '2020-08-21', 100004);

INSERT INTO vote (local_date, user_id, restaurant_id)
VALUES ('2020-08-21', 100000, 100002),
       ('2020-08-21', 100001, 100003),
       ('2020-08-22', 100000, 100004),
       ('2020-08-22', 100001, 100003),
       ('2020-08-23', 100001, 100003);
