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
(1, 1, 25),
(2, 1, 32),
(2, 1, 39),
(2, 1, 44),
(2, 1, 45),
(2, 1, 47),
(2, 1, 55),
(2, 1, 59),
(2, 1, 62),
(2, 1, 65),
(2, 1, 69),
(2, 1, 73),
(2, 1, 81),
(2, 1, 85),
(2, 1, 92),
(2, 1, 94),
(2, 1, 99),
(2, 1, 102),
(2, 1, 105),
(2, 1, 109),
(2, 1, 113),
(2, 1, 115),
(2, 1, 121),
(2, 1, 125),
(2, 2, 27),
(2, 2, 28),
(2, 2, 29),
(2, 2, 30),
(2, 2, 31),
(2, 2, 33),
(2, 2, 36),
(2, 2, 37),
(2, 2, 38),
(2, 2, 40),
(2, 2, 43),
(2, 2, 46),
(2, 2, 49),
(2, 2, 50),
(2, 2, 53),
(2, 2, 54),
(2, 2, 56),
(2, 2, 57),
(2, 2, 60),
(2, 2, 61),
(2, 2, 63),
(2, 2, 68),
(2, 2, 72),
(2, 2, 74),
(2, 2, 77),
(2, 2, 78),
(2, 2, 79),
(2, 2, 80),
(2, 2, 83),
(2, 2, 84),
(2, 2, 88),
(2, 2, 89),
(2, 2, 91),
(2, 2, 95),
(2, 2, 96),
(2, 2, 97),
(2, 2, 100),
(2, 2, 101),
(2, 2, 103),
(2, 2, 106),
(2, 2, 107),
(2, 2, 108),
(2, 2, 111),
(2, 2, 117),
(2, 2, 118),
(2, 2, 119),
(2, 2, 120),
(2, 2, 123),
(2, 2, 124),
(2, 3, 34),
(2, 3, 41),
(2, 3, 42),
(2, 3, 48),
(2, 3, 51),
(2, 3, 52),
(2, 3, 58),
(2, 3, 64),
(2, 3, 66),
(2, 3, 67),
(2, 3, 71),
(2, 3, 76),
(2, 3, 87),
(2, 3, 90),
(2, 3, 93),
(2, 3, 98),
(2, 3, 104),
(2, 3, 110),
(2, 3, 112),
(2, 3, 116),
(2, 5, 35),
(2, 5, 70),
(2, 5, 75),
(2, 5, 82),
(2, 5, 86),
(2, 5, 114),
(2, 5, 122),
(2, 6, 26);

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
(25, 64, 64),
(26, 0, 0),
(27, 16, 0),
(28, 32, 0),
(29, 48, 0),
(30, 64, 0),
(31, 80, 0),
(32, 96, 0),
(33, 112, 0),
(34, 128, 0),
(35, 144, 0),
(36, 0, 16),
(37, 16, 16),
(38, 32, 16),
(39, 48, 16),
(40, 64, 16),
(41, 80, 16),
(42, 96, 16),
(43, 112, 16),
(44, 128, 16),
(45, 144, 16),
(46, 0, 32),
(47, 16, 32),
(48, 32, 32),
(49, 48, 32),
(50, 64, 32),
(51, 80, 32),
(52, 96, 32),
(53, 112, 32),
(54, 128, 32),
(55, 144, 32),
(56, 0, 48),
(57, 16, 48),
(58, 32, 48),
(59, 48, 48),
(60, 64, 48),
(61, 80, 48),
(62, 96, 48),
(63, 112, 48),
(64, 128, 48),
(65, 144, 48),
(66, 0, 64),
(67, 16, 64),
(68, 32, 64),
(69, 48, 64),
(70, 64, 64),
(71, 80, 64),
(72, 96, 64),
(73, 112, 64),
(74, 128, 64),
(75, 144, 64),
(76, 0, 80),
(77, 16, 80),
(78, 32, 80),
(79, 48, 80),
(80, 64, 80),
(81, 80, 80),
(82, 96, 80),
(83, 112, 80),
(84, 128, 80),
(85, 144, 80),
(86, 0, 96),
(87, 16, 96),
(88, 32, 96),
(89, 48, 96),
(90, 64, 96),
(91, 80, 96),
(92, 96, 96),
(93, 112, 96),
(94, 128, 96),
(95, 144, 96),
(96, 0, 112),
(97, 16, 112),
(98, 32, 112),
(99, 48, 112),
(100, 64, 112),
(101, 80, 112),
(102, 96, 112),
(103, 112, 112),
(104, 128, 112),
(105, 144, 112),
(106, 0, 128),
(107, 16, 128),
(108, 32, 128),
(109, 48, 128),
(110, 64, 128),
(111, 80, 128),
(112, 96, 128),
(113, 112, 128),
(114, 128, 128),
(115, 144, 128),
(116, 0, 144),
(117, 16, 144),
(118, 32, 144),
(119, 48, 144),
(120, 64, 144),
(121, 80, 144),
(122, 96, 144),
(123, 112, 144),
(124, 128, 144),
(125, 144, 144);

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
