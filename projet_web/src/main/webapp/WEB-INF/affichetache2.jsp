<%-- 
    Document   : afficheTache
    Created on : 26 avr. 2016, 18:34:16
    Author     : utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <li><a href="index.html">Accueil</a></li>
                    <li><a href="comment_ca_marche.html">Comment ça marche</a></li>
                    <li><a href="connexion.jsp">Connexion</a></li>
                    <li><a href="inscrire.jsp" class="button special">S'inscrire</a></li>	
                </ul>
            </nav>
        </header>
                    
                    
    <body>
    <center>
    <div  id="image1">
    <img id="image" width="600" src="http://maps.googleapis.com/maps/api/staticmap?center=${city}&zoom=12&scale=true&size=1000x500&markers=color:red|label:A|${la},${lo}&markers=color:green|label:B|48.858370099999,2.294481300000&maptype=roadmap&format=png&visual_refresh=true" alt="Google Map of France">
    </div>
    </center>
        <br/>
       <div class="container">
            <h1>Liste des tâches</h1>
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
                        <br/>
                    </fieldset>
                    </tr>
                </c:forEach>
            </table>   
        </div>
    </body>
    
    
</html>
