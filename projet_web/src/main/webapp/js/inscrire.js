document.forms[0].elements[0].focus();
            function verifForm(f) {
                if (f.elements['input-password'].value == f.elements['input-confirm'].value)
                    return true;
                return false;
            }
            function verifForm1(f) {
                if (f.elements['gender'].value != -1)
                    return true;
                return false;
            }
            function verifForm2(f) {
                if (f.elements['day'].value != -1)
                    return true;
                return false;
            }
            function verifForm3(f) {
                if (f.elements['month'].value != -1)
                    return true;
                return false;
            }
            function verifForm4(f) {
                if (f.elements['year'].value != -1)
                    return true;
                return false;
            }
            function verif(f) {
                var verif = verifForm(f) && verifForm1(f) && verifForm2(f) && verifForm3(f) && verifForm4(f);
                if (!verifForm(f)) {
                    mySpan.innerHTML = "Les mots de passe sont différents !";
                    mySpan1.innerHTML = "Les mots de passe sont différents !";
                }
                else {
                    mySpan.innerHTML = "";
                    mySpan1.innerHTML = "";
                }
                if (!verifForm1(f)) {
                    mySex.innerHTML = "Veuillez préciser votre sexe !";
                }
                else {
                    mySex.innerHTML = "";
                }
                if (!(verifForm2(f) && verifForm3(f) && verifForm4(f))) {
                    myBirth.innerHTML = "Veuillez préciser votre date de naissance !";
                }
                else {
                    myBirth.innerHTML = ""
                }
                return verif;
            }

