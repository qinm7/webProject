<%-- 
    Document   : afficheUser
    Created on : 12 avr. 2016, 20:09:33
    Author     : qinm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Affichage d'un utilisateur</title>
        <link type="text/css" rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <h1>Bienvenue sur votre profil ${utilisateur.nom} ${utilisateur.prenom}</h1>
        Voici un récapitulatif de vos données :<br/>
        <%--affichage des données client --%>
        <div>
            Nom : ${utilisateur.nom} <br/>
            Prénom : ${utilisateur.prenom} <br/> 
            Email : ${utilisateur.email} <br/>
            Genre : ${utilisateur.genre} <br/> 
            Date de naissance : ${utilisateur.birth} <br/>
        </div>
    </body>
</html>
