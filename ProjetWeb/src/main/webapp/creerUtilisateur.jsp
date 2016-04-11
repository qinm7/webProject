<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un utilisateur</title>
        <link type="text/css" rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <div>
            <form method="get" action="creationutilisateur">
                <fieldset>
                    <legend>Informations utilisateur</legend>
    
                    <label for="nomUtilisateur">Nom <span class="requis">*</span></label>
                    <input type="text" id="nomUtilisateur" name="nomUtilisateur" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="prenomUtilisateur">Prénom <span class="requis">*</span></label>
                    <input type="text" id="prenomUtilisateur" name="prenomUtilisateur" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="dateNaissanceUtilisateur">Date de naissance <span class="requis">*</span></label>
                    <input type="text" id="dateNaissanceUtilisateur" name="dateNaissanceUtilisateur" value="" size="20" maxlength="60" />
                    <br />
                    
                    <label for="emailUtilisateur">adresse e-mail <span class="requis">*</span></label>
                    <input type="text" id="emailUtilisateur" name="emailUtilisateur" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="mdpUtilisateur">Mot de Passe <span class="requis">*</span></label>
                    <input type="text" id="mdpUtilisateur" name="mdpUtilisateur" value="" size="20" maxlength="60" />
                    <br />
    
                    <label for="adresseUtilisateur">Adresse résidentielle <span class="requis">*</span></label>
                    <input type="text" id="adresseUtilisateur" name="adresseUtilisateur" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="genreUtilisateur">Genre<span class="requis">*</span></label>
                    <input type="text" id="genreUtilisateur" name="genreUtilisateur" value="" size="20" maxlength="60" />
                    <br />
                    
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>