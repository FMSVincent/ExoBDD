-- Reconstruction de la base de données
DROP DATABASE IF EXISTS Shop;
CREATE DATABASE Shop;
USE Shop;
 
-- Construction de la table des articles en vente
CREATE TABLE T_Articles (
  IdArticle       int(4)      PRIMARY KEY AUTO_INCREMENT,
  Description     varchar(30) NOT NULL,
  Brand           varchar(30) NOT NULL,
  UnitaryPrice    float(8)    NOT NULL
) ENGINE = InnoDB;
 
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('WebCam', 'Logitech', 0);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Casque Audio', 'Syno', 105);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Office', 'Microsoft', 150);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('S10', 'Samsung', 2000);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Macbook', 'Apple', 2000);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Iphone50', 'Apple', 20000);
 
 
SELECT * FROM T_Articles;