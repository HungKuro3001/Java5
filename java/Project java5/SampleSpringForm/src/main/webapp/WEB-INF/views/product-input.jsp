<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form method="post" action="/new-product">
    <div>
        <label for="name">Name</label>
        <input type="text" name="name" id="name">
    </div>
    <div>
        <label for="price">Price</label>
        <input type="text" name="price" id="price">
    </div>
    <div>
        <label for="quantity">Quantity</label>
        <input type="text" name="quantity" id="quantity">
    </div>
    <div>
        <button type="submit">Create</button>
    </div>

</form>
</body>
</html>