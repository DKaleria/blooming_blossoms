<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Запись</title>
  <link rel="stylesheet" href="record-css.css">
</head>
<body>
<section class="layers">
  <div class="layers__container">
    <div class="layers__item layer-3">
      <div class="hero-content">
        <a href="#" style="text-decoration: none;">О нас</a>
        <a href="#" style="text-decoration: none;">Услуги</a>
        <a href="#" style="text-decoration: none;">Цены</a>
        <a href="#" style="text-decoration: none;">Мастера</a>
        <a href="#" style="text-decoration: none;" onclick="window.location.href='support.html';">Обратная связь</a>
      </div>
    </div>

    <div class="rounded-image">
      <div class="rounded-image img">
        <img src="images/record-imgs/right-img.png" alt="Правое-изображение">
      </div>
    </div>
    <h1 class=logo>
      <span class="part-1">Заказ</span>
    </h1>


  <div class="container">
    <form action="record" method="post">
      <div id="q1" class="question">
        <p>Имя</p>
        <input type="text" name="first_name" required class="input"><br>
      </div>

      <div id="q2" class="question">
        <p>Фамилия</p>
        <input type="text" name="last_name" required class="input"><br>
      </div>

      <div id="q3" class="question">
        <p>Адрес доставки</p>
        <input type="text" name="address_delivery" required class="input"><br>
      </div>

      <div id="q4" class="question">
        <p>Номер телефона</p>
        <input type="text" name="phone_number" required class="input"><br>
      </div>

      <div id="q6" class="question">
        <p>Дата заказа</p>
        <input type="datetime-local" name="order_date" required class="input"><br>
      </div>


      <div>
        <button type="submit" class="button-1">Заказать</button>
        <button type="button" onclick="clearAnswers()" class="button-2">Очистить</button>
      </div>
    </form>
  </div>

    <div id="modal" class="modal">
      <div class="modal-content">
        <span class="close">&times;</span>
        <p id="result"></p>
      </div>
    </div>
  </div>

  </div>
  <div class="layers__item layer-3">
    <div class="mini-logo">
      <span class="part-1">Blooming</span>
      <span class="part-2">blossoms</span>
    </div>
  </div>
</section>
<script src="js/record.js"></script>
</body>
</html>