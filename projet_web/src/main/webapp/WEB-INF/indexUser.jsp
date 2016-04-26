<%-- 
    Document   : afficheUser
    Created on : 12 avr. 2016, 20:09:33
    Author     : qinm
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Affichage d'un utilisateur</title>
        <!--CSS-->
        <link type="text/css" rel="stylesheet" href="css/style_register.css" />
        <link rel="stylesheet" type="text/css" href="css/skel.css" />
        <link rel="stylesheet" type="text/css" href="css/style-xlarge.css" />
        <link rel="stylesheet" type="text/css" href="css/indexUser.css" />
    </head>
    <body>
        <header id="header" class="skel-layers-fixed">
            <h1><a href="#">BlablaJob</a></h1>
            <nav id="nav">
                <ul>
                    <li><a href="index.html">Accueil</a></li>
                    <li><a href="#">Contact</a></li>
                    <li><a href="connexion.jsp" class="button special">Se Connecter</a></li>
                </ul>
            </nav>
        </header>
        <br/>
        <div class="container">
            <h1>Compte créé avec succès !</h1>
            Voici un récapitulatif de vos données :<br/>
            <%--affichage des données clients --%>
            Nom : ${utilisateur.nom} <br/>
            Prénom : ${utilisateur.prenom} <br/> 
            Email : ${utilisateur.email} <br/>
            Genre : ${utilisateur.genre} <br/> 
            Date de naissance : ${utilisateur.birth} <br/>
            Adresse : ${adresse} <br/>
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
