/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package registrocontrol.clases;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "turnosvista")
@NamedQueries({
    @NamedQuery(name = "Turnosvista.findAll", query = "SELECT t FROM Turnosvista t"),
    @NamedQuery(name = "Turnosvista.findByIdTurnos", query = "SELECT t FROM Turnosvista t WHERE t.idTurnos = :idTurnos"),
    @NamedQuery(name = "Turnosvista.findByHorario", query = "SELECT t FROM Turnosvista t WHERE t.horario = :horario"),
    @NamedQuery(name = "Turnosvista.findByEmpleado", query = "SELECT t FROM Turnosvista t WHERE t.empleado = :empleado"),
    @NamedQuery(name = "Turnosvista.findByFecha", query = "SELECT t FROM Turnosvista t WHERE t.fecha = :fecha")})
public class Turnosvista implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idTurnos")
    @Id
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

    public Turnosvista() {
    }

    public Turnosvista(Integer idTurnos) {
        this.idTurnos = idTurnos;
    }

    public Turnosvista(Integer idTurnos, Date fecha) {
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
}
