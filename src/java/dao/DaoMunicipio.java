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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojos.Municipio;

public class DaoMunicipio {

    Conexion conexionMySQl = null;
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public void borrarMunicipio(int IdMunicipio) {
        try {
            String query = "delete from Municipio where idmunicipio = @idmunicipio ";

            query = query.replace("@idmunicipio", String.valueOf(IdMunicipio));

            conexionMySQl = new Conexion();
            cn = conexionMySQl.getConnection();
            ps = cn.prepareStatement(query);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void actualizarMunicipio(Municipio mncp){
        try {
            String query = 
             "update Municipio "
                 + " set codigo = '@codigo', nombre='@nombre', "
                 + "observacion='@observacion', iddepartamento = '@iddepartamento', "
                 + "fechacreacion=current_timestamp "
                 + "where idmunicipio = @idmunicipio " ;
            
            query = query.replace("@codigo", mncp.getCodigo())
                    .replace("@nombre", mncp.getNombre())
                    .replace("@observacion", mncp.getObservacion())
                    .replace("@idmunicipio", String.valueOf(mncp.getIdMunicipio()))
                    .replace("@iddepartamento", String.valueOf(mncp.getIdDepartamento()));                   
                    
            conexionMySQl = new Conexion();
            cn=conexionMySQl.getConnection();
            ps=cn.prepareStatement(query);
            ps.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
    public Municipio obtenerMunicipio(int idMunicipio){
        Municipio mncp = null;
         
        try {
            conexionMySQl = new Conexion();
            cn = conexionMySQl.getConnection();
                       
            ps = cn.prepareStatement("select * from Municipio where idMunicipio = " + idMunicipio);
            rs = ps.executeQuery();
            while(rs.next()){
                mncp = new Municipio( 
                rs.getInt("idmunicipio"),
                rs.getInt("iddepartamento"),
                rs.getString("codigo"),
                rs.getString("nombre"),
                rs.getString("observacion"),
                rs.getInt("estado"),
                rs.getTimestamp("fechacreacion"));                
            }           
            cn.close();            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }     
        return mncp;
    }
    
    public List<Municipio> obtenerMunicipios(){
        List<Municipio> mncps = new ArrayList<>();
        
        try {
            conexionMySQl = new Conexion();
            cn = conexionMySQl.getConnection();
                       
            String querySelect = 
                "select idmunicipio, m.iddepartamento,codigo, nombre, observacion, estado, fechacreacion,"
                + " (select d.nombre from departamento d where d.iddepartamento = m.iddepartamento ) departamento "
                + "from Municipio m " ;
            
            ps = cn.prepareStatement(querySelect);
            rs = ps.executeQuery();
            while(rs.next()){
                Municipio mncp = new Municipio();
                mncp.setIdMunicipio(rs.getInt("idmunicipio"));
                mncp.setIdDepartamento(rs.getInt("iddepartamento"));
                mncp.setCodigo(rs.getString("codigo"));
                mncp.setNombre(rs.getString("nombre"));
                mncp.setObservacion(rs.getString("observacion"));
                mncp.setEstado(rs.getInt("estado"));
                mncp.setFechacreacion(rs.getTimestamp("fechacreacion")); 
                mncp.setDepartamento(rs.getString("departamento"));
                mncps.add(mncp);
            }
           
            cn.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        return mncps;
    }
    
    public void registrarMunicipio(Municipio m){
    
        try {
            String query = 
             "insert into Municipio(iddepartamento, codigo, nombre, observacion)  "+
             " values "+
             "('" + m.getIdDepartamento() +"', '" + m.getCodigo() + "', '"+m.getNombre()+"', '" +m.getObservacion()+"') ";
            
            conexionMySQl = new Conexion();
            cn=conexionMySQl.getConnection();
            ps=cn.prepareStatement(query);
            ps.executeUpdate();
            
            ps.close();
            cn.close();
            
        } catch (Exception e) {
        }
        
        
    
    }
    
    

}
