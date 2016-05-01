<%-- 
    Document   : creation_tachecomposee
    Created on : 30 avr. 2016, 09:02:20
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
                <form class="af-form" id="af-form" method="get" action="controleurtache">
                    <div class="af-outer">	
                        <div class="af-inner">
                            <br/>
                            <br/>
                            <span>Entrez les informations générales sur la tâche à réaliser.</span><br/>
                            Veuillez remplir les champs ci-dessous concernant une tâche atomique, SVP.
                        </div>
                    </div>
                    <div class="af-outer">
                        <div class="af-inner">
                            <label for="input-title">Titre</label>
                            <input type="text" name="title" id="input-title" required placeholder="Titre" />
                        </div>
                    </div>
                    <div class="af-outer">
                        <div class="af-inner">
                            <label for="input-description">Description</label>
                            <textarea name="description" id="input-description" rows="10" cols="20" required placeholder="Description du travail à réaliser (200 caractères max)" maxlength="200" ></textarea>
                        </div>
                    </div>
                    <div class="af-outer">
                        <div class="af-inner">	
                            <label id=prix for="input-price">Rémunération</label>
                            <input type="number" name="price" step="1" min="0" required id="input-price" 
                                   placeholder="Rémunération en €">
                        </div>
                    </div>					
                    <div class="af-outer">
                        <div class="af-inner">
                            <label>Compétences</label>
                            <input type="checkbox" name="skill" value="1"/> Bricolage<br/>
                            <input type="checkbox" name="skill" value="2"/> Ménage<br/>
                            <input type="checkbox" name="skill" value="3"/> Jardinage<br/>
                            <input type="checkbox" name="skill" value="4"/> Pyrogravure sur boîte de camembert<br/>
                            <label></label>
                            <input type="checkbox" name="skill" value="5"/> Peinture<br/>
                            <input type="checkbox" name="skill" value="6"/> Réparation<br/>
                            <input type="checkbox" name="skill" value="7"/> Cuisine<br/>
                            <input type="checkbox" name="skill" value="8"/> Aide à la personne<br/>					
                        </div>
                    </div>
                    <div class="af-outer">
                        <div class="af-inner">

                            <label id="box"><input type="checkbox" required name="remember_me" checked /></label>
                            Je certifie avoir lu et accepté les <a href="#">conditions générales</a> 
                            d'utilisation du site BlablaJob.  
                        </div>
                    </div>	
                    
                    <input type="hidden" name="idtache" value=${idtache} />
                    <input type="hidden" name="adresse" value=${adresse} />
                    <input type="submit" name="choix" value="Ajouter" />                                    
                    <input type="hidden" name="action" value="tacheatomique" />
                    <input style="margin-left: 42.7%" type="submit" name="choix" value="Poster" /> 

                </form>
            </section>
        </div>


</html>
