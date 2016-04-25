<%-- 
    Document   : creation_tache
    Created on : 23 avr. 2016, 15:08:51
    Author     : charles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    
    <head>
        <head>
        <title>Poster une annonce</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style_register.css" />
        <link rel="stylesheet" type="text/css" href="css/skel.css" />
        <link rel="stylesheet" type="text/css" href="css/style-xlarge.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery-ui.css"/>

        <script type="text/javascript" src="js/modernizr.custom.04022.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#input-begin").datepicker();
            });
            $(function () {
                $("#input-end").datepicker();
            });
        </script>
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
            h4 {
                text-align: center;
            }
        </style>

    </head>
    
    
    <body>
        <!-- Header A mettre sur chaque page html/jsp -->
        <header id="header">
            <h1><a>BlablaJob</a></h1>
            <nav id="nav">
                <ul>
                    <li><a href="index.html">Accueil</a></li>
                    <li><a href="comment_ca_marche.html">Comment ça marche</a></li>
                    <li><a href="connexion.jsp">Connexion</a></li>
                    <li><a href="inscrire.jsp" class="button special">S'inscrire</a></li>
                </ul>
            </nav>
        </header>
        
        
        <!-- Corps du texte : creation d'une tache -->
        <div class="container">
            <section class="af-wrapper">
                <h3>Poster une annonce sur BlablaJob</h3>			
                <form class="af-form" id="af-form" method="get" action="/projet_web/creation_tache">
                    <div class="af-outer">
                        <div class="af-inner">
                            <label for="input-title">Titre</label>
                            <input type="text" name="title" id="input-title" placeholder="Titre" />
                        </div>
                    </div>
                    <div class="af-outer">
                        <div class="af-inner">
                            <label for="input-description">Description</label>
                            <textarea name="description" id="input-description" rows="5" cols="30" 
                                      placeholder="Description du travail à réaliser (200 caractères max)" maxlength="200"> 
                            </textarea>
                        </div>
                    </div>	
                    <div class="af-outer">
                        <div class="af-inner">	
                            <label id=prix for="input-price">Rémunération</label>
                            <input type="number" name="price" step="1" min="0" max="10000" id="input-price" 
                                   placeholder="Rémunération en €">
                        </div>
                    </div>					


 
                    <h4>
                        Compétances
                    </h4>
                      
                    <div class="af-outer">	
                            <div class="af-inner">				
                                <label >Bricolage</label>
                                <select name="Bricolage">
                                    <option value="true">Oui</option>
                                    <option value="false">Non</option>
                                </select>
                            </div>
                    </div>
                    <div class="af-outer">	
                            <div class="af-inner">				
                                <label >Menage</label>
                                <select name="Menage">
                                    <option value="true">Oui</option>
                                    <option value="false">Non</option>
                                </select>
                            </div>
                    </div>
                    <div class="af-outer">	
                            <div class="af-inner">				
                                <label >Jardinage</label>
                                <select name="Jardinage">
                                    <option value="true">Oui</option>
                                    <option value="false">Non</option>
                                </select>
                            </div>
                    </div>
                    <div class="af-outer">	
                            <div class="af-inner">				
                                <label >Pyrogravure sur boîte de camembert</label>
                                <select name="Pyrogravure">
                                    <option value="true">Oui</option>
                                    <option value="false">Non</option>
                                </select>
                            </div>
                    </div>
                    <div class="af-outer">	
                            <div class="af-inner">				
                                <label >Peinture</label>
                                <select name="peinture">
                                    <option value="true">Oui</option>
                                    <option value="false">Non</option>
                                </select>
                            </div>
                    </div>
                    <div class="af-outer">	
                            <div class="af-inner">				
                                <label >Réparation</label>
                                <select name="Reparation">
                                    <option value="true">Oui</option>
                                    <option value="false">Non</option>
                                </select>
                            </div>
                    </div>
                    <div class="af-outer">	
                            <div class="af-inner">				
                                <label >Cuisine</label>
                                <select name="Cuisine">
                                    <option value="true">Oui</option>
                                    <option value="false">Non</option>
                                </select>
                            </div>
                    </div>
                    <div class="af-outer">	
                            <div class="af-inner">				
                                <label >Aide à la personne</label>
                                <select name="Aide">
                                    <option value="true">Oui</option>
                                    <option value="false">Non</option>
                                </select>
                            </div>
                    </div>
                   
                  
                    
                    <div class="af-outer">
                        <div class="af-inner">
                            <label for="input-addr">Adresse</label>
                            <input type="text" name="address" id="input-addr" placeholder="Adresse postale" /> 
                        </div>
                    </div>

                    <div class="af-outer">
                        <div class="af-inner">
                            <label for="input-codeP">Code postal</label>	
                            <input type="text" name="codeP" id="input-codeP" placeholder="Code postal" /> 
                        </div>
                    </div>

                    <div class="af-outer">
                        <div class="af-inner">
                            <label for="input-city">Ville</label>	
                            <input type="text" name="city" id="input-city" placeholder="Ville" /> 
                        </div>
                    </div>

                    <div class="af-outer">
                        <div class="af-inner">
                            <label id="begin" for="input-begin">Date de début</label>	
                            <input type="date" name="begin_date" id="input-begin" placeholder="jj/mm/aaaa" /> 
                        </div>
                    </div>

                    <div class="af-outer">
                        <div class="af-inner">
                            <label for="input-end">Date de fin</label>	
                            <input type="date" name="end_date" id="input-end" placeholder="jj/mm/aaaa" /> 
                        </div>
                    </div>

                    <div class="af-outer">
                        <div class="af-inner">

                            <label id="box"><input type="checkbox" name="remember_me" /></label>
                            Je certifie avoir lu et accepté les <a href="#">conditions générales</a> 
                                d'utilisation du site BlablaJob.  
                        </div>
                    </div>	
                    
                    
                    <input type="submit" name="submit_tache" value="Poster" /> 

                </form>
            </section>
        </div>
        
        
</html>
