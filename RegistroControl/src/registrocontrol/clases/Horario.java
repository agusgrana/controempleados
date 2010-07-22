/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package registrocontrol.clases;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author gurzaf
 */
@Entity
@Table(name = "horario")
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h"),
    @NamedQuery(name = "Horario.findByIdHorarios", query = "SELECT h FROM Horario h WHERE h.idHorarios = :idHorarios"),
    @NamedQuery(name = "Horario.findByNombreHorario", query = "SELECT h FROM Horario h WHERE h.nombreHorario = :nombreHorario"),
    @NamedQuery(name = "Horario.findByHoraEntrada", query = "SELECT h FROM Horario h WHERE h.horaEntrada = :horaEntrada"),
    @NamedQuery(name = "Horario.findByHoraSalida", query = "SELECT h FROM Horario h WHERE h.horaSalida = :horaSalida")})
public class Horario implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHorarios")
    private Integer idHorarios;
    @Basic(optional = false)
    @Column(name = "nombreHorario")
    private String nombreHorario;
    @Basic(optional = false)
    @Column(name = "horaEntrada")
    @Temporal(TemporalType.TIME)
    private Date horaEntrada;
    @Basic(optional = false)
    @Column(name = "horaSalida")
    @Temporal(TemporalType.TIME)
    private Date horaSalida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horario")
    private List<Turnos> turnosList;

    public Horario() {
    }

    public Horario(Integer idHorarios) {
        this.idHorarios = idHorarios;
    }

    public Horario(Integer idHorarios, String nombreHorario, Date horaEntrada, Date horaSalida) {
        this.idHorarios = idHorarios;
        this.nombreHorario = nombreHorario;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public Integer getIdHorarios() {
        return idHorarios;
    }

    public void setIdHorarios(Integer idHorarios) {
        Integer oldIdHorarios = this.idHorarios;
        this.idHorarios = idHorarios;
        changeSupport.firePropertyChange("idHorarios", oldIdHorarios, idHorarios);
    }

    public String getNombreHorario() {
        return nombreHorario;
    }

    public void setNombreHorario(String nombreHorario) {
        String oldNombreHorario = this.nombreHorario;
        this.nombreHorario = nombreHorario;
        changeSupport.firePropertyChange("nombreHorario", oldNombreHorario, nombreHorario);
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        Date oldHoraEntrada = this.horaEntrada;
        this.horaEntrada = horaEntrada;
        changeSupport.firePropertyChange("horaEntrada", oldHoraEntrada, horaEntrada);
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        Date oldHoraSalida = this.horaSalida;
        this.horaSalida = horaSalida;
        changeSupport.firePropertyChange("horaSalida", oldHoraSalida, horaSalida);
    }

    public List<Turnos> getTurnosList() {
        return turnosList;
    }

    public void setTurnosList(List<Turnos> turnosList) {
        this.turnosList = turnosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorarios != null ? idHorarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.idHorarios == null && other.idHorarios != null) || (this.idHorarios != null && !this.idHorarios.equals(other.idHorarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Horario[idHorarios=" + idHorarios + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
