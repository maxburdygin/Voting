<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Meal</title>
    <style>
        dl {
            background: none repeat scroll 0 0 #FAFAFA;
            margin: 8px 0;
            padding: 0;
        }

        dt {
            display: inline-block;
            width: 170px;
        }

        dd {
            display: inline-block;
            margin-left: 8px;
            vertical-align: top;
        }
    </style>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <hr>
    <h2>${param.action == 'create' ? 'Create meal' : 'Edit meal'}</h2>
    <jsp:useBean id="meal" type="com.petproject.voting.model.Meal" scope="request"/>
    <form method="post" action="meals">
        <input type="hidden" name="id" value="${meal.id}">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${meal.name}" size=40 name="name" required></dd>
        </dl>
        <dl>
            <dt>Restaurant Id:</dt>
            <dd><input type="number" value="${meal.restaurantId}" name="restaurantId" required></dd>
        </dl>
        <dl>
            <dt>Price:</dt>
            <dd><input type="number" value="${meal.price}" name="price" required></dd>
        </dl>
        <dl>
            <dt>Date:</dt>
            <dd><input type="datetime-local" value="${meal.localDate}" name="localDate" required></dd>
        </dl>

        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</section>
</body>
</html>
