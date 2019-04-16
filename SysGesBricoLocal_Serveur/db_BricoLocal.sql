-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.15 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2015-02-28 19:00:15
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping database structure for bd_bricolocal
CREATE DATABASE IF NOT EXISTS `bd_bricolocal` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bd_bricolocal`;


-- Dumping structure for table bd_bricolocal.tblcode_automatique_achat
CREATE TABLE IF NOT EXISTS `tblcode_automatique_achat` (
  `code_achat` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tblcode_automatique_achat: ~1 rows (approximately)
/*!40000 ALTER TABLE `tblcode_automatique_achat` DISABLE KEYS */;
INSERT INTO `tblcode_automatique_achat` (`code_achat`) VALUES
	(67);
/*!40000 ALTER TABLE `tblcode_automatique_achat` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_achat
CREATE TABLE IF NOT EXISTS `tbl_achat` (
  `id_stock` varchar(20) NOT NULL,
  `code_achat` varchar(20) DEFAULT NULL,
  `nom_fournisseur` varchar(20) DEFAULT NULL,
  `description_article` varchar(40) NOT NULL,
  `description_stock` varchar(20) NOT NULL,
  `quantite` int(11) NOT NULL,
  `prix_stock` decimal(10,0) NOT NULL,
  `date_achat` date DEFAULT NULL,
  `date_enregistrement` datetime DEFAULT NULL,
  PRIMARY KEY (`id_stock`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_achat: ~5 rows (approximately)
/*!40000 ALTER TABLE `tbl_achat` DISABLE KEYS */;
INSERT INTO `tbl_achat` (`id_stock`, `code_achat`, `nom_fournisseur`, `description_article`, `description_stock`, `quantite`, `prix_stock`, `date_achat`, `date_enregistrement`) VALUES
	('Ach_St_61', '12', 'canez', 'four', 'Electromenager', 2, 2, '1111-11-11', '2012-11-13 12:54:11'),
	('Ach_St_62', '12', 'canez', 'four', 'Electromenager', 2, 2, '2111-11-11', '2012-11-13 12:54:20'),
	('Ach_St_63', '54546', 'canez', 'four', 'Electromenager', 55, 22, '1122-11-11', '2013-06-01 01:06:07'),
	('Ach_St_64', '4435', 'canez', 'four', 'Electromenager', 5, 23, '2013-06-01', '2013-06-01 02:30:48'),
	('Ach_St_67', '33333444', 'canez', 'four', 'Electromenager', 36, 34, '2013-05-01', '2013-06-01 02:49:14');
/*!40000 ALTER TABLE `tbl_achat` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_article
CREATE TABLE IF NOT EXISTS `tbl_article` (
  `code_article` varchar(30) NOT NULL,
  `article` varchar(30) DEFAULT NULL,
  `categorie` varchar(30) DEFAULT NULL,
  `prix_article` varchar(20) NOT NULL,
  `date_ajout` datetime DEFAULT NULL,
  PRIMARY KEY (`code_article`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_article: ~3 rows (approximately)
/*!40000 ALTER TABLE `tbl_article` DISABLE KEYS */;
INSERT INTO `tbl_article` (`code_article`, `article`, `categorie`, `prix_article`, `date_ajout`) VALUES
	('BR-ARTCL-11', 'Pelle', 'Construction', '500', '2012-11-13 12:22:20'),
	('BR-ARTCL-12', 'Four', 'Electromenager', '5000', '2012-11-13 12:22:33'),
	('BR-ARTCL-13', 'Secateur', 'Jardinnage', '300', '2012-11-13 12:22:48');
/*!40000 ALTER TABLE `tbl_article` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_article_vendus
CREATE TABLE IF NOT EXISTS `tbl_article_vendus` (
  `ID_fiche` int(10) NOT NULL,
  `utilisateur` varchar(20) NOT NULL,
  `categorie` varchar(40) NOT NULL,
  `article` varchar(40) NOT NULL,
  `quantite` int(10) NOT NULL,
  `prix` double NOT NULL,
  `statut` varchar(10) NOT NULL,
  `date_vente` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_article_vendus: ~7 rows (approximately)
/*!40000 ALTER TABLE `tbl_article_vendus` DISABLE KEYS */;
INSERT INTO `tbl_article_vendus` (`ID_fiche`, `utilisateur`, `categorie`, `article`, `quantite`, `prix`, `statut`, `date_vente`) VALUES
	(84, 'stanley abner', 'Electromenager', 'four', 6, 5000, 'payer', '2012-11-13'),
	(85, 'stanley abner', 'Electromenager', 'four', 2, 5000, 'payer', '2012-11-14'),
	(86, 'stanley abner', 'Electromenager', 'four', 1, 5000, 'payer', '2013-02-14'),
	(87, 'stanley abner', 'Electromenager', 'four', 1, 5000, 'payer', '2013-04-01'),
	(88, 'stanley abner', 'Electromenager', 'four', 1, 5000, 'payer', '2013-06-01'),
	(89, 'stanley abner', 'Electromenager', 'four', 1, 5000, 'payer', '2013-06-01'),
	(90, 'stanley abner', 'Electromenager', 'four', 58, 5000, 'payer', '2013-06-01');
/*!40000 ALTER TABLE `tbl_article_vendus` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_categorie
CREATE TABLE IF NOT EXISTS `tbl_categorie` (
  `code_categorie` varchar(30) NOT NULL,
  `categorie` varchar(50) NOT NULL,
  `date_ajout` datetime DEFAULT NULL,
  PRIMARY KEY (`code_categorie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_categorie: ~3 rows (approximately)
/*!40000 ALTER TABLE `tbl_categorie` DISABLE KEYS */;
INSERT INTO `tbl_categorie` (`code_categorie`, `categorie`, `date_ajout`) VALUES
	('BR-CATGR-2', 'Electromenager', '2012-11-13 12:21:09'),
	('BR-CATGR-3', 'Jardinnage', '2012-11-13 12:21:09'),
	('BR-CATGR-4', 'Construction', '2012-11-13 12:21:09');
/*!40000 ALTER TABLE `tbl_categorie` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_codearticle_automatique
CREATE TABLE IF NOT EXISTS `tbl_codearticle_automatique` (
  `code_automatique` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_codearticle_automatique: ~1 rows (approximately)
/*!40000 ALTER TABLE `tbl_codearticle_automatique` DISABLE KEYS */;
INSERT INTO `tbl_codearticle_automatique` (`code_automatique`) VALUES
	(13);
/*!40000 ALTER TABLE `tbl_codearticle_automatique` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_codecategorie_automatique
CREATE TABLE IF NOT EXISTS `tbl_codecategorie_automatique` (
  `code_automatique` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_codecategorie_automatique: ~1 rows (approximately)
/*!40000 ALTER TABLE `tbl_codecategorie_automatique` DISABLE KEYS */;
INSERT INTO `tbl_codecategorie_automatique` (`code_automatique`) VALUES
	(5);
/*!40000 ALTER TABLE `tbl_codecategorie_automatique` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_codefournisseur_automatique
CREATE TABLE IF NOT EXISTS `tbl_codefournisseur_automatique` (
  `code_automatique` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_codefournisseur_automatique: ~1 rows (approximately)
/*!40000 ALTER TABLE `tbl_codefournisseur_automatique` DISABLE KEYS */;
INSERT INTO `tbl_codefournisseur_automatique` (`code_automatique`) VALUES
	(10);
/*!40000 ALTER TABLE `tbl_codefournisseur_automatique` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_codeutilisateur_automatique
CREATE TABLE IF NOT EXISTS `tbl_codeutilisateur_automatique` (
  `code_automatique` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_codeutilisateur_automatique: ~1 rows (approximately)
/*!40000 ALTER TABLE `tbl_codeutilisateur_automatique` DISABLE KEYS */;
INSERT INTO `tbl_codeutilisateur_automatique` (`code_automatique`) VALUES
	(1);
/*!40000 ALTER TABLE `tbl_codeutilisateur_automatique` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_code_automatique_employer
CREATE TABLE IF NOT EXISTS `tbl_code_automatique_employer` (
  `code_automatique_employer` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bd_bricolocal.tbl_code_automatique_employer: ~1 rows (approximately)
/*!40000 ALTER TABLE `tbl_code_automatique_employer` DISABLE KEYS */;
INSERT INTO `tbl_code_automatique_employer` (`code_automatique_employer`) VALUES
	(2);
/*!40000 ALTER TABLE `tbl_code_automatique_employer` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_code_automatique_payroll
CREATE TABLE IF NOT EXISTS `tbl_code_automatique_payroll` (
  `code_payroll` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_code_automatique_payroll: ~1 rows (approximately)
/*!40000 ALTER TABLE `tbl_code_automatique_payroll` DISABLE KEYS */;
INSERT INTO `tbl_code_automatique_payroll` (`code_payroll`) VALUES
	('193');
/*!40000 ALTER TABLE `tbl_code_automatique_payroll` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_commande
CREATE TABLE IF NOT EXISTS `tbl_commande` (
  `ID_commande` int(10) NOT NULL,
  `utilisateur` varchar(20) NOT NULL,
  `categorie` varchar(40) NOT NULL,
  `article` varchar(40) NOT NULL,
  `quantite` int(10) NOT NULL,
  `prix` double NOT NULL,
  `statut` varchar(11) NOT NULL,
  `date_Commande` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_commande: ~1 rows (approximately)
/*!40000 ALTER TABLE `tbl_commande` DISABLE KEYS */;
INSERT INTO `tbl_commande` (`ID_commande`, `utilisateur`, `categorie`, `article`, `quantite`, `prix`, `statut`, `date_Commande`) VALUES
	(8, 'stanley abner', 'Electromenager', 'four', 188, 5000, 'Non-Valider', '2012-11-13 02:22:06');
/*!40000 ALTER TABLE `tbl_commande` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_contact_employer
CREATE TABLE IF NOT EXISTS `tbl_contact_employer` (
  `code` varchar(20) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `email` varchar(35) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `etat` varchar(11) NOT NULL,
  KEY `fk_codee` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bd_bricolocal.tbl_contact_employer: ~2 rows (approximately)
/*!40000 ALTER TABLE `tbl_contact_employer` DISABLE KEYS */;
INSERT INTO `tbl_contact_employer` (`code`, `telephone`, `email`, `adresse`, `etat`) VALUES
	('cer-wal-1', '31135963', 'wacethebest@gmail.com', 'pv', 'Licencier'),
	('cer-wal-2', '', '', 'delmas', 'Activer');
/*!40000 ALTER TABLE `tbl_contact_employer` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_embaucher_employer
CREATE TABLE IF NOT EXISTS `tbl_embaucher_employer` (
  `code` varchar(20) NOT NULL,
  `fonction` varchar(30) NOT NULL,
  `date` date NOT NULL,
  `salaire` decimal(10,0) DEFAULT NULL,
  `etat` varchar(11) NOT NULL,
  KEY `fk_code` (`code`),
  KEY `fk_fon` (`fonction`),
  CONSTRAINT `fk_fonction_emp` FOREIGN KEY (`fonction`) REFERENCES `tbl_fonction` (`fonction`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bd_bricolocal.tbl_embaucher_employer: ~2 rows (approximately)
/*!40000 ALTER TABLE `tbl_embaucher_employer` DISABLE KEYS */;
INSERT INTO `tbl_embaucher_employer` (`code`, `fonction`, `date`, `salaire`, `etat`) VALUES
	('cer-wal-1', 'Caissier', '2012-11-13', 2222, 'Licencier'),
	('cer-wal-2', 'Caissier', '2012-11-13', 222, 'Activer');
/*!40000 ALTER TABLE `tbl_embaucher_employer` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_employer
CREATE TABLE IF NOT EXISTS `tbl_employer` (
  `code` varchar(20) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `sexe` varchar(9) NOT NULL,
  `nif` varchar(25) NOT NULL,
  `date_naissance` date NOT NULL,
  `etat` varchar(11) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bd_bricolocal.tbl_employer: ~2 rows (approximately)
/*!40000 ALTER TABLE `tbl_employer` DISABLE KEYS */;
INSERT INTO `tbl_employer` (`code`, `nom`, `prenom`, `sexe`, `nif`, `date_naissance`, `etat`) VALUES
	('cer-wal-1', 'cerame', 'walter', 'Masculin', '111-111-111-1', '2013-11-11', 'Licencier'),
	('cer-wal-2', 'cerame', 'walter', 'Masculin', '111-111-111-2', '2103-11-11', 'Activer');
/*!40000 ALTER TABLE `tbl_employer` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_employer_licencier
CREATE TABLE IF NOT EXISTS `tbl_employer_licencier` (
  `code` varchar(20) NOT NULL,
  `motif` varchar(50) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_employer_licencier: ~1 rows (approximately)
/*!40000 ALTER TABLE `tbl_employer_licencier` DISABLE KEYS */;
INSERT INTO `tbl_employer_licencier` (`code`, `motif`, `date`) VALUES
	('cer-wal-1', 'laponyet', '2012-11-13');
/*!40000 ALTER TABLE `tbl_employer_licencier` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_fonction
CREATE TABLE IF NOT EXISTS `tbl_fonction` (
  `fonction` varchar(20) NOT NULL,
  `salaire_minimal` mediumtext NOT NULL,
  `Salaire_maximale` mediumtext NOT NULL,
  PRIMARY KEY (`fonction`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table bd_bricolocal.tbl_fonction: ~7 rows (approximately)
/*!40000 ALTER TABLE `tbl_fonction` DISABLE KEYS */;
INSERT INTO `tbl_fonction` (`fonction`, `salaire_minimal`, `Salaire_maximale`) VALUES
	('Caissier', '100.0', '250.0'),
	('Comptable', '700.0', '800.0'),
	('Directeur Achat', '290.0', '380.0'),
	('Directeur Administra', '390.0', '480.0'),
	('Directeur Vente', '490.0', '580.0'),
	('Livreur', '200', '300'),
	('Secretaire', '200.0', '380.0');
/*!40000 ALTER TABLE `tbl_fonction` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_fournisseur
CREATE TABLE IF NOT EXISTS `tbl_fournisseur` (
  `code_fournisseur` varchar(30) NOT NULL,
  `nom_fournisseur` varchar(50) NOT NULL,
  `categorie_fournie` varchar(50) NOT NULL,
  `nom_article` varchar(50) NOT NULL,
  `adresse_fournisseur` varchar(100) NOT NULL,
  `telephone_fournisseur` varchar(50) NOT NULL,
  `email_fournisseur` varchar(50) NOT NULL,
  `date_ajout` datetime NOT NULL,
  PRIMARY KEY (`code_fournisseur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_fournisseur: ~1 rows (approximately)
/*!40000 ALTER TABLE `tbl_fournisseur` DISABLE KEYS */;
INSERT INTO `tbl_fournisseur` (`code_fournisseur`, `nom_fournisseur`, `categorie_fournie`, `nom_article`, `adresse_fournisseur`, `telephone_fournisseur`, `email_fournisseur`, `date_ajout`) VALUES
	('wace', 'canez', 'Electromenager', 'four', 'pv', '444444444', 'papa', '2102-11-11 00:00:00');
/*!40000 ALTER TABLE `tbl_fournisseur` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_numero_commande_automatique
CREATE TABLE IF NOT EXISTS `tbl_numero_commande_automatique` (
  `numero_commande` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_numero_commande_automatique: ~1 rows (approximately)
/*!40000 ALTER TABLE `tbl_numero_commande_automatique` DISABLE KEYS */;
INSERT INTO `tbl_numero_commande_automatique` (`numero_commande`) VALUES
	(8);
/*!40000 ALTER TABLE `tbl_numero_commande_automatique` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_numero_fiche_vente_automatique
CREATE TABLE IF NOT EXISTS `tbl_numero_fiche_vente_automatique` (
  `numero_fiche` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_numero_fiche_vente_automatique: ~1 rows (approximately)
/*!40000 ALTER TABLE `tbl_numero_fiche_vente_automatique` DISABLE KEYS */;
INSERT INTO `tbl_numero_fiche_vente_automatique` (`numero_fiche`) VALUES
	(91);
/*!40000 ALTER TABLE `tbl_numero_fiche_vente_automatique` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_payroll
CREATE TABLE IF NOT EXISTS `tbl_payroll` (
  `code_payroll` varchar(15) NOT NULL,
  `code` varchar(15) NOT NULL,
  `date_enregistrement` date NOT NULL,
  PRIMARY KEY (`code_payroll`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_payroll: ~7 rows (approximately)
/*!40000 ALTER TABLE `tbl_payroll` DISABLE KEYS */;
INSERT INTO `tbl_payroll` (`code_payroll`, `code`, `date_enregistrement`) VALUES
	('pay_179', '1', '2013-04-03'),
	('pay_181', '1', '2013-04-03'),
	('pay_182', '1', '2013-05-16'),
	('pay_185', 'fon-sta-64', '2013-05-16'),
	('pay_187', 'fon-sta-64', '2013-06-13'),
	('pay_189', '1', '2012-11-12'),
	('pay_193', '1', '2013-08-01');
/*!40000 ALTER TABLE `tbl_payroll` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_responsable_commande
CREATE TABLE IF NOT EXISTS `tbl_responsable_commande` (
  `nom_complet` varchar(30) NOT NULL,
  `ID_commande` int(10) NOT NULL,
  `Date_livraison` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_responsable_commande: ~0 rows (approximately)
/*!40000 ALTER TABLE `tbl_responsable_commande` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_responsable_commande` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_stock
CREATE TABLE IF NOT EXISTS `tbl_stock` (
  `code_stock` varchar(30) NOT NULL,
  `nom_fournisseur` varchar(20) DEFAULT NULL,
  `categorie` varchar(40) DEFAULT NULL,
  `article` varchar(40) DEFAULT NULL,
  `quantite` int(11) NOT NULL,
  `date_enregistrement` datetime DEFAULT NULL,
  PRIMARY KEY (`code_stock`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_stock: ~1 rows (approximately)
/*!40000 ALTER TABLE `tbl_stock` DISABLE KEYS */;
INSERT INTO `tbl_stock` (`code_stock`, `nom_fournisseur`, `categorie`, `article`, `quantite`, `date_enregistrement`) VALUES
	('Ach_St_64', 'canez', 'Electromenager', 'four', 72, '2013-06-01 02:49:14');
/*!40000 ALTER TABLE `tbl_stock` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_utilisateur
CREATE TABLE IF NOT EXISTS `tbl_utilisateur` (
  `code` varchar(20) NOT NULL,
  `nomutilisateur` varchar(10) NOT NULL,
  `motdepasse` varchar(20) NOT NULL,
  `statut` varchar(15) NOT NULL,
  `etat` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_utilisateur: ~0 rows (approximately)
/*!40000 ALTER TABLE `tbl_utilisateur` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_utilisateur` ENABLE KEYS */;


-- Dumping structure for table bd_bricolocal.tbl_vente
CREATE TABLE IF NOT EXISTS `tbl_vente` (
  `code_vente` varchar(30) NOT NULL,
  `nom_article` varchar(50) NOT NULL,
  `nom_categorie` varchar(50) NOT NULL,
  `prix_unitaire` mediumtext NOT NULL,
  `quantite_article` varchar(20) NOT NULL,
  `date_vente` datetime NOT NULL,
  PRIMARY KEY (`code_vente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table bd_bricolocal.tbl_vente: ~11 rows (approximately)
/*!40000 ALTER TABLE `tbl_vente` DISABLE KEYS */;
INSERT INTO `tbl_vente` (`code_vente`, `nom_article`, `nom_categorie`, `prix_unitaire`, `quantite_article`, `date_vente`) VALUES
	('BR-VENTE-1', 'laptop', 'Informatique', '500.0', '233', '2013-11-04 10:48:13'),
	('BR-VENTE-2', 'laptop', 'Informatique', '500.0', '33', '2013-11-04 11:19:43'),
	('eeeee', 'Item 1', 'Item 1', '2.0', '34', '2013-10-29 02:01:51'),
	('fff', 'Item 1', 'Item 1', '2.0', '55', '2013-10-28 06:33:17'),
	('sss', 'Item 1', 'Item 1', '2.0', '34', '2013-10-28 06:33:17'),
	('wa', 'Item 3', 'Item 2', '2.0', '44.0', '2013-10-26 07:43:06'),
	('wace', 'Item 1', 'Item 1', '2.0', '33.0', '2013-10-26 07:43:06'),
	('wace1', 'Item 2', 'Item 2', '33.5', '22.0', '2013-10-26 07:43:06'),
	('wacer', 'Item 2', 'Item 1', '3.0', '12.0', '2013-10-27 05:22:06'),
	('wacer1', 'Item 1', 'Item 1', '2.0', '33', '2013-10-27 05:33:10'),
	('waw', 'Item 4', 'Item 2', '2.0', '33.0', '2013-10-26 07:43:06');
/*!40000 ALTER TABLE `tbl_vente` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
