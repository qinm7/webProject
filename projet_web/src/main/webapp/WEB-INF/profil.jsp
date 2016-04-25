<%-- 
    Document   : profil
    Created on : 22 avr. 2016, 23:39:18
    Author     : qinm
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profil utilisateur</title>
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
            <h1>Profil</h1>
            <%--affichage des données clients --%>
            Nom : ${utilisateur.nom} <br/>
            Prénom : ${utilisateur.prenom} <br/> 
            Email : ${utilisateur.email} <br/>
            Genre : ${utilisateur.genre} <br/> 
            Date de naissance : ${utilisateur.birth} <br/>
            Localisation : (${utilisateur.latitude}, ${utilisateur.longitude}) <br/>
            Compétences : 
            <%
                List<String> listSkill = new ArrayList();
                listSkill = (ArrayList<String>) request.getAttribute("skills");
                for (Iterator<String> it = listSkill.iterator(); it.hasNext();) {
                    String skill = it.next();
                    out.println("<tr><td>" + skill + "</td></tr>");
                    if (it.hasNext()) {
                        out.println(" / ");
                    }
                }
            %>
        </div>
    </body>
</html>
