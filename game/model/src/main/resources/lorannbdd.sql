-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2016 at 10:37 PM
-- Server version: 5.7.9
-- PHP Version: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lorannbdd`
--

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `nb_map`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `nb_map` ()  BEGIN
    SELECT COUNT(*)
	AS nb
    FROM Level;
END$$

DROP PROCEDURE IF EXISTS `recup_map`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `recup_map` (`p_id` INT)  BEGIN
    SELECT *
    FROM Level
	WHERE id=p_id;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `level`
--

DROP TABLE IF EXISTS `level`;
CREATE TABLE IF NOT EXISTS `level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `map` varchar(10000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `level`
--

INSERT INTO `level` (`id`, `map`) VALUES
(1, '      *=*=========*\r\n   *==**|   9     **\r\n   = *+ |         C|\r\n*==*9   |    =     |\r\n|   *===*=====*    *\r\n|     T 93    F   4P\r\n===*    *=====*    |\r\n   |    |   9    T |\r\n   *==* |    F    **\r\n      *=*=========='),
(2, '  **===============*\r\n **            4   |\r\n**  *=======*9* *==*\r\n*   |   3     |  9 |\r\n|   | *=======*==* |\r\n|   |       G |    |\r\n|   *=======* | *==*\r\n|   |   F     | Z  |\r\n*   | *======**==* |\r\n|   |        |+    |\r\n*===*P=======*=====*'),
(3, ' *==*             \r\n **+*==*   *==*   \r\n  =    **  =  =   \r\n ****=*C=* =*3=   \r\n**  *   =* =* =*  \r\n *P  T** *==*  *=*\r\n  **   =4  *  G 9*\r\n   *T  *==*T ** 8*\r\n   **        *===*\r\n    *==**9TF*=\r\n       *=***=*\r\n'),
(4, '*==================*\r\n|+T           9    |\r\n*=*=========* *=*  |\r\n| |         T |    |\r\n| |FD 9     *=* *  |\r\n| *=========* C |  |\r\n| |  F G    *=* *  |\r\n| | 9       T | |  |\r\n*T*=========* *=*  |\r\nP             F   4|\r\n*==================*'),
(5, '  *==*===========*  \r\n **  *           ** \r\n**     *8*9*9*8*  **\r\n|  ***Z*=*=*=*=**  |\r\n|  *||         |   |\r\n|  W|*=* *===* |*  |\r\n|  +||4  *=*   |   |\r\n|   **   *=*  P|*  |\r\n|  *===T*======**  |\r\n**  *8*8*9*8*8** C**\r\n ** G 3 D        ** \r\n **=============**  '),
(6, '*==================*\r\n| T  +   Z    9    |\r\n*-*=========* *-*  |\r\n| |         T |    |\r\n| |FD 9     *-* *  |\r\n| *=========* C |  |\r\n| |  F D    *-* *  |\r\n| | 9       T | |  |\r\n*T*=========* *=*  |\r\nP      W      F   4|\r\n*==================*\r\n'),
(7, ' G*=*G\r\nG* Z *G\r\n*     *\r\n|W    |G                   ====\r\n*     *===============*G  *    ===\r\nG*                     *G|        ==\r\n G*=*+                 4P*====      =\r\nG*                     *G  == ===    *\r\n*     *===============*G     =   =   |\r\n|3    |G                      *   *\r\n*     *                        |   |\r\nG* C *G\r\n G*=*G');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
