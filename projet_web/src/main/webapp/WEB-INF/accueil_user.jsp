<%-- 
    Document   : accueil_user
    Created on : 22 avr. 2016, 22:57:12
    Author     : qinm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page d'accueil</title>
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
                    <li><a href="controleur?action=getPage&view=accueil&id=${userr}">Page d'accueil</a></li>
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

    </body>
</html>
