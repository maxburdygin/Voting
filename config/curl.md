### curl samples (application deployed at application context `voting`).
> For windows use `Git Bash`

### Curl samples for Users 

#### get All Users
`curl --location --request GET http://localhost:8080/voting/admin/users --user admin@gmail.com:admin`

#### get User 100001
`curl --location --request GET http://localhost:8080/voting/admin/users/100001 --user admin@gmail.com:admin`

#### get User by email        
`curl --location --request GET 'http://localhost:8080/voting/admin/users/by?email=user@yandex.ru' --user admin@gmail.com:admin`
    
#### create new User    
`curl --location --request POST 'http://localhost:8080/voting/admin/users' --user admin@gmail.com:admin \
--header 'Content-Type: application/json' \
--data-raw '{
        "name": "Vasya",
        "email": "vasya@yandex.ru",
        "password": "password",
        "roles": [
            "USER"
        ]
    }'`

#### update User 100001
`curl --location --request PUT 'http://localhost:8080/voting/admin/users/100001' --user admin@gmail.com:admin \
--header 'Content-Type: application/json' \
--data-raw '{
        "id": 100001,
        "name": "blabla",
        "email": "blablabla@yandex.ru",
        "password": "password",
        "roles": [
            "USER"
        ],
        "registered": 1598502240249
    }'`

#### delete User 100001
`curl --location --request DELETE http://localhost:8080/voting/admin/users/100001  --user admin@gmail.com:admin`



### Curl samples for Restaurants 

#### get All Restaurants
`curl --location --request GET 'http://localhost:8080/voting/admin/restaurants' --user admin@gmail.com:admin`

#### get Restaurant 100002
`curl --location --request GET 'http://localhost:8080/voting/admin/restaurants/100002' --user admin@gmail.com:admin`
  
#### create new Restaurant    
`curl --location --request POST 'http://localhost:8080/voting/admin/restaurants' --user admin@gmail.com:admin \
 --header 'Content-Type: application/json' \
 --data-raw '{
         "name": "The Best Restaurant Ever"
     }'`

#### update Restaurant 100003
`curl --location --request PUT 'http://localhost:8080/voting/admin/restaurants/100003' --user admin@gmail.com:admin \
 --header 'Content-Type: application/json' \
 --data-raw '{
         "id": 100003,
         "name": "KFC'\''s not good for you"
     }'`

#### delete Restaurant 100002
`curl --location --request DELETE 'http://localhost:8080/voting/admin/restaurants/100002' --user admin@gmail.com:admin`

### Curl samples for Meals 

#### get All Meals
`curl --location --request GET 'http://localhost:8080/voting/admin/meals' --user admin@gmail.com:admin`

#### get Meal 100009
`curl --location --request GET 'http://localhost:8080/voting/admin/meals/100009' --user admin@gmail.com:admin`

#### get Meals by Restaurant ID
`curl --location --request GET 'http://localhost:8080/voting/admin/meals/byRest?id=100003' --user admin@gmail.com:admin`

#### get Meals by Date
`curl --location --request GET 'http://localhost:8080/voting/admin/meals/byDate?date=2020-08-23' --user admin@gmail.com:admin`

#### get Meals by Restaurant ID and Date
`curl --location --request GET 'http://localhost:8080/voting/admin/meals/by?id=100003&date=2020-08-23' --user admin@gmail.com:admin`

#### create Meal
`curl --location --request POST 'http://localhost:8080/voting/admin/meals' --user admin@gmail.com:admin \
 --header 'Content-Type: application/json' \
 --data-raw '{
         "description": "McD The Most Expensive Meal",
         "price": 999.0,
         "localDate": [
             2020,
             8,
             23
         ],
         "restaurantId": 100002,
         "restaurantName": "McDonalds"
     }'`

#### update Meal 100013
`curl --location --request PUT 'http://localhost:8080/voting/admin/meals/100013' --user admin@gmail.com:admin \
 --header 'Content-Type: application/json' \
 --data-raw '{
         "id": 100013,
         "description": "Salmon Boke",
         "price": 330.0,
         "localDate": [
             2020,
             8,
             24
         ],
         "restaurantId": 100004,
         "restaurantName": "Sushi-Oki"
     }'`

#### delete Meal 100005
`curl --location --request DELETE 'http://localhost:8080/voting/admin/meals/100005' --user admin@gmail.com:admin`



### Curl samples for Votes 

#### get All Votes
`curl --location --request GET 'http://localhost:8080/voting/admin/votes' --user admin@gmail.com:admin`

#### get All Votes by Restaurant ID
`curl --location --request GET 'http://localhost:8080/voting/admin/votes/byRest?id=100003' --user admin@gmail.com:admin`

#### get All Votes by User ID
`curl --location --request GET 'http://localhost:8080/voting/admin/votes/byUser?id=100001' --user admin@gmail.com:admin`

#### get All Votes by Date
`curl --location --request GET 'http://localhost:8080/voting/admin/votes/byDate?date=2020-08-22' --user admin@gmail.com:admin`

#### delete Vote 100018   
`curl --location --request DELETE 'http://localhost:8080/voting/admin/votes/100018' --user admin@gmail.com:admin`