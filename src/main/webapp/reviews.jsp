<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Blooming blossoms</title>
  <link rel="stylesheet" href="main.css">
</head>
<body>
  <h1>Leave a Review</h1>
  <form action="reviews" method="post">
    <label for="comment">Comment:</label>
    <textarea id="comment" name="comment" required></textarea><br>

    <label for="rating">Rating:</label>
    <select id="rating" name="rating" required>
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
      <option value="4">4</option>
      <option value="5">5</option>
    </select><br>

    <label for="birthday">Birthday:
    <input type="date" name="birthday" id="birthday">
    <label for="orders_product_id">Ordered Product ID:</label>
    <input type="number" id="orders_product_id" name="orders_product_id" required><br>

    <button type="submit" class="button-record">Submit</button>
  </form>
</body>
</html>