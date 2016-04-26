<%-- 
    Document   : inscription
    Created on : 13 avr. 2016, 18:02:21
    Author     : qinm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>S'inscrire</title>
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style_register.css" />
        <link rel="stylesheet" type="text/css" href="css/skel.css" />
        <link rel="stylesheet" type="text/css" href="css/style-xlarge.css" />
        <link rel="stylesheet" type="text/css" href="css/inscrire.css" />
        <!--Srcipt-->
        <script type="text/javascript" src="js/modernizr.custom.04022.js"></script>		
        <script type="text/javascript" src="js/inscrire.js"> </script>

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
        
        <div class="container">

            <section class="af-wrapper">
                <h3>Inscription à BlablaJob</h3>			
                <form class="af-form" id="af-form" method="post" action="controleur" onsubmit="return verif(this)" >
                    <fieldset>
                        <legend>Informations utilisateur</legend>
                        <div class="af-outer">
                            <div class="af-inner">
                                <label for="input-email">E-mail</label>
                                <input type="email" name="email" id="input-email" required placeholder="E-mail" />
                                <br/> 
                                <span style="color:red"> ${EmailErr} </span>
                            </div>
                        </div>
                        <div class="af-outer">
                            <div class="af-inner">
                                <label for="input-password">Mot de passe</label>
                                <input type="password" name="password" value="" id="input-password" required placeholder="Mot de passe">
                                <br/>
                                <span id="mySpan" style="color:red"></span> 
                            </div>
                        </div>	
                        <div class="af-outer">
                            <div class="af-inner">	
                                <label for="input-confirm">Confirmation</label>
                                <input type="password" name="confirm" value="" id="input-confirm" required placeholder="Confirmez le mot de passe">
                                <br/>
                                <span id="mySpan1" style="color:red"></span> 
                            </div>
                        </div>					

                        <div class="af-outer">
                            <div class="af-inner">
                                <label for="input-lastname">Nom</label>
                                <input type="text" name="lastname" id="input-lastname" required placeholder="Nom">
                            </div>
                        </div>		

                        <div class="af-outer">
                            <div class="af-inner">
                                <label for="input-lastname">Prénom</label>
                                <input type="text" name="firstname" id="input-firstname" required placeholder="Prénom">
                            </div>
                        </div>

                        <div class="af-outer">
                            <div class="af-inner">	
                                <label id="sexe" >Sexe</label>		
                                <select class="styled-select" name="sex" id="gender" >
                                    <option value="-1">Choix</option>
                                    <option value="Homme">Homme</option>
                                    <option value="Femme">Femme</option>
                                </select>
                                <br/>
                                <span id="mySex" style="color:red"></span>
                            </div>
                        </div>

                        <div class="af-outer">	
                            <div class="af-inner">				
                                <label id="bdate">Date de naissance</label>
                                <select class="styled-select" name="Birthday_day" id="day">
                                    <option value="-1">Jour</option>
                                    <option value="01">1</option>
                                    <option value="02">2</option>
                                    <option value="03">3</option> 
                                    <option value="04">4</option>
                                    <option value="05">5</option>
                                    <option value="06">6</option>
                                    <option value="07">7</option>
                                    <option value="08">8</option>
                                    <option value="09">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                    <option value="21">21</option>
                                    <option value="22">22</option>
                                    <option value="23">23</option>
                                    <option value="24">24</option>
                                    <option value="25">25</option>
                                    <option value="26">26</option>
                                    <option value="27">27</option>
                                    <option value="28">28</option>
                                    <option value="29">29</option>
                                    <option value="30">30</option> 
                                    <option value="31">31</option>
                                </select>

                                <select class="styled-select" name="Birthday_Month" id="month">
                                    <option value="-1">Mois</option>
                                    <option value="01">Janvier</option>
                                    <option value="02">Février</option>
                                    <option value="03">Mars</option>
                                    <option value="04">Avril</option>
                                    <option value="05">Mai</option>
                                    <option value="06">Juin</option>
                                    <option value="07">Juillet</option>
                                    <option value="08">Août</option>
                                    <option value="09">Septembre</option>
                                    <option value="10">Octobre</option>
                                    <option value="11">Novembre</option>
                                    <option value="12">Décembre</option>
                                </select>

                                <select class="styled-select" name="Birthday_Year" id="year"> 
                                    <option value="-1">Année</option>
                                    <option value="2012">2012</option>
                                    <option value="2011">2011</option>
                                    <option value="2010">2010</option>
                                    <option value="2009">2009</option>
                                    <option value="2008">2008</option>
                                    <option value="2007">2007</option>
                                    <option value="2006">2006</option>
                                    <option value="2005">2005</option>
                                    <option value="2004">2004</option>
                                    <option value="2003">2003</option>
                                    <option value="2002">2002</option>
                                    <option value="2001">2001</option>
                                    <option value="2000">2000</option> 
                                    <option value="1999">1999</option>
                                    <option value="1998">1998</option>
                                    <option value="1997">1997</option>
                                    <option value="1996">1996</option>
                                    <option value="1995">1995</option>
                                    <option value="1994">1994</option>
                                    <option value="1993">1993</option>
                                    <option value="1992">1992</option>
                                    <option value="1991">1991</option>
                                    <option value="1990">1990</option> 
                                    <option value="1989">1989</option>
                                    <option value="1988">1988</option>
                                    <option value="1987">1987</option>
                                    <option value="1986">1986</option>
                                    <option value="1985">1985</option>
                                    <option value="1984">1984</option>
                                    <option value="1983">1983</option>
                                    <option value="1982">1982</option>
                                    <option value="1981">1981</option>
                                    <option value="1980">1980</option>
                                    <option value="1979">1979</option>
                                    <option value="1978">1978</option>
                                    <option value="1977">1977</option>
                                    <option value="1976">1976</option>
                                    <option value="1975">1975</option>
                                    <option value="1974">1974</option>
                                    <option value="1973">1973</option>
                                    <option value="1972">1972</option>
                                    <option value="1971">1971</option>
                                    <option value="1970">1970</option> 
                                    <option value="1969">1969</option>
                                    <option value="1968">1968</option>
                                    <option value="1967">1967</option>
                                    <option value="1966">1966</option>
                                    <option value="1965">1965</option>
                                    <option value="1964">1964</option>
                                    <option value="1963">1963</option>
                                    <option value="1962">1962</option>
                                    <option value="1961">1961</option>
                                    <option value="1960">1960</option>
                                    <option value="1959">1959</option>
                                    <option value="1958">1958</option>
                                    <option value="1957">1957</option>
                                    <option value="1956">1956</option>
                                    <option value="1955">1955</option>
                                    <option value="1954">1954</option>
                                    <option value="1953">1953</option>
                                    <option value="1952">1952</option>
                                    <option value="1951">1951</option>
                                    <option value="1950">1950</option> 
                                    <option value="1949">1949</option>
                                    <option value="1948">1948</option>
                                    <option value="1947">1947</option>
                                    <option value="1946">1946</option>
                                    <option value="1945">1945</option>
                                    <option value="1944">1944</option>
                                    <option value="1943">1943</option>
                                    <option value="1942">1942</option>
                                    <option value="1941">1941</option>
                                    <option value="1940">1940</option>
                                </select>
                                <br/>
                                <span id="myBirth" style="color:red"></span>
                            </div>
                        </div>

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
                    <fieldset>
                        <legend>Choix de compétences (facultatif)</legend>
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
                    <div class="af-outer">
                        <div class="af-inner">
                            <label id="box"><input type="checkbox" name="check" required /></label>
                            Je certifie avoir lu et accepté les <a href="#">conditions générales</a> d'utilisation du site BlablaJob.  
                        </div>
                    </div>	

                    <input type="submit" name="confirm" value="S'inscrire" /> 
                    <input type="hidden" name="action" value="inscrire" />
                </form>
            </section>
        </div>
                            
    </body>  
</html>
