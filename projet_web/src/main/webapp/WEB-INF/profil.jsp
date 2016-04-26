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
        <link rel="stylesheet" type="text/css" href="css/profil.css" />    
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
                    <li><a href="controleur?action=getPage&view=taches&id=${user}">Tâches de BlablaJob</a></li>
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
            <tr>
                <td>Localisation : (${utilisateur.latitude}, ${utilisateur.longitude})</td> 
                <td><a href="controleur?action=getProfil&view=localisation&id=${user}">modifier</a></td>
            </tr>
            <br/>
            <tr>
                <td>Compétences : 
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
                </td>
                <td><a href="controleur?action=getProfil&view=skill&id=${user}">modifier</a></td>
            </tr>    
        </div>
    </body>
</html>
