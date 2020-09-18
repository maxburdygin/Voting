
###Build a voting system for deciding where to have lunch.

2 types of users: admin and regular users
Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
Menu changes each day (admins do the updates)
Users can vote on which restaurant they want to have lunch at
Only one vote counted per user
If user votes again the same day:
If it is before 11:00 we asume that he changed his mind.
If it is after 11:00 then it is too late, vote can't be changed
Each restaurant provides new menu each day.

You may find curl commands in "config/curl.md"

####List of URL's available for users:

    "voting/dishes"         no params       GET     returns the list of all dishes available for today
    "voting/dishes/byRest" (Param int id)   GET     returns the list of all dishes cooked by chosen restaurant available for today
    "voting/restaurants"    no params       GET     returns the list of all restaurants with the dishes available for today
    "voting/votes"          no params       GET     returns the list of votes of the authorised user
    "voting/votes"          (VoteTo)        POST    creates a vote
    "voting/votes/{id}"     (Param int restaurantId)    PUT updates the vote {id}

####List of URL's available for admins:

    "voting/admin/dishes"         no params       GET     returns the list of all dishes ever available
    "voting/admin/dishes"         (DishTo)        POST    creates the dish
    "voting/admin/dishes/{id}"    (DishTo)        PUT     updates the dish with the id
    "voting/admin/dishes/{id}"    no params       GET     returns the dish with the id
    "voting/admin/dishes/{id}"    no params       DELETE  deletes the dish with the id
    "voting/admin/dishes/byRest"  (Param int id)                      GET     returns the list of all dishes ever cooked by chosen restaurant
    "voting/admin/dishes/byDate"  (Param LocalDate date)              GET     returns the list of all dishes cooked by chosen date
    "voting/admin/dishes/by"      (Params {int id, LocalDate date})   GET     returns the list of all dishes cooked by chosen restaurant by date
    
    "voting/admin/restaurants"         no params       GET     returns the list of all restaurants
    "voting/admin/restaurants"         (Restaurant)        POST    creates the restaurant
    "voting/admin/restaurants/{id}"    (Restaurant)        PUT     updates the restaurant with the id
    "voting/admin/restaurants/{id}"    no params       GET     returns a restaurant with the id
    "voting/admin/restaurants/today"   no params       GET     returns the restaurants with their dishes for today
    "voting/admin/restaurants/{id}"    no params       DELETE  deletes a restaurant with the id
    
    "voting/admin/users"         no params     GET     returns the list of all users
    "voting/admin/users/by"      String email  GET     returns a user with the eamil
    "voting/admin/users"         (User)        POST    creates the user
    "voting/admin/users/{id}"    (User)        PUT     updates the user with the id
    "voting/admin/users/{id}"    no params     GET     returns the user with the id
    "voting/admin/users/{id}"    no params     DELETE  deletes the user with the id
    
    "voting/admin/votes"         no params     GET     returns the list of all users
    "voting/admin/votes/byRest"  int id        GET     returns the list of votes for the restaurant with the id
    "voting/admin/votes/byDate" LocalDate date GET     returns the list of votes for the date
    "voting/admin/votes/byUser"  int id        GET     returns the list of votes made by user with the id
    "voting/admin/votes/{id}"    no params     GET     returns the user with the id
    "voting/admin/votes/{id}"    no params     DELETE  deletes the user with the id
    
    
   