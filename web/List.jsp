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
<div class="menuBar">
    <ul>
        <li><a href="home">Home</a></li>
        <li><a href="add">Add</a></li>
        <li><a href="list">DashBoard</a></li>
    </ul>
</div>
<div align="center" class="tablesClass">
    <p class=${type}>${message}</p>
    <form method="get" action="search">
        <input type="text" value=""/>
        <input type="button" class="submit" value="Search"/>
    </form>
    <form method="get" action="delete">
        <table class="clothBoard">
            <tr>
                <th>#</th>
                <th>Title</th>
                <th>Size</th>
                <th>Price</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${listOfClothes}" var="cloth">
                <tr>
                    <td>1</td>
                    <td>${cloth.getName()}</td>
                    <td>${cloth.getSize()}</td>
                    <td>${cloth.getPrice()}</td>
                    <td><input type="checkbox" name="deleteClothes" value=${cloth.getName()}/></td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" class="submit" value="Refresh">
    </form>
</div>
</body>
</html>