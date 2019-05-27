-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 27 mai 2019 à 11:57
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projetjava`
--

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `GetLevel`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetLevel` (IN `p_Level_id` INT)  BEGIN
	SELECT *
    FROM integrate
    WHERE integrate.Id = p_Level_id;
END$$

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
