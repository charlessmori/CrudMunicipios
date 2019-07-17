 
package pojos;
 
import java.util.Date;

public class Departamento {
   private int idDepartamento;
   private String codigo;
   private String nombre;
   private String observaciones;
   private int estado;
   private Date fechacreacion;

   public Departamento(int idDepartamento, String codigo, String nombre, String observaciones){
       this.idDepartamento = idDepartamento;
       this.codigo = codigo;
       this.nombre = nombre;
       this.observaciones= observaciones;  
   }
   public Departamento(){
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
}
