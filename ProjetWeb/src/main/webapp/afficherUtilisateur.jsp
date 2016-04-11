<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title>Affichage d'un utilisateur</title>
		<link type="text/css" rel="stylesheet" href="css/style.css" />
	</head>
	<body>
		<%-- affichage du message de confirmation/echec --%>
		<p class="info">${message }</p>
		
		<%--affichage des données client --%>
		<p>Nom : ${utilisateur.nom }</p>
		<p>Prenom : ${utilisateur.prenom }</p>
		<p>Email : ${utilisateur.email }</p>
		<p>Mot de passe : ${utilisateur.mdp }</p>
		<p>Genre : ${utilisateur.genre }</p> 
		<p>date de naissance : ${utilisateur.dateNaissance }</p>
		<p>coordonnées : ${utilisateur.coordonnees }</p>
		
	</body>
</html>