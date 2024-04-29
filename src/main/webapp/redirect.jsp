<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Blooming blossoms</title>
    <link rel="stylesheet" href="main.css">
</head>
<body>

<section class="layers">
    <div class="layers__container">
        <div class="layers__item layer-1" style="background-image: url(images/background/Main2.jpg);"></div>
        <div class="layers__item layer-3">
            <div class="hero-content">
                <a href="#" style="text-decoration: none;">О нас</a>
                <a href="#" style="text-decoration: none;">Цены</a>
                <a href="#" style="text-decoration: none;">Оплата</a>
                <a href="html/support.html" style="text-decoration: none;">Обратная связь</a>
                <a href="reviews.jsp" style="text-decoration: none;">Отзывы</a>
            </div>
        </div>

        <div class="layers__item layer-3">
            <div class="logo">
                <span class="part-1">Blooming</span>
                <span class="part-2">blossoms</span>
            </div>
            <form action="redirect" method="post">
                <input type="hidden" name="page" value="categories"/>
                <button type="submit" class="button-start">ПЕРЕЙТИ В КАТАЛОГ</button>
            </form>
        </div>
    </div>
</section>
<h1 class="text-h1">О нас</h1>
<div class="container">
    <div class="text">
        <span>
            Наш интернет-магазин занимается продажей цветов, букетов и подарков с доставкой на дом.
            У нас ежедневные поставки цветов, поэтому вы можете не сомневаться, что цветы будут свежими
            и радовать получателя долгое время.
            В современном ритме жизни не всегда есть возможность выделить время на посещение магазина цветов.
            Мы учли данный факт и организовали возможность покупки через интернет.</span>
    </div>
    <div class="rounded-image">
        <img src="images/background/photo_2024-04-29_01-12-49.jpg" alt="Изображение">
    </div>
</div>

<section class="layers">
    <div class="layers__container">
        <div class="center-image" style="background-image: url(images/background/MainHalf.png);">
            <div class="container-02" style="background-image: url(images/background/розкр.jpg);">
                <h2 class="text-h2">101 роза -30%</h2>
                <button class="button-record" onclick="window.location.href='record.jsp';">Заказать</button>
            </div>

            <div class="container-02" style="background-image: url(images/background/альстр.jpg);">
                <h2 class="text-h2" style="margin-left: 115px">Альстромерия</h2>
                <h2 class="text-h2" style="margin-left: 175px; margin-top: -10px">от 11 шт -15%</h2>
                <button class="button-record" onclick="window.location.href='record.jsp';"
                        style="margin-top: 310px">Заказать
                </button>
            </div>

            <div class="container-02" style="background-image: url(images/background/пионы.jpg);">
                <h2 class="text-h2">Пионы</h2>
                <h2 class="text-h2" style="margin-left: 175px; margin-top: -10px">от 25 шт -20%</h2>
                <button class="button-record" onclick="window.location.href='record.jsp';">Заказать</button>
            </div>

            <div class="container-02" style="background-image: url(images/background/белроз.jpg);">
                <h2 class="text-h2">Розы</h2>
                <h2 class="text-h2" style="margin-left: 175px; margin-top: -10px">от 51 шт -25%</h2>
                <button class="button-record" onclick="window.location.href='record.jsp';">Заказать</button>
            </div>


        </div>

        <h1 class=logo-2>
            <span class="part-3">Акции</span>
        </h1>
    </div>
</section>


<section class="layers">
    <div class="layers__container">
        <div class="layers__item-02 layer-1">
            <div class="center-image" style="background-color: #6260B3;">
                <div class="container-03" style="background-image: url(images/main-imgs/green.png);">
                </div>
            </div>
            <div class="layers__item-02 layer-3">
                <div class="container-02"></div>
                <h1 class=logo-2>
                    <span class="part-3" style="margin-left: 660px">Адреса</span>
                </h1>

                <h3 class="work">
                    <p>
                        г.Гродно, пл. Советская 2А
                    </p>

                    <p>
                        г.Гродно, ул. Тимирязева 8 (ТЦ «Евроопт»)
                    </p>

                    <p>
                        г.Гродно, ул. Я.Купалы 87 (ТРК «TRINITI»)
                    </p>

                    <p>
                        г.Гродно, ул.Дубко 17 (ТЦ «Old City»)
                    </p>

                    <p>
                        г. Гродно, ул. Огинского (ТЦ «Парус»)
                    </p>


                </h3>

                <h3 class="work">
                    <p>
                        +375 (33) 399-26-30
                        9:00 — 21:00
                    </p>

                    <p>
                        +375 (33) 399-26-05
                        9:00 — 21:00
                    </p>

                    <p>

                    </p>

                    <p>

                        +375 (33) 379-95-79
                        10:00 — 22:00
                    </p>
                    <p>
                        +375 (33) 399-26-07
                        Пн-Чт 10:00 — 21:00
                        Пт-Сб 10:00 — 22:00
                        Вс 10:00 — 21:00
                    </p>
                    <p>
                        +375 (33) 399-26-06
                        Пн-Чт 10:00 — 21:00
                        Пт-Сб 10:00 — 22:00
                        Вс 10:00 — 21:00
                    </p>

                </h3>
            </div>
        </div>
    </div>
</section>

<section class="layers">
    <div class="layers__container">
        <div class="layers__item-02 layer-1">
            <div class="layers__item-02 layer-3">
                <h1 class=logo-2 style="margin-left: -100px">
                    <span class="part-3">Наши мастера</span>
                </h1>
            </div>
            <div class="container-04" style="background-image: url(images/main-imgs/педикюр.png);">
            </div>
            <div style="font-family: manrope">
                <p>Анна</p>
                <p>Специализация:</p>
                <p>флорист</p>
            </div>

            <div class="container-04" style="background-image: url(images/main-imgs/ресницы.png);">
            </div>
            <div style="font-family: manrope">
                <p>Наталья</p>
                <p>Специализация:</p>
                <p>консультант по цветам</p>
            </div>

            <div class="container-04" style="background-image: url(images/main-imgs/маникюр.png);">
            </div>
            <div style="font-family: manrope">
                <p>Мария</p>
                <p>Специализация:</p>
                <p>мастер по оформлению букетов</p>
            </div>

            <div class="container-04" style="background-image: url(images/main-imgs/макияж.png);">
            </div>
            <div style="font-family: manrope">
                <p>Ольга</p>
                <p>Специализация:</p>
                <p>мастер по созданию цветочных аксессуаров</p>
            </div>


        </div>

    </div>
    <div class="layers__container">
        <div class="layers__item layer-1" style="background-image:  url(images/main-imgs/123.png);"></div>
        <div class="layers__item layer-3">
            <div class="hero-content">
                <a href="#" style="text-decoration: none;">О нас</a>
                <a href="#" style="text-decoration: none;">Цены</a>
                <a href="#" style="text-decoration: none;">Оплата</a>
                <a href="html/support.html" style="text-decoration: none;">Обратная связь</a>
                <a href="reviews.jsp" style="text-decoration: none;">Отзывы</a>
            </div>
        </div>

        <div class="layers__item layer-3">
            <div class="mini-logo">
                <span class="part-1">Blooming</span>
                <span class="part-2">blossoms</span>
            </div>
        </div>
    </div>

</section>


</body>
</html>