-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: imd.cvjkd09vpeog.eu-west-3.rds.amazonaws.com    Database: imd-1
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
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
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividad` (
  `id_actividad` int NOT NULL AUTO_INCREMENT,
  `nombre_actividad` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `descripcion_actividad` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `categoria_actividad` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `precio_actividad` decimal(5,2) NOT NULL,
  PRIMARY KEY (`id_actividad`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre_actividad`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
INSERT INTO `actividad` VALUES (4,'Pádel','De 2 a 4 jugadores. A partir de 14 años.','Exterior',12.50),(5,'Bádminton','De 2 a 4 jugadores. A partir de 12 años.','Interior',15.80),(6,'Fútbol','De 8 a 16 jugadores. A partir de 8 años.','Exterior',5.80),(7,'Hockey','De 8 a 16 jugadores. A partir de 18 años.','Exterior',12.30),(8,'Baloncesto','De 4 a 8 jugadores. A partir de 8 años.','Interior',10.00),(9,'Tenis','De 2 a 4 jugadores. A partir de 12 años.','Exterior',13.10);
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actividad_tiene_entrenador`
--

DROP TABLE IF EXISTS `actividad_tiene_entrenador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividad_tiene_entrenador` (
  `id_actividad` int NOT NULL,
  `id_entrenador` int NOT NULL,
  PRIMARY KEY (`id_actividad`,`id_entrenador`),
  KEY `fk_actividad_copy1_has_entrenador_copy1_entrenador_copy11_idx` (`id_entrenador`),
  KEY `fk_actividad_copy1_has_entrenador_copy1_actividad_copy11_idx` (`id_actividad`),
  CONSTRAINT `fk_actividad_tiene_entrenador_actividad` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id_actividad`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_actividad_tiene_entrenador_entrenador` FOREIGN KEY (`id_entrenador`) REFERENCES `entrenador` (`id_entrenador`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad_tiene_entrenador`
--

LOCK TABLES `actividad_tiene_entrenador` WRITE;
/*!40000 ALTER TABLE `actividad_tiene_entrenador` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividad_tiene_entrenador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_sesion`
--

DROP TABLE IF EXISTS `datos_sesion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datos_sesion` (
  `id_usuario` int NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `contrasena` varchar(20) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  CONSTRAINT `fk_datos_sesion_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_sesion`
--

LOCK TABLES `datos_sesion` WRITE;
/*!40000 ALTER TABLE `datos_sesion` DISABLE KEYS */;
/*!40000 ALTER TABLE `datos_sesion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrenador`
--

DROP TABLE IF EXISTS `entrenador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrenador` (
  `id_entrenador` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_entrenador`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrenador`
--

LOCK TABLES `entrenador` WRITE;
/*!40000 ALTER TABLE `entrenador` DISABLE KEYS */;
/*!40000 ALTER TABLE `entrenador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago_usuario_paypal_actividad`
--

DROP TABLE IF EXISTS `pago_usuario_paypal_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago_usuario_paypal_actividad` (
  `id_pago_tarjeta` int NOT NULL AUTO_INCREMENT,
  `fecha_pago` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cantidad` decimal(3,2) NOT NULL,
  `id_usuario` int NOT NULL,
  `id_actividad` int NOT NULL,
  `id_paypal` int NOT NULL,
  PRIMARY KEY (`id_pago_tarjeta`),
  KEY `fk_pago_usuario_tarjeta_actividad_usuario1_idx` (`id_usuario`),
  KEY `fk_pago_usuario_tarjeta_actividad_actividad1_idx` (`id_actividad`),
  KEY `fk_pago_usuario_tarjeta_actividad_paypal_idx` (`id_paypal`),
  CONSTRAINT `fk_pago_usuario_paypa_actividad_actividad` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id_actividad`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_pago_usuario_paypa_actividad_paypal` FOREIGN KEY (`id_paypal`) REFERENCES `paypal` (`id_paypal`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_pago_usuario_paypal_actividad_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago_usuario_paypal_actividad`
--

LOCK TABLES `pago_usuario_paypal_actividad` WRITE;
/*!40000 ALTER TABLE `pago_usuario_paypal_actividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago_usuario_paypal_actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago_usuario_tarjeta_actividad`
--

DROP TABLE IF EXISTS `pago_usuario_tarjeta_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago_usuario_tarjeta_actividad` (
  `id_pago_tarjeta` int NOT NULL AUTO_INCREMENT,
  `fecha_pago` datetime NOT NULL,
  `cantidad` decimal(3,2) NOT NULL,
  `id_usuario` int NOT NULL,
  `id_actividad` int NOT NULL,
  `id_tarjeta` int NOT NULL,
  PRIMARY KEY (`id_pago_tarjeta`),
  KEY `fk_pago_usuario_tarjeta_actividad_usuario1_idx` (`id_usuario`),
  KEY `fk_pago_usuario_tarjeta_actividad_actividad1_idx` (`id_actividad`),
  KEY `fk_pago_usuario_tarjeta_actividad_tarjeta1_idx` (`id_tarjeta`),
  CONSTRAINT `fk_pago_usuario_tarjeta_actividad_actividad` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id_actividad`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_pago_usuario_tarjeta_actividad_tarjeta` FOREIGN KEY (`id_tarjeta`) REFERENCES `tarjeta` (`id_tarjeta`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_pago_usuario_tarjeta_actividad_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago_usuario_tarjeta_actividad`
--

LOCK TABLES `pago_usuario_tarjeta_actividad` WRITE;
/*!40000 ALTER TABLE `pago_usuario_tarjeta_actividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago_usuario_tarjeta_actividad` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `paypal`
--

DROP TABLE IF EXISTS `paypal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paypal` (
  `id_paypal` int NOT NULL AUTO_INCREMENT,
  `correo` varchar(45) NOT NULL,
  `usuario_id_usuario` int NOT NULL,
  PRIMARY KEY (`id_paypal`),
  KEY `fk_paypal_usuario1_idx` (`usuario_id_usuario`),
  CONSTRAINT `fk_paypal_usuario` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paypal`
--

LOCK TABLES `paypal` WRITE;
/*!40000 ALTER TABLE `paypal` DISABLE KEYS */;
/*!40000 ALTER TABLE `paypal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjeta`
--

DROP TABLE IF EXISTS `tarjeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarjeta` (
  `id_tarjeta` int NOT NULL AUTO_INCREMENT,
  `numero` varchar(24) NOT NULL,
  `cvv` varchar(3) NOT NULL,
  `caducidad` datetime NOT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id_tarjeta`),
  KEY `fk_tarjeta_usuario1_idx` (`id_usuario`),
  CONSTRAINT `fk_tarjeta_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjeta`
--

LOCK TABLES `tarjeta` WRITE;
/*!40000 ALTER TABLE `tarjeta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tarjeta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transferencia`
--

DROP TABLE IF EXISTS `transferencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transferencia` (
  `id_transferencia` int NOT NULL AUTO_INCREMENT,
  `iban` varchar(24) NOT NULL,
  `usuario_id_usuario` int NOT NULL,
  PRIMARY KEY (`id_transferencia`),
  KEY `fk_transferencia_dummy_usuario1_idx` (`usuario_id_usuario`),
  CONSTRAINT `fk_transferencia_usuario` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transferencia`
--

LOCK TABLES `transferencia` WRITE;
/*!40000 ALTER TABLE `transferencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `transferencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellido_a` varchar(20) NOT NULL,
  `apellido_b` varchar(20) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `id_usuario_UNIQUE` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'imd-1'
--
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-19  3:00:25
