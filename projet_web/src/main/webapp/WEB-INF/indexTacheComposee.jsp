<%-- 
    Document   : indexTacheComposee
    Created on : 30 avr. 2016, 20:05:16
    Author     : qinm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Affichage d'un utilisateur</title>
        <link type="text/css" rel="stylesheet" href="css/style_register.css" />
        <link rel="stylesheet" type="text/css" href="css/skel.css" />
        <link rel="stylesheet" type="text/css" href="css/style-xlarge.css" />
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
        </style>    
    </head>
    <body>
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
        <br/>
        <div class="container">
            <h1>Tâche créée avec succès !</h1>
            Voici un récapitulatif de votre tâche composée :<br/>
            <%--affichage des données clients --%>
            Titre : ${tacheC.titre}<br/>
            Description : ${tacheC.description}<br/>
            Rémuneration : ${tacheC.remuneration} €<br/>
            Longitude : ${tacheC.longitude}<br/>
            Latitude : ${tacheC.latitude}<br/>
            Date de début : ${tacheC.datedebut}<br/>
            Date de fin : ${tacheC.datefin}<br/>
            Email : ${tacheC.email}<br/>
            Compétences : 
            <c:forEach items="${tacheC.skill}" var="skill">
                ${skill}
                <c:out value = "/" />  
            </c:forEach>
            <br/>
            <br/>
            Composition de la tâche : <br/>
            <c:forEach items="${tacheAs}" var="tacheA">
                Titre : ${tacheA.titre}<br/>
                Description : ${tacheA.description}<br/>
                Rémuneration : ${tacheA.remuneration} €<br/>
                Longitude : ${tacheA.longitude}<br/>
                Latitude : ${tacheA.latitude}<br/>
                Date de début : ${tacheA.datedebut}<br/>
                Date de fin : ${tacheA.datefin}<br/>
                Email : ${tacheA.email}<br/>
                Compétences : 
                <c:forEach items="${tacheA.skill}" var="skill">
                    ${skill}
                    <c:out value = "/" />  
                </c:forEach>
                <br/>
                <br/>  
            </c:forEach>
        </div>
    </body>
</html>
