package pojos;

import java.util.Date;

public class Municipio {

    private int idMunicipio;
    private int idDepartamento;
    private String codigo;
    private String nombre;
    private String observacion;
    private int estado;
    private Date fechacreacion;
    private String departamento;

    public Municipio(int idDepartamento, String codigo, String nombre, String observacion) {
        this.idDepartamento = idDepartamento;
        this.codigo = codigo;
        this.nombre = nombre;
        this.observacion = observacion;
    }

    public Municipio(int idMunicipio, int idDepartamento, String codigo, String nombre, String observacion, int estado, Date fechacreacion) {
        this.idMunicipio = idMunicipio;
        this.idDepartamento = idDepartamento;
        this.codigo = codigo;
        this.nombre = nombre;
        this.observacion = observacion;
        this.estado = estado;
        this.fechacreacion = fechacreacion;
    }

    public Municipio() {
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
}
