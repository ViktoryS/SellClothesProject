<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <title>Log In</title>
</head>
<body>
<h1 align="center">Log In</h1>
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
    <form method="post" action="login">
        <table>
            <tr>
                <td>Login:</td>
                <td><input type="text" name="j_username"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="j_password"></td>
            </tr>
            <tr>
                <td><input type="submit" class="submit" name="login" value="Log In"></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>