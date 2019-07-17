CREATE TABLE `departamento` (
  `idDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(10) DEFAULT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Observacion` varchar(100) DEFAULT NULL,
  `Estado` int(11) DEFAULT '1',
  `fechacreacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Registro de Departamentos';
