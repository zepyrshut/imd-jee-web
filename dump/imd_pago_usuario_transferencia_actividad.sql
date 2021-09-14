-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: imd.cvjkd09vpeog.eu-west-3.rds.amazonaws.com    Database: imd
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `pago_usuario_transferencia_actividad`
--

DROP TABLE IF EXISTS `pago_usuario_transferencia_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago_usuario_transferencia_actividad` (
  `id_pago_tarjeta` int NOT NULL AUTO_INCREMENT,
  `fecha_pago` datetime NOT NULL,
  `cantidad` decimal(3,2) NOT NULL,
  `id_usuario` int NOT NULL,
  `id_actividad` int NOT NULL,
  `id_trasnferencia` int NOT NULL,
  PRIMARY KEY (`id_pago_tarjeta`),
  KEY `fk_pago_usuario_tarjeta_actividad_usuario1_idx` (`id_usuario`),
  KEY `fk_pago_usuario_tarjeta_actividad_actividad1_idx` (`id_actividad`),
  KEY `fk_pago_usuario_tarjeta_actividad_transferencia_idx` (`id_trasnferencia`),
  CONSTRAINT `fk_pago_usuario_transferencia_actividad_actividad` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id_actividad`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_pago_usuario_transferencia_actividad_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_pago_usuariotransferencia_actividad_transferencia` FOREIGN KEY (`id_trasnferencia`) REFERENCES `transferencia` (`id_transferencia`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago_usuario_transferencia_actividad`
--

LOCK TABLES `pago_usuario_transferencia_actividad` WRITE;
/*!40000 ALTER TABLE `pago_usuario_transferencia_actividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago_usuario_transferencia_actividad` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-15  1:16:50
