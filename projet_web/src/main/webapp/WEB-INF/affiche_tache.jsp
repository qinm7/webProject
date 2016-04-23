<%-- 
    Document   : affiche_tache
    Created on : 23 avr. 2016, 18:21:37
    Author     : utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
              
        <p>idTaches : ${nouvelletache.idTaches}</p>
        <p>Titre : ${nouvelletache.titre}</p>
        <p>description : ${nouvelletache.description}</p>
        <p>remuneration : ${nouvelletache.remuneration}</p>
        <p>Longitude : ${nouvelletache.longitude}</p>
        <p>Latitude : ${nouvelletache.latitude}</p>
        <p>datedébut : ${nouvelletache.datedébut}</p>
        <p>datefin : ${nouvelletache.datefin}</p>
        <p>email : ${nouvelletache.email}</p>
        
        <p>bricolage : ${nouvelletache.competance.bricolage}</p>
        <p>menage : ${nouvelletache.competance.menage}</p>
        <p>jardinage : ${nouvelletache.competance.jardinage}</p>
        <p>pyro : ${nouvelletache.competance.pyro}</p>
        <p>peinture : ${nouvelletache.competance.peinture}</p>
        
        
        
        
    </body>
</html>
