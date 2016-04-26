<%-- 
    Document   : modifier_skill
    Created on : 25 avr. 2016, 23:44:05
    Author     : qinm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier les compétences</title>
    
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style_register.css" />
        <link rel="stylesheet" type="text/css" href="css/skel.css" />
        <link rel="stylesheet" type="text/css" href="css/style-xlarge.css" />

        <script type="text/javascript" src="js/modernizr.custom.04022.js"></script>
        
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

            fieldset {
                padding: 10px;
                border: 1px #0568CD solid;
                margin: 10px;
            }

            legend {
                font-weight: bold;
                color: #0568CD;
            }

            .info {
                font-size : 8pt;
            }
        </style>		
    </head>
    <body>
        <!-- Header A mettre sur chaque page html/jsp -->
        <header id="header">
            <h1><a>BlablaJob</a></h1>
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
        
        <div class="container">

            <section class="af-wrapper">
                <h3>Modification des compétences</h3>			
                <form class="af-form" id="af-form" method="post" action="controleur" accept-charset="UTF-8"  >
                    <fieldset>
                        <legend>Choix de compétences</legend>
                        <div class="af-outer">
                            <div class="af-inner">
                                <input type="checkbox" name="skill" value="1"> Bricolage</input> </br>
                                <input type="checkbox" name="skill" value="2"> Ménage</input> </br>
                                <input type="checkbox" name="skill" value="3"> Jardinage</input> </br>
                                <input type="checkbox" name="skill" value="4"> Pyrogravure sur boîte de camembert</input> </br>
                                <input type="checkbox" name="skill" value="5"> Peinture</input> </br>
                                <input type="checkbox" name="skill" value="6"> Réparation</input> </br>
                                <input type="checkbox" name="skill" value="7"> Cuisine</input> </br>
                                <input type="checkbox" name="skill" value="8"> Aide à la personne</input> </br>					
                            </div>
                        </div>
                        <span class="info">Des tâches vous seront suggérées en fonction de vos compétences</span>
                    </fieldset>
                    <input type="hidden" name="email" value=${user} /> 
                    <input name="confirm" type="submit" value="Valider" /> 
                    <input type="hidden" name="action" value="modifier_skill" />
                </form>
            </section>
        </div>
                            
    </body>  
</html>