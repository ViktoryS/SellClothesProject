<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <title>Registration</title>
</head>
<body>
<h1 align="center">Registration Form</h1>
<div>
    <span class="userMenu">${logInfo}</span>
    <div class="menuBar">
        <ul>
            <li><a href="home">Home</a></li>
            <li><a href="add">Add</a></li>
            <li><a href="list">DashBoard</a></li>
        </ul>
    </div>
</div>
<div align="center" class="tablesClass">
    <p class=${type}> ${message} </p>
    <p>Please, input the parameters:</p>
    <form method="post" action="registration">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>Login:</td>
                <td><input type="text" name="login"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>Repeat password:</td>
                <td><input type="password" name="repeatPassword"></td>
            </tr>
            <tr>
                <td><input type="submit" class="submit" name="addButton" value="Add"></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>