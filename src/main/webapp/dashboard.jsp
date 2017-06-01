<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <title>Dashboard</title>
</head>
<body>

<h1 align="center">DashBoard</h1>
<div>
    <span class="userMenu"><a href="registration">Registration</a> | <a href="login">Log In</a></span>
    <div class="menuBar">
        <ul>
            <li><a href="home">Home</a></li>
            <li><a href="add">Add</a></li>
            <li><a href="list">DashBoard</a></li>
        </ul>
    </div>
</div>
<div align="center" class="tablesClass">
    <p class=${type}>${message}</p>
    <form method="get" action="search">
        <input type="text" name="name" value=""/>
        <input type="submit" class="submit" value="Search"/>
    </form>

    <table class="clothBoard">
        <tr>
            <th>#</th>
            <th>Title</th>
            <th>Size</th>
            <th>Price</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="cloth" items="${listOfClothes}" >
            <tr>
                <td>${cloth.id}</td>
                <td>${cloth.name}</td>
                <td>${cloth.size}</td>
                <td>${cloth.price}</td>
                <td width="15%">
                    <form method="get" action="delete">
                        <input type="hidden" name="deleteCloth" value="${cloth.id}">
                        <input type="submit" class="submit" name="deleteCloth" value="Delete"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>