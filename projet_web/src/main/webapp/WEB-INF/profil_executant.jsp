<%-- 
    Document   : profil_executant
    Created on : 28 avr. 2016, 21:14:28
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
                    <li>
                    	<form method="get" action="controleur">
                            <input type="hidden" name="action" value="getPage" />
                            <input type="hidden" name="view" value="accueil" />
                            <input type="hidden" name="id" value=${user} />
                            <input type="submit" value="Retour" class="button special"/>
                    	</form>
                    </li>
                </ul>
            </nav>
        </header>
        <br/>
        <div class="container">
            <h1>Profil de l'exécutant : tache ${tache}</h1>
            <%--affichage des données clients --%>
            Nom : ${utilisateur.nom} <br/>
            Prénom : ${utilisateur.prenom} <br/> 
            Email : ${utilisateur.email} <br/>
            Genre : ${utilisateur.genre} <br/> 
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
            </tr>    
        </div>
    </body>
</html>
