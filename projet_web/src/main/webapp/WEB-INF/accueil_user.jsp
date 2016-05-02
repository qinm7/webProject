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
        <link rel="stylesheet" type="text/css" href="./css/comment_ca_marche.css"/>
        <style>
            #section_1 {
                margin-left: 19%;
                margin-right: auto;
                margin-top: 5%;
            }

            #section_1 form {
                text-align: center;
                padding: 0;
                margin:0;
            }

            #section_1 .form_row {
                clear: both;
                padding-bottom: 20px ;
                text-align : center;
            }

            #recherche {
                margin-left: 22%;
                margin-right: auto;
            }


            #moncadre {
                border:1px solid black;
                width:1200px;
                height:300px;
            }
            
         .city {
    margin-left: 110px;
    text-align: center;
}
        </style>



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
        <div class="acceuil">
            <h2 class="commentbis">Bonjour ${user}, choissisez une ville et une compétence pour trouver un travail</h2>
            <br>
            <div class="user">
                <div id="moncadre" class="container">
                    <div class="row">
                        <div id="section_1">
                            <form method="post" action="controleurtache">
                                <div class="form_row"> 
                                    <label class="formulaire" >Ville : </label>
                                    <input class="main city" type="text" name="city" placeholder="Entrez une ville" /> </div>


                                <div class="form_row"> 
                                    <label class="formulaire">Compétence : </label>
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
                                    <input type="hidden" name="action" value="rechercher" />
                                    <input class="main" type="submit" value="Rechercher" name="search" />
                                </div>        
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">

            </div>

    </body>
</html>
