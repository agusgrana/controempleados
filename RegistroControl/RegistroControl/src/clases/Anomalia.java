/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

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
 * @author GeRmAn
 */
@Entity
@Table(name = "anomalia")
@NamedQueries({
    @NamedQuery(name = "Anomalia.findAll", query = "SELECT a FROM Anomalia a"),
    @NamedQuery(name = "Anomalia.findByIdAnomalia", query = "SELECT a FROM Anomalia a WHERE a.idAnomalia = :idAnomalia"),
    @NamedQuery(name = "Anomalia.findByFecha", query = "SELECT a FROM Anomalia a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Anomalia.findByDescripcion", query = "SELECT a FROM Anomalia a WHERE a.descripcion = :descripcion")})
public class Anomalia implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAnomalia")
    private Integer idAnomalia;
    @Basic(optional = false)
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "Empleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private Empleado empleado;

    public Anomalia() {
    }

    public Anomalia(Integer idAnomalia) {
        this.idAnomalia = idAnomalia;
    }

    public Anomalia(Integer idAnomalia, Date fecha) {
        this.idAnomalia = idAnomalia;
        this.fecha = fecha;
    }

    public Integer getIdAnomalia() {
        return idAnomalia;
    }

    public void setIdAnomalia(Integer idAnomalia) {
        Integer oldIdAnomalia = this.idAnomalia;
        this.idAnomalia = idAnomalia;
        changeSupport.firePropertyChange("idAnomalia", oldIdAnomalia, idAnomalia);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String oldDescripcion = this.descripcion;
        this.descripcion = descripcion;
        changeSupport.firePropertyChange("descripcion", oldDescripcion, descripcion);
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
        hash += (idAnomalia != null ? idAnomalia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anomalia)) {
            return false;
        }
        Anomalia other = (Anomalia) object;
        if ((this.idAnomalia == null && other.idAnomalia != null) || (this.idAnomalia != null && !this.idAnomalia.equals(other.idAnomalia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "registrocontrol.clases.Anomalia[idAnomalia=" + idAnomalia + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
