<%-- 
    Document   : AvisEx
    Created on : 28 avr. 2016, 10:05:02
    Author     : qinm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Donner son avis</title>
        <link type="text/css" rel="stylesheet" href="css/style_register.css" />
        <link rel="stylesheet" type="text/css" href="css/skel.css" />
        <link rel="stylesheet" type="text/css" href="css/style-xlarge.css" />
        <link rel="stylesheet" type="text/css" href="css/profil.css" /> 

        <script>
            function check() {
                var a = document.getElementsByName("note");
                var j = 0;
                for (var i = 0; i < a.length; i++) {
                    if (a[i].type == "checkbox") {
                        if (a[i].checked) {
                            j++;
                        }
                    }
                }
                if (j == 0) {
                    alert("Veuillez mettre une note, SVP !");
                    return false;    
                } else if (j == 1) {
                    return true;
                } else {
                    alert("Veuillez mettre qu'une SEULE note, SVP !");
                    return false;
                }    
            }
        </script>    
    </head>    
    <body>
        <!-- Corps du texte : creation d'une tache -->
        <div class="container">
            <section class="af-wrapper">
                <h3>Donner votre avis sur la personne qui a réalisée la tâche</h3>			
                <form class="af-form" id="af-form" method="post" action="controleur" onsubmit="return check()">
                    <div class="af-outer">
                        <div class="af-inner">
                            <label for="input-description">Commentaire</label>
                            <textarea name="commentaire" id="input-description" rows="5" cols="30" required maxlength="200" ></textarea>
                        </div>
                    </div>					
                    <div class="af-outer">
                        <div class="af-inner">
                            <label>Note /5</label>
                            <input type="checkbox" name="note" value="0"/>0<br/>
                            <input type="checkbox" name="note" value="1"/>1<br/>
                            <input type="checkbox" name="note" value="2"/>2<br/>
                            <label></label>
                            <input type="checkbox" name="note" value="3"/>3<br/>
                            <input type="checkbox" name="note" value="4"/>4<br/>
                            <input type="checkbox" name="note" value="5"/>5<br/>				
                        </div>
                    </div>
                    <input type="hidden" name="view" value=${vue} />
                    <input type="hidden" name="id" value=${user} />
                    <input type="hidden" name="facture" value=${price} />
                    <input type="hidden" name="executant" value=${executant} />
                    <input type="hidden" name="idtache" value=${idtache} />
                    <input type="hidden" name="action" value="avis" />
                    <input type="submit" name="submit_tache" value="Commenter" /> 
                </form>
            </section>
        </div>
    </body>

</html>
