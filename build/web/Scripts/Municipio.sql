CREATE TABLE `municipio` (
  `idMunicipio` int(11) NOT NULL AUTO_INCREMENT,
  `idDepartamento` int(11) NOT NULL,
  `codigo` varchar(10) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `observacion` varchar(100) DEFAULT NULL,
  `estado` int(11) DEFAULT '1',
  `fechacreacion` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idMunicipio`),
  KEY `idDepartamento_idx` (`idDepartamento`),
  CONSTRAINT `idDepartamento` FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`idDepartamento`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='catalogo de municipios';
