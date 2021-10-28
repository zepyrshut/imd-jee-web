-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: imds
-- ------------------------------------------------------
-- Server version	8.0.26

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
INSERT INTO `actividad` VALUES (4,'Pádel','De 2 a 4 jugadores. A partir de 14 años.','Exterior',12.50),(5,'Bádminton','De 2 a 4 jugadores. A partir de 12 años.','Interior',15.80),(6,'Fútbol','De 8 a 16 jugadores. A partir de 8 años.','Exterior',5.80),(7,'Hockey','De 8 a 16 jugadores. A partir de 18 años.','Exterior',12.30),(8,'Baloncesto','De 4 a 8 jugadores. A partir de 8 años.','Interior',10.00),(9,'Tenis','De 2 a 4 jugadores. A partir de 12 años.','Exterior',13.10),(10,'Balonmano','De 6 a 12 jugadores. A partir de 8 años.','Interior',10.00);
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_sesion`
--

DROP TABLE IF EXISTS `datos_sesion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datos_sesion` (
  `id_datos_sesion` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(20) DEFAULT NULL,
  `contrasena` varchar(50) DEFAULT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id_datos_sesion`),
  UNIQUE KEY `datos_sesion_UN` (`usuario`),
  KEY `datos_sesion_FK` (`id_usuario`),
  CONSTRAINT `datos_sesion_FK` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_datos_sesion_id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_sesion`
--

LOCK TABLES `datos_sesion` WRITE;
/*!40000 ALTER TABLE `datos_sesion` DISABLE KEYS */;
INSERT INTO `datos_sesion` VALUES (18,'jorgehurtadodmx','123',31),(19,'user32','user32',32),(20,'jorgehurtadonick','123',33),(21,'pedrillo','1234',34),(22,'nators','655943460',36),(23,'qwe','456',37),(24,'uwu','963',38);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrenador`
--

LOCK TABLES `entrenador` WRITE;
/*!40000 ALTER TABLE `entrenador` DISABLE KEYS */;
INSERT INTO `entrenador` VALUES (4,'Iñigo','Fuentes'),(5,'Emiliano','Reina'),(6,'Octavio','Guillén'),(7,'Jaime','Pascual'),(8,'Lucía','Celeste');
/*!40000 ALTER TABLE `entrenador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrenador_tiene_actividad`
--

DROP TABLE IF EXISTS `entrenador_tiene_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrenador_tiene_actividad` (
  `id_entrenador` int NOT NULL,
  `id_actividad` int NOT NULL,
  PRIMARY KEY (`id_entrenador`,`id_actividad`),
  KEY `fk_entrenador_has_actividad_actividad1_idx` (`id_actividad`),
  KEY `fk_entrenador_has_actividad_entrenador1_idx` (`id_entrenador`),
  CONSTRAINT `fk_entrenador_has_actividad_actividad1` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id_actividad`),
  CONSTRAINT `fk_entrenador_has_actividad_entrenador1` FOREIGN KEY (`id_entrenador`) REFERENCES `entrenador` (`id_entrenador`),
  CONSTRAINT `FK_entrenador_tiene_actividad_id_actividad` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id_actividad`),
  CONSTRAINT `FK_entrenador_tiene_actividad_id_entrenador` FOREIGN KEY (`id_entrenador`) REFERENCES `entrenador` (`id_entrenador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrenador_tiene_actividad`
--

LOCK TABLES `entrenador_tiene_actividad` WRITE;
/*!40000 ALTER TABLE `entrenador_tiene_actividad` DISABLE KEYS */;
INSERT INTO `entrenador_tiene_actividad` VALUES (4,4),(5,4),(5,5),(6,6),(7,7),(8,8),(7,9);
/*!40000 ALTER TABLE `entrenador_tiene_actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metodo_pago`
--

DROP TABLE IF EXISTS `metodo_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `metodo_pago` (
  `id_pago` int NOT NULL AUTO_INCREMENT,
  `DTYPE` varchar(31) DEFAULT NULL,
  `nombre_pago` varchar(255) DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_pago`),
  KEY `FK_metodo_pago_id_usuario` (`id_usuario`),
  CONSTRAINT `FK_metodo_pago_id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metodo_pago`
--

LOCK TABLES `metodo_pago` WRITE;
/*!40000 ALTER TABLE `metodo_pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `metodo_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago_usuario_paypal_actividad`
--

DROP TABLE IF EXISTS `pago_usuario_paypal_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago_usuario_paypal_actividad` (
  `id_usuario` int NOT NULL,
  `id_actividad` int NOT NULL,
  `id_paypal` int NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_actividad`,`id_paypal`),
  KEY `fk_pago_usuario_tarjeta_actividad_usuario1_idx` (`id_usuario`),
  KEY `fk_pago_usuario_tarjeta_actividad_actividad1_idx` (`id_actividad`),
  KEY `fk_pago_usuario_tarjeta_actividad_paypal_idx` (`id_paypal`),
  CONSTRAINT `fk_pago_usuario_paypa_actividad_actividad` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id_actividad`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_pago_usuario_paypa_actividad_paypal` FOREIGN KEY (`id_paypal`) REFERENCES `paypal` (`id_paypal`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_pago_usuario_paypal_actividad_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago_usuario_paypal_actividad`
--

LOCK TABLES `pago_usuario_paypal_actividad` WRITE;
/*!40000 ALTER TABLE `pago_usuario_paypal_actividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago_usuario_paypal_actividad` ENABLE KEYS */;
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
  `id_pago` int NOT NULL,
  PRIMARY KEY (`id_paypal`),
  KEY `fk_paypal_usuario1_idx` (`usuario_id_usuario`),
  CONSTRAINT `fk_paypal_usuario` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paypal`
--

LOCK TABLES `paypal` WRITE;
/*!40000 ALTER TABLE `paypal` DISABLE KEYS */;
INSERT INTO `paypal` VALUES (4,'jorgepaypal@gmail.com',31,0),(5,'jorgepaypal2@gmail.com',31,0);
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
  `id_pago` int NOT NULL,
  PRIMARY KEY (`id_tarjeta`),
  KEY `fk_tarjeta_usuario1_idx` (`id_usuario`),
  CONSTRAINT `fk_tarjeta_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjeta`
--

LOCK TABLES `tarjeta` WRITE;
/*!40000 ALTER TABLE `tarjeta` DISABLE KEYS */;
INSERT INTO `tarjeta` VALUES (2,'12312','123','9999-12-31 23:59:59',31,0);
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
  `id_pago` int NOT NULL,
  PRIMARY KEY (`id_transferencia`),
  KEY `fk_transferencia_dummy_usuario1_idx` (`usuario_id_usuario`),
  CONSTRAINT `fk_transferencia_usuario` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transferencia`
--

LOCK TABLES `transferencia` WRITE;
/*!40000 ALTER TABLE `transferencia` DISABLE KEYS */;
INSERT INTO `transferencia` VALUES (2,'12983818',31,0);
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
  `nombre` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `apellido_a` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `apellido_b` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `telefono` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `id_usuario_UNIQUE` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (31,'jorge','hurtadomod','moxo','62538333332','jorgehurtadodmx@gmail.com'),(32,'user32','32','3232','32323','user32@gmail.com'),(33,'jorgehurtadonombre','apellido','segundoape','6234','jorgehurtadomail@gma'),(34,'pedro','perez','','','pedro\"'),(35,'testuser','aaa','aaa','aaa','aaa@aaa'),(36,'Antonio Rubén','Beltran','Rodriguez','685416128','ernators@gmail.com'),(37,'antonio ruben','beltran','r','521','12312321321'),(38,'Antonio RubÃ©n','beltran','rodriguez','1qasdas','asdasd');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_tiene_actividad`
--

DROP TABLE IF EXISTS `usuario_tiene_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_tiene_actividad` (
  `id_actividad` int NOT NULL,
  `id_usuario` int NOT NULL,
  `id_paypal` int DEFAULT NULL,
  `id_pago` int NOT NULL,
  `id_user_actividad` bigint NOT NULL,
  PRIMARY KEY (`id_actividad`,`id_usuario`),
  KEY `FKUsuarioPago_idx` (`id_usuario`),
  KEY `FKPaypalPago_idx` (`id_paypal`),
  CONSTRAINT `FK_usuario_tiene_actividad_id_actividad` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id_actividad`),
  CONSTRAINT `FK_usuario_tiene_actividad_id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FKActividadPago` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id_actividad`),
  CONSTRAINT `FKPaypalPago` FOREIGN KEY (`id_paypal`) REFERENCES `paypal` (`id_paypal`),
  CONSTRAINT `FKUsuarioPago` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_tiene_actividad`
--

LOCK TABLES `usuario_tiene_actividad` WRITE;
/*!40000 ALTER TABLE `usuario_tiene_actividad` DISABLE KEYS */;
INSERT INTO `usuario_tiene_actividad` VALUES (6,31,4,0,0),(7,31,5,0,0),(9,31,4,0,0);
/*!40000 ALTER TABLE `usuario_tiene_actividad` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-28 13:36:42
