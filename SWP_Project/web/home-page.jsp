<%-- 
    Document   : home-page
    Created on : May 19, 2023, 2:56:16 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" href="style/style_homepage.css"/>
        <link rel="stylesheet" href="style/swiper-bundle.min.css"/>
    </head>

    <%@ include file="/includes/header.jsp" %>

    <div class="single-slide">
        <div class="banner">
            <div class="intro_banner">
                <h1>WELCOME TO OUR ALL CLUBS</h1>
                <h3>We hope that you will have the best possible experience here.</h3>
            </div>
            <div class="slide_banner">
                <img src="background.jpg" width="1475px" height="725px" alt="banner_img"/>
            </div>
        </div>

        <div class="swapper">
            <div class="slide-container swiper">
                <div class="slide-content">
                    <div class="card-wrapper swiper-wrapper">
                        <div class="card swiper-slide">
                            <div class="image-content">
                                <span class="overlay"></span>
                                <div class="card-image">
                                    <img class="card-img" src="images/club_1.jpg" alt="club1"/>
                                </div>
                            </div>
                            <div class="card-content">
                                <h2 class="name">IT Club</h2>
                                <p class="description">IT clubs is ...................................</p>
                                <button class="button">View detail</button>
                            </div>
                        </div>
                        <div class="card swiper-slide">
                            <div class="image-content">
                                <span class="overlay"></span>
                                <div class="card-image">
                                    <img class="card-img" src="images/club_1.jpg" alt="club1"/>
                                </div>
                            </div>
                            <div class="card-content">
                                <h2 class="name">IT Club</h2>
                                <p class="description">IT clubs is ...................................</p>
                                <button class="button">View detail</button>
                            </div>
                        </div>
                        <div class="card swiper-slide">
                            <div class="image-content">
                                <span class="overlay"></span>
                                <div class="card-image">
                                    <img class="card-img" src="images/club_1.jpg" alt="club1"/>
                                </div>
                            </div>
                            <div class="card-content">
                                <h2 class="name">IT Club</h2>
                                <p class="description">IT clubs is ...................................</p>
                                <button class="button">View detail</button>
                            </div>
                        </div>
                        <div class="card swiper-slide">
                            <div class="image-content">
                                <span class="overlay"></span>
                                <div class="card-image">
                                    <img class="card-img" src="images/club_1.jpg" alt="club1"/>
                                </div>
                            </div>
                            <div class="card-content">
                                <h2 class="name">IT Club</h2>
                                <p class="description">IT clubs is ...................................</p>
                                <button class="button">View detail</button>
                            </div>
                        </div>
                        <div class="card swiper-slide">
                            <div class="image-content">
                                <span class="overlay"></span>
                                <div class="card-image">
                                    <img class="card-img" src="images/club_1.jpg" alt="club1"/>
                                </div>
                            </div>
                            <div class="card-content">
                                <h2 class="name">IT Club</h2>
                                <p class="description">IT clubs is ...................................</p>
                                <button class="button">View detail</button>
                            </div>
                        </div>
                        <div class="card swiper-slide">
                            <div class="image-content">
                                <span class="overlay"></span>
                                <div class="card-image">
                                    <img class="card-img" src="images/club_1.jpg" alt="club1"/>
                                </div>
                            </div>
                            <div class="card-content">
                                <h2 class="name">IT Club</h2>
                                <p class="description">IT clubs is ...................................</p>
                                <button class="button">View detail</button>
                            </div>
                        </div>
                        <div class="card swiper-slide">
                            <div class="image-content">
                                <span class="overlay"></span>
                                <div class="card-image">
                                    <img class="card-img" src="images/club_1.jpg" alt="club1"/>
                                </div>
                            </div>
                            <div class="card-content">
                                <h2 class="name">IT Club</h2>
                                <p class="description">IT clubs is ...................................</p>
                                <button class="button">View detail</button>
                            </div>
                        </div>
                        <div class="card swiper-slide">
                            <div class="image-content">
                                <span class="overlay"></span>
                                <div class="card-image">
                                    <img class="card-img" src="images/club_1.jpg" alt="club1"/>
                                </div>
                            </div>
                            <div class="card-content">
                                <h2 class="name">IT Club</h2>
                                <p class="description">IT clubs is ...................................</p>
                                <button class="button">View detail</button>
                            </div>
                        </div>
                        <div class="card swiper-slide">
                            <div class="image-content">
                                <span class="overlay"></span>
                                <div class="card-image">
                                    <img class="card-img" src="images/club_1.jpg" alt="club1"/>
                                </div>
                            </div>
                            <div class="card-content">
                                <h2 class="name">IT Club</h2>
                                <p class="description">IT clubs is ...................................</p>
                                <button class="button">View detail</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="swiper-button-next"></div>
                <div class="swiper-button-prev"></div>
                <div class="swiper-pagination"></div>
            </div>
        </div>
    </div>
    <section id="test">
        <div class="testimonial">
            <div class="testimonial-header">
                <h2>Customer Testimonials</h2>
            </div>
            <div class="testimonial-main">
                <div id="testimonial-slider">
                    <div class="testimonial-card">
                        <div class="testimonial-profile">
                            <img src="images/tets-person1.jpg" alt="alt" width=""/>
                            <div class="name-job">
                                <h2>Vo Dung Nhat Team</h2>
                                <p>Nen Kick Ra Khoi Nhom Gap.</p>
                            </div>
                        </div>
                        <p>The most common role a teacher plays in the classroom is to teach knowledge to children. Teachers teach in many ways including lectures, small group activities, and hands-on learning activities. Creating a Classroom Environment.</p>
                    </div>
                    <div class="testimonial-card">
                        <div class="testimonial-profile">
                            <img src="images/tets-person1.jpg" alt="alt" width=""/>
                            <div class="name-job">
                                <h2>Vo Dung Nhat Team</h2>
                                <p>Nen Kick Ra Khoi Nhom Gap.</p>
                            </div>
                        </div>
                        <p>The most common role a teacher plays in the classroom is to teach knowledge to children. Teachers teach in many ways including lectures, small group activities, and hands-on learning activities. Creating a Classroom Environment.</p>
                    </div>
                    <div class="testimonial-card">
                        <div class="testimonial-profile">
                            <img src="images/tets-person1.jpg" alt="alt" width=""/>
                            <div class="name-job">
                                <h2>Vo Dung Nhat Team</h2>
                                <p>Nen Kick Ra Khoi Nhom Gap.</p>
                            </div>
                        </div>
                        <p>The most common role a teacher plays in the classroom is to teach knowledge to children. Teachers teach in many ways including lectures, small group activities, and hands-on learning activities. Creating a Classroom Environment.</p>
                    </div>
                    <div class="testimonial-card">
                        <div class="testimonial-profile">
                            <img src="images/tets-person1.jpg" alt="alt" width=""/>
                            <div class="name-job">
                                <h2>Vo Dung Nhat Team</h2>
                                <p>Nen Kick Ra Khoi Nhom Gap.</p>
                            </div>
                        </div>
                        <p>The most common role a teacher plays in the classroom is to teach knowledge to children. Teachers teach in many ways including lectures, small group activities, and hands-on learning activities. Creating a Classroom Environment.</p>
                    </div>
                </div>
                <div class="testimonial-slideBar">
                    <span id="leftArrow">
                        <i><</i>
                    </span>
                    <span id="rightArrow">
                        <i>></i>
                    </span>
                </div>
            </div>
        </div>
    </section>
    <script src="./Font-Awesome/all.min.js"></script>
    <script src="script/main.js"></script>
    <script src="script/swiper-bundle.min.js"></script>
    <script src="script/script.js"></script>
</html>
