<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <title>Add Cloth</title>
</head>
<body>
<h1 align="center">Add Cloth</h1>
<div>
    <span class="userMenu"><a href="registration">Registration</a> | Sigh In</span>
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
    <form method="post" action="add">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Size:</td>
                <td><input type="text" name="size"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="price"></td>
            </tr>
            <tr>
                <td><input type="submit" class="submit" name="addButton" value="Add"></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>