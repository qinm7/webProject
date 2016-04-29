<%-- 
    Document   : tacheExecutant
    Created on : 28 avr. 2016, 18:51:43
    Author     : qinm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page d'accueil</title>
        <link rel="stylesheet" type="text/css" href="css/style_register.css" />
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
            <h1>Espace Exécutant</h1>
            <table>
                <c:if test="${not empty encours}">
                    <h2 style="font-size : 3ex ; color : #007fff ; text-align: center">Tâche en cours</h2>
                </c:if>
                <c:forEach items="${encours}" var="tache">
                    <tr>
                    <fieldset>
                        <legend>Tâche ${tache.idTache} (en cours)</legend>
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
                    </fieldset>
                    </tr>
                </c:forEach>
            </table>
            </br>
            <table>
                <c:if test="${not empty realiser}">
                    <h2 style="font-size : 3ex ; color : #007fff ; text-align: center">Tâche réalisée</h2>
                </c:if>
                <c:forEach items="${realiser}" var="tacheEx">
                    <tr>
                    <fieldset>
                        <legend>Tâche ${tacheEx.idTache} (réalisée)</legend>
                        Titre : ${tacheEx.titre}<br/>
                        Description : ${tacheEx.description}<br/>
                        Rémuneration : ${tacheEx.remuneration} €<br/>
                        Longitude : ${tacheEx.longitude}<br/>
                        Latitude : ${tacheEx.latitude}<br/>
                        Date de début : ${tacheEx.datedebut}<br/>
                        Date de fin : ${tacheEx.datefin}<br/>
                        Email : ${tacheEx.email}<br/>
                        Compétences : 
                        <c:forEach items="${tacheEx.skill}" var="skillEx">
                            ${skillEx}
                            <c:out value = "/" />  
                        </c:forEach>
                        <form method="post" action="controleur" >
                            <input type="hidden" name="facture" value="${tacheEx.remuneration}" />
                            <input type="hidden" name="titre" value="${tacheEx.titre}" />
                            <input type="hidden" name="description" value="${tacheEx.description}" />
                            <input type="hidden" name="user" value="${user}" />
                            <!--pour récupérer il faut aller dans le contrôleur dans le doPost et variable action=viewfacture-->
                            <input type="hidden" name="action" value="viewfacture" />
                            <input style="margin-left : 42%" type="submit" name="confirm" value="Voir la facture" />
                        </form>
                    </fieldset>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>