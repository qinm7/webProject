<%-- 
    Document   : modifier_adresse
    Created on : 25 avr. 2016, 23:43:03
    Author     : qinm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><meta charset="UTF-8"/>
    <title>Modifier une localisation</title></head>
    
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
                <h3>Modification de la localisation</h3>			
                <form class="af-form" id="af-form" method="post" action="controleur" accept-charset="UTF-8" >
                    <fieldset>
                        <legend>Informations utilisateur</legend>
                        <div class="af-outer">
                            <div class="af-inner">
                                <label for="input-addr">Adresse</label>
                                <input type="text" name="address" id="input-addr" required placeholder="Adresse postale" />
                                <br/> 
                                <span style="color:red"> ${AdrErreur} </span>
                            </div>
                        </div>

                        <div class="af-outer">
                            <div class="af-inner">
                                <label for="input-codeP">Code postal</label>	
                                <input type="text" name="codeP" id="input-codeP" required placeholder="Code postale" /> 
                            </div>
                        </div>

                        <div class="af-outer">
                            <div class="af-inner">
                                <label for="input-city">Ville</label>	
                                <input type="text" name="city" id="input-city" required placeholder="Ville" /> 
                            </div>
                        </div>
                    </fieldset>	
                    <input type="hidden" name="email" value=${user} />        
                    <input name="confirm" type="submit" value="Valider" />      
                    <input type="hidden" name="action" value="modifier_loca" />
                </form>
            </section>
        </div>
                            
    </body>  
</html>