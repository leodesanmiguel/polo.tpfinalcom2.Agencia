<%-- 
    Document   : empleado
    Created on : 5 dic. 2021, 23:15:34
    Author     : Leo Martinez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Traveler by freehtml5.co
	Twitter: http://twitter.com/fh5co
	URL: http://freehtml5.co
-->
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Leo Martinez 20754731 &mdash; Trabajo Integrador 2021 - comisión 2 </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Leo Martinez 20754731 - Trabajo Integrador 2021 - comisión 2 " />
    <meta name="keywords" content="free website templates, free html5, free template, free bootstrap, 
	free website template, html5, css3, mobile first, responsive" />
    <meta name="author" content="FreeHTML5.co" />

    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content="" />
    <meta property="og:image" content="" />
    <meta property="og:url" content="" />
    <meta property="og:site_name" content="" />
    <meta property="og:description" content="" />
    <meta name="twitter:title" content="" />
    <meta name="twitter:image" content="" />
    <meta name="twitter:url" content="" />
    <meta name="twitter:card" content="" />

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">

    <!-- Animate.css -->
    <link rel="stylesheet" href="css/animate.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="css/icomoon.css">
    <!-- Themify Icons-->
    <link rel="stylesheet" href="css/themify-icons.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="css/bootstrap.css">

    <!-- Magnific Popup -->
    <link rel="stylesheet" href="css/magnific-popup.css">

    <!-- Magnific Popup -->
    <link rel="stylesheet" href="css/bootstrap-datepicker.min.css">

    <!-- Owl Carousel  -->
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">

    <!-- Theme style  -->
    <link rel="stylesheet" href="css/style.css">

    <!-- Modernizr JS -->
    <script src="js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

</head>

<body>

    <div class="gtco-loader"></div>

    <div id="page">


        <!-- <div class="page-inner"> -->
        <nav class="gtco-nav" role="navigation">
            <div class="gtco-container">

                <div class="row">
                    <div class="col-sm-4 col-xs-12">
                        <div id="gtco-logo"><a href="index.jsp">Agencia POLO <em>.</em></a></div>
                    </div>
                    <div class="col-xs-8 text-right menu-1">
                        <ul>
                            <li><a href="destination.jsp">Destino</a></li>
                            <li class="has-dropdown">
                                <a href="#">Viajes</a>
                                <ul class="dropdown">
                                    <li><a href="#">Exterior</a></li>
                                    <li><a href="#">Argentina</a></li>
                                    <li><a href="#">Turismo</a></li>
                                    <li><a href="#">Directo</a></li>
                                </ul>
                            </li>
                            <li><a href="pricing.jsp">Precios</a></li>
                            <li><a href="contact.jsp">Contacto</a></li>
                            <li class="has-dropdown">
                                <a href="#">Admin</a>
                                <ul class="dropdown">
                                    <li><a href="empleado.jsp">Empleados</a></li>
                                    <li><a href="#">Servicios</a></li>
                                    <li><a href="#">Paquetes</a></li>
                                    <li><a href="#">Ventas</a></li>
                                </ul>
                            </li>

                        </ul>
                    </div>
                </div>

            </div>
        </nav>

        <header id="gtco-header" class="gtco-cover gtco-cover-md" role="banner" style="background-image: url(images/img_bg_2.jpg)">
            <div class="overlay"></div>
            <div class="gtco-container">
                <div class="row">
                    <div class="col-md-12 col-md-offset-0 text-left">


                        <div class="row row-mt-15em">
                            <div class="col-md-7 mt-text animate-box" data-animate-effect="fadeInUp">
                                <h1>Planifica tu viaje a cualquier parte</h1>
                            </div>
                            <div class="col-md-4 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
                                <div class="form-wrap">
                                    <div class="tab">

                                        <div class="tab-content">
                                            <div class="tab-content-inner active" data-content="signup">
                                                <h3>Reserva tu Viaje</h3>
                                                <form action="svrReserva" method="POST">
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label for="nombre">Nombre</label>
                                                            <input type="text" id="nombre" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label for="apellido">Apellido</label>
                                                            <input type="text" id="apellido" class="form-control">
                                                        </div>
                                                    </div>

                                                    <!-- <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label for="activities">Activities</label>
                                                            <select name="#" id="activities" class="form-control">
															<option value="">Activities</option>
															<option value="">Hiking</option>
															<option value="">Caving</option>
															<option value="">Swimming</option>
														</select>
                                                        </div>
                                                    </div> -->
                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label for="destination">Destino</label>
                                                            <select name="#" id="destination" class="form-control">
															<option value="alexterior">Viaje al Exterior</option>
															<option value="porargentina">viaje por Argentina</option>
															<option value="turaventura">Turismo Aventura </option>
															<option value="turgastro">Turismo Gastronómico </option>
															<option value="viajedirecto">Viaje Directo</option>
														</select>
                                                        </div>
                                                    </div>

                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <label for="date-start">Fecha del Viaje</label>
                                                            <input type="text" id="date-start" class="form-control">
                                                        </div>
                                                    </div>

                                                    <div class="row form-group">
                                                        <div class="col-md-12">
                                                            <input type="submit" class="btn btn-primary btn-block" value="Continuar Reserva">
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>


                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
        </header>

        <div class="gtco-section">
            <div class="gtco-container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2 text-center gtco-heading">
                        <h2>Paquetes Mas Populares</h2>
                        <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                    </div>
                </div>
                <div class="row">

                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <a href="images/img_1.jpg" class="fh5co-card-item image-popup">
                            <figure>
                                <div class="overlay"><i class="ti-plus"></i></div>
                                <img src="images/img_1.jpg" alt="Image" class="img-responsive">
                            </figure>
                            <div class="fh5co-text">
                                <h2>Viajes al Exterior</h2>
                                <p>Far far away, behind the word mountains, far from the countries Vokalia..</p>
                                <p><span class="btn btn-primary">Programar un viaje</span></p>
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <a href="images/img_2.jpg" class="fh5co-card-item image-popup">
                            <figure>
                                <div class="overlay"><i class="ti-plus"></i></div>
                                <img src="images/img_2.jpg" alt="Image" class="img-responsive">
                            </figure>
                            <div class="fh5co-text">
                                <h2>Viajes por Argentina</h2>
                                <p>Far far away, behind the word mountains, far from the countries Vokalia..</p>
                                <p><span class="btn btn-primary">Programar un viaje</span></p>
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <a href="images/img_3.jpg" class="fh5co-card-item image-popup">
                            <figure>
                                <div class="overlay"><i class="ti-plus"></i></div>
                                <img src="images/img_3.jpg" alt="Image" class="img-responsive">
                            </figure>
                            <div class="fh5co-text">
                                <h2>Viaje Directo</h2>
                                <p>Far far away, behind the word mountains, far from the countries Vokalia..</p>
                                <p><span class="btn btn-primary">Programar un viaje</span></p>
                            </div>
                        </a>
                    </div>


                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <a href="images/img_4.jpg" class="fh5co-card-item image-popup">
                            <figure>
                                <div class="overlay"><i class="ti-plus"></i></div>
                                <img src="images/img_4.jpg" alt="Image" class="img-responsive">
                            </figure>
                            <div class="fh5co-text">
                                <h2>Turismo en Mendoza</h2>
                                <p>Far far away, behind the word mountains, far from the countries Vokalia..</p>
                                <p><span class="btn btn-primary">Programar un viaje</span></p>
                            </div>
                        </a>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <a href="images/img_5.jpg" class="fh5co-card-item image-popup">
                            <figure>
                                <div class="overlay"><i class="ti-plus"></i></div>
                                <img src="images/img_5.jpg" alt="Image" class="img-responsive">
                            </figure>
                            <div class="fh5co-text">
                                <h2>Turismo en Bariloche</h2>
                                <p>Far far away, behind the word mountains, far from the countries Vokalia..</p>
                                <p><span class="btn btn-primary">Programar un viaje</span></p>
                            </div>
                        </a>
                    </div>

                    <div class="col-lg-4 col-md-4 col-sm-6">
                        <a href="images/img_6.jpg" class="fh5co-card-item image-popup">
                            <figure>
                                <div class="overlay"><i class="ti-plus"></i></div>
                                <img src="images/img_6.jpg" alt="Image" class="img-responsive">
                            </figure>
                            <div class="fh5co-text">
                                <h2>Turismo en Misiones</h2>
                                <p>Far far away, behind the word mountains, far from the countries Vokalia..</p>
                                <p><span class="btn btn-primary">Programar un viaje</span></p>
                            </div>
                        </a>
                    </div>

                </div>
            </div>
        </div>

        <div id="gtco-features">
            <div class="gtco-container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2 text-center gtco-heading animate-box">
                        <h2>¿Cómo funciona?</h2>
                        <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 col-sm-6">
                        <div class="feature-center animate-box" data-animate-effect="fadeIn">
                            <span class="icon">
							<i>1</i>
						</span>
                            <h3>Lorem ipsum dolor sit amet</h3>
                            <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div class="feature-center animate-box" data-animate-effect="fadeIn">
                            <span class="icon">
							<i>2</i>
						</span>
                            <h3>Consectetur adipisicing elit</h3>
                            <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div class="feature-center animate-box" data-animate-effect="fadeIn">
                            <span class="icon">
							<i>3</i>
						</span>
                            <h3>Dignissimos asperiores vitae</h3>
                            <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                        </div>
                    </div>


                </div>
            </div>
        </div>


        <div class="gtco-cover gtco-cover-sm" style="background-image: url(images/img_bg_1.jpg)" data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="gtco-container text-center">
                <div class="display-t">
                    <div class="display-tc">
                        <h1>¡Contamos con servicios de alta calidad que seguro te encantarán!</h1>
                    </div>
                </div>
            </div>
        </div>

        <div id="gtco-counter" class="gtco-section">
            <div class="gtco-container">

                <div class="row">
                    <div class="col-md-8 col-md-offset-2 text-center gtco-heading animate-box">
                        <h2>Nuestros Logros</h2>
                        <p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
                    </div>
                </div>

                <div class="row">

                    <div class="col-md-3 col-sm-6 animate-box" data-animate-effect="fadeInUp">
                        <div class="feature-center">
                            <span class="counter js-counter" data-from="0" data-to="196" data-speed="5000" data-refresh-interval="50">1</span>
                            <span class="counter-label">Destinos</span>

                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 animate-box" data-animate-effect="fadeInUp">
                        <div class="feature-center">
                            <span class="counter js-counter" data-from="0" data-to="97" data-speed="5000" data-refresh-interval="50">1</span>
                            <span class="counter-label">Hoteles</span>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 animate-box" data-animate-effect="fadeInUp">
                        <div class="feature-center">
                            <span class="counter js-counter" data-from="0" data-to="12402" data-speed="5000" data-refresh-interval="50">1</span>
                            <span class="counter-label">Viejeros</span>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 animate-box" data-animate-effect="fadeInUp">
                        <div class="feature-center">
                            <span class="counter js-counter" data-from="0" data-to="12202" data-speed="5000" data-refresh-interval="50">1</span>
                            <span class="counter-label">Clientes Feclices</span>

                        </div>
                    </div>

                </div>
            </div>
        </div>



        <div id="gtco-subscribe">
            <div class="gtco-container">
                <div class="row animate-box">
                    <div class="col-md-8 col-md-offset-2 text-center gtco-heading">
                        <h2>Subscribe</h2>
                        <p>Sea el primero en conocer los nuevos paquetes turisticos.</p>
                    </div>
                </div>
                <div class="row animate-box">
                    <div class="col-md-8 col-md-offset-2">
                        <form class="form-inline" action=>
                            <div class="col-md-6 col-sm-6">
                                <div class="form-group">
                                    <label for="email" class="sr-only">Email</label>
                                    <input type="email" class="form-control" id="email" placeholder="Su correo electrónico">
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <button type="submit" class="btn btn-default btn-block">Subscribe</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <footer id="gtco-footer" role="contentinfo">
            <div class="gtco-container">
                <div class="row row-p	b-md">

                    <div class="col-md-4">
                        <div class="gtco-widget">
                            <h3>Sobre Nosotros</h3>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempore eos molestias quod sint ipsum possimus temporibus officia iste perspiciatis consectetur in fugiat repudiandae cum. Totam cupiditate nostrum ut neque ab?</p>
                        </div>
                    </div>

                    <div class="col-md-2 col-md-push-1">
                        <div class="gtco-widget">
                            <h3>Destinos</h3>
                            <ul class="gtco-footer-links">
                                <li><a href="#">Viaje al Exterior</a></li>
                                <li><a href="#">Viejae por Argentina</a></li>
                                <li><a href="#">Turismo Aventura></li>
                                <li><a href="#">Turismo Gastronomico</a></li>
                                <li><a href="#">Viaje Directo</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-md-2 col-md-push-1">
                        <div class="gtco-widget">
                            <h3>Hotels</h3>
                            <ul class="gtco-footer-links">
                                <li><a href="#">NH Mendoza Cordillera</a></li>
                                <li><a href="#">Sheraton Mendoza</a></li>
                                <li><a href="#">Mercure Iguazu Hotel Iru</a></li>
                                <li><a href="#">Casita Suiza</a></li>
                                <li><a href="#">Loi Suites Iguazú</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-md-3 col-md-push-1">
                        <div class="gtco-widget">
                            <h3>Contacta a nuestros Operadores</h3>
                            <ul class="gtco-quick-contact">
                                <li><a href="#"><i class="icon-phone"></i> +54 123 456 789</a></li>
                                <li><a href="#"><i class="icon-mail2"></i> info@agenciapolo.com.ar</a></li>
                                <li><a href="#"><i class="icon-chat"></i> Habla por Chat!</a></li>
                            </ul>
                        </div>
                    </div>

                </div>

                <div class="row copyright">
                    <div class="col-md-12">
                        <p class="pull-left">
                            <small class="block">&copy; 2021 Leo Martinez. All Rights Reserved.</small>
                            <small class="block">Diseñando por <a href="https://freehtml5.co/" target="_blank">FreeHTML5.co</a> Composición: <a href="#" target="_blank">Leo Martinez</a> Profesora: <a href="#" target="_blank">Ing. Luisina de Paula</a> </small>
                            <small class="block">Trabajo Inttegrador. Comisión Nº2.</small>
                        </p>
                        <p class="pull-right">
                            <ul class="gtco-social-icons pull-right">
                                <li><a href="#"><i class="icon-twitter"></i></a></li>
                                <li><a href="#"><i class="icon-facebook"></i></a></li>
                                <li><a href="#"><i class="icon-linkedin"></i></a></li>
                                <li><a href="#"><i class="icon-dribbble"></i></a></li>
                            </ul>
                        </p>
                    </div>
                </div>

            </div>
        </footer>
        <!-- </div> -->

    </div>

    <div class="gototop js-top">
        <a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
    </div>

    <!-- jQuery -->
    <script src="js/jquery.min.js"></script>
    <!-- jQuery Easing -->
    <script src="js/jquery.easing.1.3.js"></script>
    <!-- Bootstrap -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Waypoints -->
    <script src="js/jquery.waypoints.min.js"></script>
    <!-- Carousel -->
    <script src="js/owl.carousel.min.js"></script>
    <!-- countTo -->
    <script src="js/jquery.countTo.js"></script>

    <!-- Stellar Parallax -->
    <script src="js/jquery.stellar.min.js"></script>

    <!-- Magnific Popup -->
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/magnific-popup-options.js"></script>

    <!-- Datepicker -->
    <script src="js/bootstrap-datepicker.min.js"></script>


    <!-- Main -->
    <script src="js/main.js"></script>

</body>

</html>