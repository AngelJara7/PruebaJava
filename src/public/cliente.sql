/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8mb3_unicode_ci NOT NULL,
  `apellido` varchar(30) COLLATE utf8mb3_unicode_ci NOT NULL,
  `cedula` varchar(10) COLLATE utf8mb3_unicode_ci NOT NULL,
  `email` varchar(32) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `cedula` (`cedula`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

INSERT INTO `cliente` (`id_cliente`, `nombre`, `apellido`, `cedula`, `email`) VALUES
(1, 'Angel A.', 'Jaramillo', '1-334-5543', 'angel@outlook.com');
INSERT INTO `cliente` (`id_cliente`, `nombre`, `apellido`, `cedula`, `email`) VALUES
(4, 'Manuel', 'Gonzalez', '1-234-5678', 'manuel@gmail.com');
INSERT INTO `cliente` (`id_cliente`, `nombre`, `apellido`, `cedula`, `email`) VALUES
(10, 'Javier', 'Ramirez', '1-444-2321', 'javi@correo.com');
INSERT INTO `cliente` (`id_cliente`, `nombre`, `apellido`, `cedula`, `email`) VALUES
(11, 'María', 'Martinez', '1-432-4442', 'mariam@gmail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;