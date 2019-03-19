<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>admin-api</title>
</head>
<body>
<div>
    Request weather for
    <form action="admin_api-0.1/" method="post">
        <input type="text" name="cityName" placeholder="City name">
        <input type="submit" value="Get">
    </form>
    <div>
        ${message}
    </div>
</div>
</body>
</html>