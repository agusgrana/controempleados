/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package registrocontrol.clases;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

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
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
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
        Integer oldIdHistoriaLaboral = this.idHistoriaLaboral;
        this.idHistoriaLaboral = idHistoriaLaboral;
        changeSupport.firePropertyChange("idHistoriaLaboral", oldIdHistoriaLaboral, idHistoriaLaboral);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        String oldCargo = this.cargo;
        this.cargo = cargo;
        changeSupport.firePropertyChange("cargo", oldCargo, cargo);
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        Date oldFechaInicio = this.fechaInicio;
        this.fechaInicio = fechaInicio;
        changeSupport.firePropertyChange("fechaInicio", oldFechaInicio, fechaInicio);
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        Date oldFechaSalida = this.fechaSalida;
        this.fechaSalida = fechaSalida;
        changeSupport.firePropertyChange("fechaSalida", oldFechaSalida, fechaSalida);
    }

    public int getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(int salarioBase) {
        int oldSalarioBase = this.salarioBase;
        this.salarioBase = salarioBase;
        changeSupport.firePropertyChange("salarioBase", oldSalarioBase, salarioBase);
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        Empleado oldEmpleado = this.empleado;
        this.empleado = empleado;
        changeSupport.firePropertyChange("empleado", oldEmpleado, empleado);
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
