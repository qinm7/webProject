<%-- 
    Document   : connexion
    Created on : 21 avr. 2016, 11:48:42
    Author     : qinm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Se connecter</title>

        <script src="js/jquery.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/skel-layers.min.js"></script>
        <script src="js/init.js"></script>	
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

        <!-- Google Fonts -->
        <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

        <link rel="stylesheet" href="css/animate.css">
        <!-- Custom Stylesheet -->
        <link rel="stylesheet" href="css/style_log_in.css">

        <noscript>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/skel.css">
        <link rel="stylesheet" href="css/xlarge.css">
        </noscript>

    </head>
    <style>
        .info {
            font-size : 10pt;
            color : red;
        }
    </style>
    <body>
        <!-- Header -->
        <header id="header" class="skel-layers-fixed">
            <h1><a href="#">BlablaJob</a></h1>
            <nav id="nav">
                <ul>
                    <li><a href="index.html">Accueil</a></li>
                    <li><a href="#">Comment ça marche</a></li>
                    <li><a href="connexion.jsp">Connexion</a></li>
                    <li><a href="inscrire.jsp" class="button special">S'inscrire</a></li>
                </ul>
            </nav>
        </header>
        <div class="container1">
            <div class="top">
                <h1 id="title" class="hidden"><span id="logo">Blabla <span>Job</span></span></h1>
            </div>
            <div class="login-box animated fadeInUp">
                <div class="box-header">
                    <h2>Connectez-vous</h2>
                </div>
                <form method="post" action="checkuser">
                    <label for="username">E-mail</label>
                    <br/>
                    <input type="email" id="username" name="username" required placeholder="E-mail" />
                    <br/>
                    <label for="password">Mot de passe</label>
                    <br/>
                    <input type="password" id="password" name="password" required placeholder="Mot de passe" />
                    <br/>
                    <button type="submit">Connexion</button>
                    <br/>
                    <span class="info"> ${messageErr} </span>
                </form>
                <a id="bis" href="#"><p class="small">Mot de passe oublié ?</p></a>
            </div>
        </div>
        <br/>

        <!-- Footer -->
        <footer id="footer">
            <div class="container">
                <div class="row double">
                    <div class="6u">
                        <div class="row collapse-at-2">
                            <div class="6u">
                                <h3>Infos pratiques</h3>
                                <ul class="alt">
                                    <li><a href="#">FAC</a></li>
                                    <li><a href="#">Contact</a></li>
                                </ul>
                            </div>
                            <div class="6u">
                                <h3>À propos</h3>
                                <ul class="alt">
                                    <li><a href="#">Qui sommes-nous ?</a></li>
                                    <li><a href="#">Conditions générales et confidentialité</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="6u">
                        <h3>Suivez-nous</h3>
                        <p> Retrouvez toutes nos dernières actualités sur les réseaux sociaux. </p>
                        <ul class="icons">
                            <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
                            <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
                            <li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
                            <li><a href="#" class="icon fa-linkedin"><span class="label">LinkedIn</span></a></li>
                            <li><a href="#" class="icon fa-pinterest"><span class="label">Pinterest</span></a></li>
                        </ul>
                    </div>
                </div>
                <ul class="copyright">
                    <li>&copy; BlablaJob. Tous droits réservés.</li>
                    <li>Design : <a href="http://templated.co">TEMPLATED</a></li>
                </ul>
            </div>
        </footer>
    </body>
    <script>
        $(document).ready(function () {
            $('#logo').addClass('animated fadeInDown');
            $("input:text:visible:first").focus();
        });
        $('#username').focus(function () {
            $('label[for="username"]').addClass('selected');
        });
        $('#username').blur(function () {
            $('label[for="username"]').removeClass('selected');
        });
        $('#password').focus(function () {
            $('label[for="password"]').addClass('selected');
        });
        $('#password').blur(function () {
            $('label[for="password"]').removeClass('selected');
        });
    </script>
</html>
