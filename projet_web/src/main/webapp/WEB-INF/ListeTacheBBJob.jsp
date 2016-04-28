<%-- 
    Document   : ListeTacheBBJob
    Created on : 26 avr. 2016, 19:51:10
    Author     : qinm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des tâches</title>
        <link rel="stylesheet" type="text/css" href="css/style_register.css" />
        <link rel="stylesheet" type="text/css" href="css/skel.css" />
        <link rel="stylesheet" type="text/css" href="css/style-xlarge.css" />
        <script type="text/javascript">
            function ConfirmMessage() {
                if (!confirm("Vous allez vous engager pour une tâche, confirmez-vous ce choix ?")) { 
                    return false;
                }
            }
        </script>

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

            fieldset {
                padding: 10px;
                border: 1px #0568CD solid;
                margin: 10px;
            }

            legend {
                font-weight: bold;
                color: #0568CD;
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
        <br/>            
        <div class="container">
            <h1>Liste des tâches disponibles en tant qu'exécutant sur BlablaJob</h1>
            <table>
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
                        <br/>
                        <form method="post" action="controleur" onsubmit="return ConfirmMessage()">
                            <input type="hidden" name="id" value=${user} />
                            <input type="hidden" name="idtache" value=${tache.idTache} />
                            <input type="hidden" name="action" value="engager" />
                            <input style="margin-left : 45% " type="submit" name="confirm" value="S'engager" />
                        </form>
                    </fieldset>
                    </tr>
                </c:forEach>
            </table>   
        </div>
    </body>
</html>