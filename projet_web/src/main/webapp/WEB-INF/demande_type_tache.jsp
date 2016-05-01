<%-- 
    Document   : demande_type_tache
    Created on : 30 avr. 2016, 09:07:54
    Author     : qinm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


    <head>
    <head>
        <title>Poster une annonce</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style_register.css" />
        <link rel="stylesheet" type="text/css" href="css/skel.css" />
        <link rel="stylesheet" type="text/css" href="css/style-xlarge.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery-ui.css"/>
        <link rel="stylesheet" type="text/css" href="css/creation_tache.css" />
        
        <!-- Script -->
        <script type="text/javascript" src="js/modernizr.custom.04022.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-ui.js"></script>
        <style>
            body, p, legend, label, input {
                font-family: "Roboto", Helvetica, sans-serif;
                font-weight: 300;
            }		

            h1{
                color: #666f77;
                font-weight: 300;
                line-height: 1em;
                margin: 0 0 1em 0;
                text-transform: uppercase;
                letter-spacing: 0.125em;
            }

            h1 a {
                color: inherit;
                text-decoration: none;
            }
            h4 {
                text-align: center;
            }
        </style>

    </head>


    <body>
        <!-- Header A mettre sur chaque page html/jsp -->
        <header id="header">
            <h1><a>BlablaJob</a></h1>
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

        <!-- Corps du texte : creation d'une tache -->
        <div class="container">
            <section class="af-wrapper">
                <h3>Poster une annonce sur BlablaJob</h3>			
                <form class="af-form" id="af-form" method="get" action="controleur" >
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <div class="af-outer">	
                        <div class="af-inner">				
                            <span>Est-ce que la tâche est décomposable en plusieurs sous-tâches?</span>
                            <select class="styled-select1" name="typetache" required>
                                <option value="non">non</option>
                                <option value="oui">oui</option>
                            </select>
                            <br/>
                        </div>
                    </div>	
                    <input type="hidden" name="email" value=${user} />
                    <input type="hidden" name="action" value="choix_tache" />
                    <input type="submit" name="submit_tache" value="Envoyer" /> 

                </form>
            </section>
        </div>


</html>
