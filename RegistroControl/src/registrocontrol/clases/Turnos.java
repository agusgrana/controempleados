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
@Table(name = "turnos")
@NamedQueries({
    @NamedQuery(name = "Turnos.findAll", query = "SELECT t FROM Turnos t"),
    @NamedQuery(name = "Turnos.borrar", query = "DELETE FROM Turnos t WHERE t.fecha = :fecha AND t.horario = :horario"),
    @NamedQuery(name = "Turnos.borrar", query = "DELETE FROM Turnos t WHERE t.fecha = :fecha AND t.horario = :horario"),
    @NamedQuery(name = "Turnos.findByIdTurnos", query = "SELECT t FROM Turnos t WHERE t.idTurnos = :idTurnos"),
    @NamedQuery(name = "Turnos.porFechaHorario", query = "SELECT t FROM Turnos t WHERE t.fecha = :fecha AND t.horario = :horario"),
    @NamedQuery(name = "Turnos.findByFecha", query = "SELECT t FROM Turnos t WHERE t.fecha = :fecha")})
public class Turnos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTurnos")
    private Integer idTurnos;
    @Basic(optional = false)
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "Empleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private Empleado empleado;
    @JoinColumn(name = "Horario", referencedColumnName = "idHorarios")
    @ManyToOne(optional = false)
    private Horario horario;

    public Turnos() {
    }

    public Turnos(Integer idTurnos) {
        this.idTurnos = idTurnos;
    }

    public Turnos(Integer idTurnos, Date fecha) {
        this.idTurnos = idTurnos;
        this.fecha = fecha;
    }

    public Integer getIdTurnos() {
        return idTurnos;
    }

    public void setIdTurnos(Integer idTurnos) {
        Integer oldIdTurnos = this.idTurnos;
        this.idTurnos = idTurnos;
        changeSupport.firePropertyChange("idTurnos", oldIdTurnos, idTurnos);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        Empleado oldEmpleado = this.empleado;
        this.empleado = empleado;
        changeSupport.firePropertyChange("empleado", oldEmpleado, empleado);
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        Horario oldHorario = this.horario;
        this.horario = horario;
        changeSupport.firePropertyChange("horario", oldHorario, horario);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTurnos != null ? idTurnos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turnos)) {
            return false;
        }
        Turnos other = (Turnos) object;
        if ((this.idTurnos == null && other.idTurnos != null) || (this.idTurnos != null && !this.idTurnos.equals(other.idTurnos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "registrocontrol.clases.Turnos[idTurnos=" + idTurnos + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
