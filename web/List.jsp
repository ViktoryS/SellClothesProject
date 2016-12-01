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
        <li><a href="/home">Home</a></li>
        <li><a href="/add">Add</a></li>
        <li><a href="/list">DashBoard</a></li>
    </ul>
</div>
<div align="center" class="tablesClass">
    <p class=${type}>${message}</p>
    <input type="text" value=""/>
    <input type="button" class="submit" value="Search"/>
    <table class="clothBoard">
        <tr>
            <th>#</th>
            <th>Title</th>
            <th>Size</th>
            <th>Price</th>
            <th></th>
        </tr>
        <c:forEach items="${listOfClothes}" var="cloth">
            <tr>
                <td>1</td>
                <td>${cloth.getName()}</td>
                <td>${cloth.getSize()}</td>
                <td>${cloth.getPrice()}</td>
                <td>Delete</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>