/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package registrocontrol.clases;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gurzaf
 */
@Entity
@Table(name = "historialaboral")
@NamedQueries({
    @NamedQuery(name = "Historialaboral.findAll", query = "SELECT h FROM Historialaboral h"),
    @NamedQuery(name = "Historialaboral.findByIdHistoriaLaboral", query = "SELECT h FROM Historialaboral h WHERE h.idHistoriaLaboral = :idHistoriaLaboral"),
    @NamedQuery(name = "Historialaboral.findByCargo", query = "SELECT h FROM Historialaboral h WHERE h.cargo = :cargo"),
    @NamedQuery(name = "Historialaboral.findByFechaInicio", query = "SELECT h FROM Historialaboral h WHERE h.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Historialaboral.findByFechaSalida", query = "SELECT h FROM Historialaboral h WHERE h.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "Historialaboral.findByIdEmpleado", query = "SELECT h FROM Historialaboral h JOIN h.empleado e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Historialaboral.findBySalarioBase", query = "SELECT h FROM Historialaboral h WHERE h.salarioBase = :salarioBase")})
public class Historialaboral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHistoriaLaboral")
    private Integer idHistoriaLaboral;
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fechaSalida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Basic(optional = false)
    @Column(name = "salarioBase")
    private int salarioBase;
    @JoinColumn(name = "empleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private Empleado empleado;

    public Historialaboral() {
    }

    public Historialaboral(Integer idHistoriaLaboral) {
        this.idHistoriaLaboral = idHistoriaLaboral;
    }

    public Historialaboral(Integer idHistoriaLaboral, String cargo, Date fechaInicio, int salarioBase) {
        this.idHistoriaLaboral = idHistoriaLaboral;
        this.cargo = cargo;
        this.fechaInicio = fechaInicio;
        this.salarioBase = salarioBase;
    }

    public Integer getIdHistoriaLaboral() {
        return idHistoriaLaboral;
    }

    public void setIdHistoriaLaboral(Integer idHistoriaLaboral) {
        this.idHistoriaLaboral = idHistoriaLaboral;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistoriaLaboral != null ? idHistoriaLaboral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historialaboral)) {
            return false;
        }
        Historialaboral other = (Historialaboral) object;
        if ((this.idHistoriaLaboral == null && other.idHistoriaLaboral != null) || (this.idHistoriaLaboral != null && !this.idHistoriaLaboral.equals(other.idHistoriaLaboral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Historialaboral[idHistoriaLaboral=" + idHistoriaLaboral + "]";
    }

}
