/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pojos.Departamento;

public class DaoDepartamento {
    Conexion conexionMySQl = null;
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    

    public List<Departamento> obtenerDepartamentos() {
        List<Departamento> dpts = new ArrayList<>();

        try {
            conexionMySQl = new Conexion();
            cn = conexionMySQl.getConnection();
                       
            ps = cn.prepareStatement("select * from departamento ");
            rs = ps.executeQuery();
            while(rs.next()){
                Departamento dpto = new Departamento();
                dpto.setIdDepartamento(rs.getInt("iddepartamento"));
                dpto.setCodigo(rs.getString("codigo"));
                dpto.setNombre(rs.getString("nombre"));
                dpto.setObservaciones(rs.getString("observacion"));
                dpto.setEstado(rs.getInt("estado"));
                dpto.setFechacreacion(rs.getTimestamp("fechacreacion"));               
 
                dpts.add(dpto);
            }
           
            cn.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return dpts;

    }

}
