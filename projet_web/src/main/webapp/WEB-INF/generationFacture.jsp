<%-- 
    Document   : generationFacture
    Created on : 29 avr. 2016, 20:32:41
    Author     : verriesa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8"/>
    <title>Facture ${commanditaire.prenom} ${commanditaire.nom}</title>
    <link href="http://fonts.googleapis.com/css?family=Nunito:300|Raleway:200,300" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="css/facture.css" />
    <script>
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; //January is 0!

        var yyyy = today.getFullYear();
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }
        var today = dd + '.' + mm + '.' + yyyy;
        document.getElementById("DATE").innerHTML = today;
    </script>
</head>
<body>
    <header>
        <h1>FACTURE
            <h2>${commanditaire.prenom} ${commanditaire.nom} − BlablaJob</h2>
        </h1>
    </header>
    <section class="flex">
        <dl>
            <dt>Facture #</dt>
            <dd>20140${idtache}</dd>
            <dt>Date de facturation</dt>
            <dd>xx.04.2016</dd>
        </dl>
    </section>
    <section class="flex">
        <dl class="bloc">
            <dt>Facturé à:</dt>
            <dd>
                ${commanditaire.prenom} ${commanditaire.nom}<br/>
                Latitude :${commanditaire.latitude}<br/> ${commanditaire.longitude}<br/>
                <dl>
                    <dt>Téléphone</dt>
                    <dd>(0033) 06 60 06 06 60</dd>
                    <dt>Courriel</dt>
                    <dd>${commanditaire.email}</dd>
                </dl>
            </dd>
        </dl>
        <dl class="bloc">
            <dt>Description de service:</dt>
            <dd>${titre}</dd>
            <dt>Période totale:</dt>
            <dd>N/C</dd>
        </dl>
    </section>
    <table>
        <thead>
            <tr> 
                <th>Période</th>
                <th>Description</th>
                <th>Heures</th>
                <th>Taux</th>
                <th>Montant</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>N/C</td>
                <td>${description}</td>
                <td>24&#8202;h</td>
                <td>N/C</td>
                <td>${remuneration}&#8202;€</td>
            </tr>
        </tbody>
        <tfoot>
            <tr> 
                <td colspan="3">− Faire les chèques payable au nom de ${executant.prenom} ${executant.nom} −</td>
                <td>Total:</td>
                <td>${remuneration}&#8202;€</td>
            </tr>
        </tfoot>
    </table>
    <footer>
        <p>BlablaJob – Plateforme de mise en relation | <a href="#">BlablaJob.com</a></p>
    </footer>
</body> 