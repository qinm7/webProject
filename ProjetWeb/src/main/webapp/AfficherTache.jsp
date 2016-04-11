<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title>Affichage d'une tâche</title>
		<link type="text/css" rel="stylesheet" href="css/style.css" />
	</head>
	
	<body>
		<%-- affichage du message de confirmation/echec --%>
		<p class="info">${message1 }</p>
		
		<%--affichage des données client --%>
		
		<p>Titre : ${tache.titre }</p>
		<p>Description : ${tache.description }</p>
		<p>Remuneration : ${tache.remuneration }</p>
		<p>date de début au plus tôt : ${tache.dateDebutPlusTot }</p>
		<p> date de début au plus tard : ${tache.dateDebutPlusTard }</p> 

	</body>
</html>