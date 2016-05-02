<%-- 
    Document   : accueil_user
    Created on : 22 avr. 2016, 22:57:12
    Author     : qinm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page d'accueil</title>
        <link type="text/css" rel="stylesheet" href="css/style_register.css" />
        <link rel="stylesheet" type="text/css" href="css/skel.css" />
        <link rel="stylesheet" type="text/css" href="css/style-xlarge.css" />

        <link rel="stylesheet" type="text/css" href="css/accueil_user.css" />
        
         <!--Script-->
        <script src="js/jquery.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/init.js"></script>
    </head>
    <body>
        <header id="header" class="skel-layers-fixed">
            <h1><a href="#">BlablaJob</a></h1>
            <nav id="nav">
                <ul>
                    <li><a href="controleur?action=getPage&view=accueil&id=${user}">Page d'accueil</a></li>
                    <li><a href="controleur?action=getPage&view=profil&id=${user}">Mon profil</a></li>
                    <li><a href="controleur?action=getPage&view=poster&id=${user}">Poster une tâche</a></li>                   
                    <li><a href="controleur?action=getPage&view=taches&id=${user}">Tâches de BlablaJob</a></li>
                    <li><a href="controleur?action=getPage&view=historique&id=${user}">Espace commanditaire</a></li>
                    <li><a href="controleur?action=getPage&view=historiqueEx&id=${user}">Espace exécutant</a></li>
                    <%--<li><a href="controleur?action=getPage&view=tachesencours&id=${user}">Tâches en cours</a></li>--%>
                    <li>
                        <form method="post" action="logout">
                            <input type="submit" value="Se déconnecter" class="button special"/>
                        </form>
                    </li>	
                </ul>
            </nav>
        </header>
                    
       <section id="one" class="wrapper style1">
            <header class="major">
                <h2>Trouvez un boulot près de chez vous </h2>
                <img src="images/logo.jpg" alt="Logo de BlablaJob" />
            </header>

            <div class="container">
                <div class="row">
                    <div id="section_1">
                        <form method="get" action="liste_tache">
                            <div class="form_row"> 
                                <label for="ville">Ville : </label>
                                <input class="main" type="text" name="city" value="" placeholder="Entrez une ville" /> </div>
                            <div class="form_row"> 
                                <label for="competence">Compétence : </label>
                                <select class="main" name="skill">
                                    <option value="-1">Sélectionnez une compétence...</option>
                                    <option value="1">Bricolage</option>
                                    <option value="2">Ménage</option>
                                    <option value="3">Jardinage</option>
                                    <option value="4">Pyrogravure sur boîte de camembert</option>
                                    <option value="5">Peinture</option>
                                    <option value="6">Réparation</option>
                                    <option value="7">Cuisine</option>
                                    <option value="8">Aide à la personne</option>
                                </select>
                            </div>
                            <div class="form_row" id="recherche"> 
                                <input class="main" type="submit" value="Rechercher" name="search" />
                            </div>        
                        </form>
                    </div>
                </div>
            </div>
        </section><!-- end of section 1 -->		


    </body>
</html>
