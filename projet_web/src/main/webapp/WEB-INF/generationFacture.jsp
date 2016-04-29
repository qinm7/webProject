<%-- 
    Document   : generationFacture
    Created on : 29 avr. 2016, 20:32:41
    Author     : verriesa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facture</title>
    </head>
    <body>
        <h1>
            Bonjour M.${user}, voilà votre facture pour la tâche ${titre}.
        </h1>
        <p>
            Montant dû : ${remuneration}
            <br>
            Description de la tâche : ${description}
        </p>
        
    </body>
</html>
