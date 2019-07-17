<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Consulta Municipios  </title>
    </head>
    <body>
       <div class="container">
            <h2>Municipios</h2>
            <a class="btn btn-info" href="Controlador?accion=registrar">Agregar Nuevo</a>
            <br><br>
            
            <table class="table table-condensed">
                <thead>
                    <tr>
                        <th class="text-center">CODIGO</th>
                        <th class="text-center">NOMBRE</th>
                        <th class="text-center">OBSERVACION</th>
                        <th class="text-center">DEPARTAMENTO</th>
                        <th class="text-center">FECHA</th>
                        <th class="text-center">OPCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    
                     <c:forEach items="${lstMunicipios}" var="mncps">
                           <tr>
                              <td class="text-center">${mncps.codigo}</td>
                              <td class="text-center">${mncps.nombre}</td>
                              <td class="text-center">${mncps.observacion}</td>
                              <td class="text-center">${mncps.departamento}</td>
                              <td class="text-center">${mncps.fechacreacion}</td>
                              <td class="text-center">
                                  <a class="btn btn-warning" href="Controlador?accion=editar&idMncp=${mncps.idMunicipio}">Editar</a>
                                  <a class="btn btn-danger" href="Controlador?accion=eliminar&idMncp=${mncps.idMunicipio}">Eliminar</a>
                              </td>
                          </tr>
                        </c:forEach>
                </tbody>                
            </table>
            
            
       </div>
        
        
        
        
        
    </body>
</html>
