-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 28 mai 2019 à 09:12
-- Version du serveur :  5.7.23
-- Version de PHP :  7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `jpublankproject`
--

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `GetLevel`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetLevel` (IN `p_Level_id` INT)  BEGIN
	SELECT components.Name, positions.PosX, positions.PosY
    FROM integrate
    INNER JOIN components ON components.Id = integrate.Id_Components
    INNER JOIN positions ON positions.Id = integrate.Id_Position
    WHERE integrate.Id = p_Level_id;
END$$

DROP PROCEDURE IF EXISTS `GetWidth`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetWidth` (IN `name` VARCHAR(255))  NO SQL
SELECT Height, Width
FROM level
WHERE `Name` = name$$

DROP PROCEDURE IF EXISTS `HelloworldByCode`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `HelloworldByCode` (IN `p_code` VARCHAR(2))  READS SQL DATA
    SQL SECURITY INVOKER
SELECT * FROM jpublankproject.helloworld where `code`=p_code$$

DROP PROCEDURE IF EXISTS `helloworldById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `helloworldById` (IN `p_id` INT)  READS SQL DATA
    SQL SECURITY INVOKER
SELECT * FROM helloworld WHERE id = p_id$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `components`
--

DROP TABLE IF EXISTS `components`;
CREATE TABLE IF NOT EXISTS `components` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `components`
--

INSERT INTO `components` (`Id`, `Name`) VALUES
(1, 'Diamond');

-- --------------------------------------------------------

--
-- Structure de la table `helloworld`
--

DROP TABLE IF EXISTS `helloworld`;
CREATE TABLE IF NOT EXISTS `helloworld` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(2) NOT NULL,
  `message` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `helloworld`
--

INSERT INTO `helloworld` (`id`, `code`, `message`) VALUES
(1, 'GB', 'Hello world'),
(2, 'FR', 'Bonjour le monde'),
(3, 'DE', 'Hallo Welt'),
(4, 'ID', 'Salamat pagi dunia');

-- --------------------------------------------------------

--
-- Structure de la table `integrate`
--

DROP TABLE IF EXISTS `integrate`;
CREATE TABLE IF NOT EXISTS `integrate` (
  `Id` int(11) NOT NULL,
  `Id_Components` int(11) NOT NULL,
  `Id_Position` int(11) NOT NULL,
  PRIMARY KEY (`Id`,`Id_Components`,`Id_Position`),
  KEY `Integrate_Components0_FK` (`Id_Components`),
  KEY `Integrate_Position1_FK` (`Id_Position`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `integrate`
--

INSERT INTO `integrate` (`Id`, `Id_Components`, `Id_Position`) VALUES
(1, 1, 1),
(1, 1, 2),
(1, 1, 3),
(1, 1, 4),
(1, 1, 5),
(1, 1, 6),
(1, 1, 7),
(1, 1, 8),
(1, 1, 9),
(1, 1, 10),
(1, 1, 11),
(1, 1, 12),
(1, 1, 13),
(1, 1, 14),
(1, 1, 15),
(1, 1, 16),
(1, 1, 17),
(1, 1, 18),
(1, 1, 19),
(1, 1, 20),
(1, 1, 21),
(1, 1, 22),
(1, 1, 23),
(1, 1, 24),
(1, 1, 25);

-- --------------------------------------------------------

--
-- Structure de la table `level`
--

DROP TABLE IF EXISTS `level`;
CREATE TABLE IF NOT EXISTS `level` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Height` int(11) NOT NULL,
  `Width` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `level`
--

INSERT INTO `level` (`Id`, `Name`, `Height`, `Width`) VALUES
(1, 'Niveau_1', 5, 5);

-- --------------------------------------------------------

--
-- Structure de la table `positions`
--

DROP TABLE IF EXISTS `positions`;
CREATE TABLE IF NOT EXISTS `positions` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PosX` int(11) NOT NULL,
  `PosY` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `positions`
--

INSERT INTO `positions` (`Id`, `PosX`, `PosY`) VALUES
(1, 0, 0),
(2, 16, 0),
(3, 32, 0),
(4, 48, 0),
(5, 64, 0),
(6, 0, 16),
(7, 16, 16),
(8, 32, 16),
(9, 48, 16),
(10, 64, 16),
(11, 0, 32),
(12, 16, 32),
(13, 32, 32),
(14, 48, 32),
(15, 64, 32),
(16, 0, 48),
(17, 16, 48),
(18, 32, 48),
(19, 48, 48),
(20, 64, 48),
(21, 0, 64),
(22, 16, 64),
(23, 32, 64),
(24, 48, 64),
(25, 64, 64);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `integrate`
--
ALTER TABLE `integrate`
  ADD CONSTRAINT `Integrate_Components0_FK` FOREIGN KEY (`Id_Components`) REFERENCES `components` (`Id`),
  ADD CONSTRAINT `Integrate_Level_FK` FOREIGN KEY (`Id`) REFERENCES `level` (`Id`),
  ADD CONSTRAINT `Integrate_Position1_FK` FOREIGN KEY (`Id_Position`) REFERENCES `positions` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
