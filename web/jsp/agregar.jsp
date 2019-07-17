<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Nuevo Municipio</title>
    </head>
    <body>

        <div class="container">
            <div class="col-lg-6">
                <h2>Datos Nuevo Municipio</h2>
                <form action="Controlador">

                    Departamento:
                    <select name="somDeptos">
                        <c:forEach items="${lstDepartamentos}" var="somDeptos">
                            <option value="${somDeptos.idDepartamento}">
                                ${somDeptos.nombre}
                            </option>
                        </c:forEach>
                    </select>
                    <br>
                    <br>

                    Codigo<br>
                    <input class="form-control" type="text" name="txtMncp_Codigo"><br>
                    Nombre: <br>
                    <input class="form-control" type="text" name="txtMncp_Nombre"><br>
                    Observacion:<br>
                    <textarea class="form-control" type="text" name="txtMncp_Observacion"></textarea><br>                    


                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a class="btn btn-danger" href="Controlador?accion=listar">Cancelar</a>

                </form>
            </div>
        </div>



    </body>
</html>
