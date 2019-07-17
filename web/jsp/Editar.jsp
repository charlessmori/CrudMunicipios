<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Actualizacion</title>
    </head>
    <body>
        
        <div class="container">
            <div class="col-lg-6">


                <h2>Datos Municipio</h2>
                <form action="Controlador">
                                        
                    Departamento:
                    <select name="somDeptos">
                        <c:forEach items="${lstDepartamentos}" var="somDeptos">
                            <option value="${somDeptos.idDepartamento}" ${somDeptos.idDepartamento == municipio.idDepartamento ? 'selected="selected"' : ''}>
                                ${somDeptos.nombre}
                            </option>
                        </c:forEach>
                    </select>
                    <br>
                    <br>

                    Codigo<br>
                    <input class="form-control" type="text" name="txtMncp_Codigo" value="${municipio.codigo}"><br>
                    Nombre: <br>
                    <input class="form-control" type="text" name="txtMncp_Nombre" value="${municipio.nombre}"><br>
                    Observacion:<br>
                    <input class="form-control" type="text" name="txtMncp_Observacion" value="${municipio.observacion}"></input><br> 

                    <input type="hidden" name="txtMncp_IdMunicipio" value="${municipio.idMunicipio}"  >
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                    <a class="btn btn-danger" href="Controlador?accion=listar">Cancelar</a>

                </form>

            </div>
        </div>
        
         
    </body>
</html>
