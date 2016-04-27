CREATE SEQUENCE id_seq;

CREATE TABLE Utilisateur (
    Email Varchar (30),
    Motdepasse Varchar (20),
    Nom Varchar (20),
    Prenom Varchar (20),
    Sexe Varchar (20),
    Datenaissance Varchar (20),
    Longitude float,
    Latitude float,
    PRIMARY KEY (Email)
);

CREATE TABLE Executant (
    Email Varchar (30),
    PRIMARY KEY (Email),
    FOREIGN KEY (Email)
        REFERENCES Utilisateur (Email)
);

CREATE TABLE Commanditaire (
    Email Varchar (30),
    PRIMARY KEY (Email),
    FOREIGN KEY (Email)
        REFERENCES Utilisateur (Email)
);

CREATE TABLE Tache (
    IdTache INTEGER,
    Titre VARCHAR (100),
    Description VARCHAR (200),
    Remuneration VARCHAR (10),
    Longitude Float,
    Latitude Float,
    Datebegin Varchar (20),
    Dateend Varchar (20),
    Email Varchar (30),
    PRIMARY KEY (IdTache),
    FOREIGN KEY (Email)
        REFERENCES Commanditaire (Email)
);

CREATE TABLE TacheAtomique (
    IdTache Integer,
    PRIMARY KEY (IdTache),
    FOREIGN KEY (IdTache)
    REFERENCES Tache (IdTache)
);

CREATE TABLE TacheComposee (
    IdTache Integer,
    PRIMARY KEY (IdTache),
    FOREIGN KEY (IdTache)
        REFERENCES Tache (IdTache)
);
        
CREATE TABLE Avis (
    IdAvis Integer,
    Email Varchar (30),
    Note Integer,
    Commentaire Varchar (200),
    PRIMARY KEY (IdAvis, Email),
    FOREIGN KEY (Email)
	REFERENCES Utilisateur (Email)
);

CREATE TABLE Facture (
    facture integer,
    IdTache integer,
    PRIMARY KEY (IdTache),
    FOREIGN KEY (IdTache)
    	REFERENCES Tache (IdTache)
);
        
CREATE TABLE Emet (
    IdAvis integer,
    Email Varchar (30), 
    PRIMARY KEY (IdAvis),
    FOREIGN KEY (IdAvis)
        REFERENCES Avis (IdAvis),
    FOREIGN KEY (Email)
	REFERENCES Utilisateur (Email)
);	
	       
CREATE TABLE Engage (	
    Email Varchar (30),
    IdTache integer,
    PRIMARY KEY (IdTache),
    FOREIGN KEY (IdTache)
    	REFERENCES Tache (IdTache),
    FOREIGN KEY (Email)
        REFERENCES Executant (Email)
);	

CREATE TABLE EstComposee (
    IdTacheComp integer,
    IdTacheAtom integer,
    PRIMARY KEY (IdTacheComp, IdTacheAtom),
    FOREIGN KEY (IdTacheComp)
        REFERENCES TacheComposee (IdTache),
    FOREIGN KEY (IdTacheAtom)
        REFERENCES TacheAtomique (IdTache)
);
    
CREATE TABLE Competence (
    IdSkill Integer,
    Skill Varchar (100),
    PRIMARY KEY (idSkill)
);   
    
CREATE TABLE Possede (
    Email Varchar (30),
    IdSkill Integer,
    PRIMARY KEY (Email, IdSkill),
    FOREIGN KEY (Email)
        REFERENCES Executant (Email),
    FOREIGN KEY (IdSkill) 
        REFERENCES Competence (IdSkill)
);		 
	
CREATE TABLE Necessite (
    IdTache integer,
    IdSkill integer,
    PRIMARY KEY (IdTache, IdSkill), 
    FOREIGN KEY (IdTache)
    	REFERENCES Tache (IdTache),
    FOREIGN KEY (IdSkill) 
    	REFERENCES Competence (IdSkill)
);

INSERT INTO competence VALUES ('1','Bricolage');

INSERT INTO competence VALUES ('2','Ménage');

INSERT INTO competence VALUES ('3','Jardinage');

INSERT INTO competence VALUES ('4','Pyrogravure sur boîte de camembert');

INSERT INTO competence VALUES ('5','Peinture');

INSERT INTO competence VALUES ('6','Réparation');

INSERT INTO competence VALUES ('7','Cuisine');

INSERT INTO competence VALUES ('8','Aide à la personne');