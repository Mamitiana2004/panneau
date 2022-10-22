create database consomation;
\c consomation;

CREATE TABLE appareil 
(
    idAppareil BIGSERIAL PRIMARY KEY,
    nom varchar(20),
    intensite int,
    tension int,
    heureDebut int,
    heureFin int
);

CREATE TABLE batterie
(
    idBatterie BIGSERIAL PRIMARY KEY,
    puissance int,
    prix int
);

CREATE TABLE paneau
(
    idPaneau BIGSERIAL PRIMARY KEY,
    puissance int,
    prix int
);

-- Create a new relational table with 3 columns

CREATE TABLE electro 
(
    idElectro BIGSERIAL PRIMARY KEY,
    nbrAppareil int,
    nbrBatterie int,
    nbrPaneau int
);

CREATE TABLE utilisateur 
(
    idUser BIGSERIAL PRIMARY KEY,
    nomUser varchar(40),
    idAppareil int,
    idBatterie int,
    idBatterie int,
    CONSTRAINT idApp FOREIGN KEY (idAppareil) REFERENCES appareil(idAppareil),
    CONSTRAINT idBatt FOREIGN KEY (idBatterie) REFERENCES batterie(idBatterie),
    CONSTRAINT idPan FOREIGN KEY (idPaneau) REFERENCES paneau(idPaneau)
);