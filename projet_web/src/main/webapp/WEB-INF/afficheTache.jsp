<%-- 
    Document   : afficheTache
    Created on : 26 avr. 2016, 18:34:16
    Author     : utilisateur
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
                    
                    
    <body>
        <h1>Affiche les taches</h1>
        
        <c:forEach items="${taches}" var="tache">
                    <tr>
                    <fieldset>
                        <legend>Tâche ${tache.idTache}</legend>
                        Titre : ${tache.titre}<br/>
                        Description : ${tache.description}<br/>
                        Rémuneration : ${tache.remuneration} €<br/>
                        Longitude : ${tache.longitude}<br/>
                        Latitude : ${tache.latitude}<br/>
                        Date de début : ${tache.datedebut}<br/>
                        Date de fin : ${tache.datefin}<br/>
                        Email : ${tache.email}<br/>
                        Compétences : 
                            <c:forEach items="${tache.skill}" var="skill">
                                ${skill}
                                <c:out value = "/" />  
                            </c:forEach>    
                    </fieldset>
                    </tr>
                </c:forEach>
    
    </body>
    
    
</html>
