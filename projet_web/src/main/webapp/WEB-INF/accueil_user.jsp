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
        <style>
            #section_1 {
                margin-left: 36%;
                margin-right: auto;
            }

            #section_1 form {
                text-align: left;
                padding: 0;
                margin:0;
            }

            #section_1 .form_row {
                clear: both;
                padding-bottom: 15px;
            }

            #recherche {
                margin-left: 22%;
                margin-right: auto;
            }
        </style>
    </head>
    <body>
        <header id="header" class="skel-layers-fixed">
            <h1><a href="#">BlablaJob</a></h1>
            <nav id="nav">
                <ul>
                    <li><a href="controleur?action=getPage&view=accueil&id=${user}">Page d'accueil</a></li>
                    <li><a href="controleur?action=getPage&view=profil&id=${user}">Profil</a></li>
                    <li><a href="controleur?action=getPage&view=poster&id=${user}">Poster une tâche</a></li>
                    <li><a href="controleur?action=getPage&view=historique&id=${user}">Historique de tâches</a></li>
                    <li>
                        <form method="post" action="logout">
                            <input type="submit" value="Se déconnecter" class="button special"/>
                        </form>
                    </li>	
                </ul>
            </nav>
        </header>
        <br/>
        <div class="container">
            <div class="row">
                <div id="section_1">
                    <form method="post" action="controleurtache">
                        <div class="form_row"> 
                            <label class="main">Ville : </label>
                            <input class="main" type="text" name="city" value="" placeholder="Entrez une ville" /> </div>
                        <div class="form_row"> 
                            <label class="main">Compétence : </label>
                            <select class="main" name="skill">
                                <option value="-1">Sélectionnez une compétence...</option>
                                <option value="bricolage">Bricolage</option>
                                <option value="menage">Ménage</option>
                                <option value="jardinage">Jardinage</option>
                                <option value="pyrogravure">Pyrogravure sur boîte de camembert</option>
                                <option value="peinture">Peinture</option>
                                <option value="reparation">Réparation</option>
                                <option value="cuisine">Cuisine</option>
                                <option value="aide">Aide à la personne</option>
                            </select>
                        </div>
                        <div class="form_row" id="recherche"> 
                            <input type="hidden" name="action" value="rechercher" />
                            <input class="main" type="submit" value="Rechercher" name="search" />
                        </div>        
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
