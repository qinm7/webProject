<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'une tâche</title>
        <link type="text/css" rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <div>
            <form method="get" action="creationtache">
                <fieldset>
                    <legend>Informations utilisateur</legend>
    
                    <label for="nomUtilisateur">Nom <span class="requis">*</span></label>
                    <input type="text" id="nomUtilisateur" name="nomUtilisateur" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="prenomUtilisateur">Prénom <span class="requis">*</span></label>
                    <input type="text" id="prenomUtilisateur" name="prenomUtilisateur" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="emailUtilisateur">adresse email <span class="requis">*</span></label>
                    <input type="text" id="emailUtilisateur" name="emailUtilisateur" value="" size="20" maxlength="20" />
                    <br />
    
                    <label for="adresseUtilisateur">Adresse de la tâche <span class="requis">*</span></label>
                    <input type="text" id="adresseUtilisateur" name="adresseUtilisateur" value="" size="20" maxlength="20" />
                    <br />
     
                </fieldset>
                
                <fieldset>
                    <legend>Informations tâche</legend>

                    <label for="titre">Titre <span class="requis">*</span></label>
                    <input type="text" id="titre" name="titre" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="description">description <span class="requis">*</span></label>
                    <input type="text" id="description" name="description" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="remuneration">Rémunération de la tâche <span class="requis">*</span></label>
                    <input type="text" id="remuneration" name="remuneration" value="" size="20" maxlength="20" />
                    <br />                    
                                        
                    <label for="dateDebutPlusTot">Date de début au plus tôt <span class="requis">*</span></label>
                    <input type="text" id="dateDebutPlusTot" name="dateDebutPlusTot" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="dateDebutPlusTard">Date de début au plus tard <span class="requis">*</span></label>
                    <input type="text" id="dateDebutPlusTard" name="dateDebutPlusTard" value="" size="20" maxlength="20" />
                    <br />                    
                    
                    <label for="atomique">Tâche atomique ? <span class="requis">*</span></label>
                    <input type="text" id="atomique" name="atomique" value="" size="20" maxlength="20" />
                    <br />

                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>