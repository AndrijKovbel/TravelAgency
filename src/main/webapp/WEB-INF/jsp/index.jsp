<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="css/index.css" rel="stylesheet">
    <title>Travel Agency</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Travel Agency</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <sec:authorize access="hasAnyRole('ADMIN')">
                    <a class="nav-link" href="form">Add new Tour <span class="sr-only">(current)</span></a>
                </sec:authorize>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="view">View All Tours</a>
            </li>
        </ul>
    </div>
    <sec:authorize access="hasAnyRole('ADMIN')">
        <div class="list_user">
            <a href="/admin">List of registered User</a>
        </div>
    </sec:authorize>
    <div>
        <a href="/logout">Logout</a>
    </div>
</nav>
</body>
<div class="mycarousel">
    <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="3"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="4"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="5"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="6"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="7"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="8"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="9"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="10"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="11"></li>
            <li data-target="#carouselExampleCaptions" data-slide-to="12"></li>
        </ol>
        <%-- NORWAY       --%>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://cdn.discover-the-world.com/app/uploads/2018/05/canada-alberta-northern-lights-treeline-ctc.jpg"
                     class="d-block w-100" alt="Northern Lights">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Happy New 2021 Year in Norway!</h5>
                    <p>Norway</p>
                </div>
            </div>

            <div class="carousel-item">
                <img src="https://www.arcticlodges.com/wp-content/uploads/2019/11/Where-to-See-Northern-Lights-in-Canada-1024x675.jpg"
                     class="d-block w-100" alt="Northern Lights">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Your Happy New Year 2021 in Norway</h5>
                    <p>Northern Lights</p>
                </div>
            </div>

            <div class="carousel-item">
                <img src="https://travel.mqcdn.com/mapquest/travel/wp-content/uploads/2020/10/shutterstock_401226754.jpg"
                     class="d-block w-100" alt="Northern Lights">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Don't lose this offer.Only today price 500$ per/people.</h5>
                    <p>Norway</p>
                </div>
            </div>

            <%--  SWEDEN  --%>
            <div class="carousel-item">
                <img src="https://i.ytimg.com/vi/iQqLvgmdhYE/maxresdefault.jpg"
                     class="d-block w-100" alt="Northern Lights">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Stockholm Old City and Metro</h5>
                    <p> Solna Centrum Station </p>
                </div>
            </div>

            <div class="carousel-item">
                <img src="https://www.visitstockholm.com/globalassets/inspirationssidor/tunnelbanefonster/stationer/t-centralen-liggande.png?preset=detail_big_retina"
                     class="d-block w-100" alt="Northern Lights">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Stockholm Old City and Metro</h5>
                    <p> T-Centralen Station</p>
                </div>
            </div>

            <div class="carousel-item">
                <img src="https://www.visitstockholm.com/globalassets/inspirationssidor/tunnelbanefonster/stationer/stadion-liggande.png?preset=detail_big_retina"
                     class="d-block w-100" alt="Northern Lights">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Stockholm Old City and Metro</h5>
                    <p> Stadion Station</p>
                </div>
            </div>

            <div class="carousel-item">
                <img src="https://www.visitstockholm.com/globalassets/inspirationssidor/tunnelbanefonster/stationer/morby-centrum-liggande.png?preset=detail_big_retina"
                     class="d-block w-100" alt="Northern Lights">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Stockholm Old City and Metro</h5>
                    <p> Mörby Centrum</p>
                </div>
            </div>

            <div class="carousel-item">
                <img src="https://www.visitstockholm.com/globalassets/inspirationssidor/tunnelbanefonster/stationer/nackrosen-bred.jpg?preset=detail_big_retina"
                     class="d-block w-100" alt="Northern Lights">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Stockholm Old City and Metro</h5>
                    <p> Morby Centrum</p>
                </div>
            </div>


            <%-- TURKEY  --%>
            <div class="carousel-item">
                <img src="https://www.thewholeworldisaplayground.com/wp-content/uploads/2018/04/Turkey-Cappadocia-Hotels-Balloon-View-5.jpg"
                     class="d-block w-100" alt="Turkey">
                <div class="carousel-caption d-none d-md-block">
                    <h5>If your tired you must be relax in Turkey! I think this is Awesome offer for 2021 summer</h5>
                    <p>Balloon Fest Kapadokya 2021</p>
                </div>
            </div>

            <div class="carousel-item">
                <img src="https://i4.hurimg.com/i/hurriyet/75/0x0/5e95fa0e2269a21b248f8c15.jpg"
                     class="d-block w-100" alt="Turkey">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Cappadocia is the place where over 100 hot ai balloons flying everyday.</h5>
                    <p> It’s like we have the fiesta everyday.</p>
                </div>
            </div>

            <div class="carousel-item">
                <img src="https://i.pinimg.com/originals/49/fc/fb/49fcfb48081b3b7d561da69a42b697e9.jpg"
                     class="d-block w-100" alt="Turkey">
                <div class="carousel-caption d-none d-md-block">
                    <h5>The Cappadocia International Hot-Air Balloon Festival, set for July 3-7, will be organized by
                        the Urgup Municipality in the central Nevsehir province.</h5>
                    <p>Balloon Fest Kapadokya 2021</p>
                </div>
            </div>


            <div class="carousel-item">
                <img src="https://www.thewholeworldisaplayground.com/wp-content/uploads/2018/04/Turkey-Cappadocia-Hotels-Balloon-View-5.jpg"
                     class="d-block w-100" alt="Turkey">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Cappadocia, one of Turkey's top destinations, has welcomed a record 3.7 million tourists in the
                        January-November period this year, according to official data.</h5>
                    <p>With the arrivals, the region crossed the 3-million threshold for the first time in history.</p>
                </div>
            </div>

            <div class="carousel-item">
                <img src="https://iadsb.tmgrup.com.tr/7bf791/1200/627/0/8/1000/530?u=https://idsb.tmgrup.com.tr/2019/12/15/1576423464866.jpg"
                     class="d-block w-100" alt="Turkey">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Balloon tours which contribution of 33 million euros ($37.1 million) to the
                        economy in 2016, 43 million euros in 2017, and 70 million euros in 2018 approximately 43
                        million euros in the first six months in 2018.</h5>
                    <p>With the arrivals, the region crossed the 3-million threshold for the first time in history.</p>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
        integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
        crossorigin="anonymous"></script>
</html>