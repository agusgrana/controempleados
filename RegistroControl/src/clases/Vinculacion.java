/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author gurzaf
 */
@Entity
@Table(name = "vinculacion")
@NamedQueries({
    @NamedQuery(name = "Vinculacion.findAll", query = "SELECT v FROM Vinculacion v"),
    @NamedQuery(name = "Vinculacion.findByIdVinculacion", query = "SELECT v FROM Vinculacion v WHERE v.idVinculacion = :idVinculacion"),
    @NamedQuery(name = "Vinculacion.findByDescripcion", query = "SELECT v FROM Vinculacion v WHERE v.descripcion = :descripcion"),
    @NamedQuery(name = "Vinculacion.findByPrestaciones", query = "SELECT v FROM Vinculacion v WHERE v.prestaciones = :prestaciones")})
public class Vinculacion implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVinculacion")
    private Integer idVinculacion;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "prestaciones")
    private boolean prestaciones;

    public Vinculacion() {
    }

    public Vinculacion(Integer idVinculacion) {
        this.idVinculacion = idVinculacion;
    }

    public Vinculacion(Integer idVinculacion, String descripcion, boolean prestaciones) {
        this.idVinculacion = idVinculacion;
        this.descripcion = descripcion;
        this.prestaciones = prestaciones;
    }

    public Integer getIdVinculacion() {
        return idVinculacion;
    }

    public void setIdVinculacion(Integer idVinculacion) {
        Integer oldIdVinculacion = this.idVinculacion;
        this.idVinculacion = idVinculacion;
        changeSupport.firePropertyChange("idVinculacion", oldIdVinculacion, idVinculacion);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String oldDescripcion = this.descripcion;
        this.descripcion = descripcion;
        changeSupport.firePropertyChange("descripcion", oldDescripcion, descripcion);
    }

    public boolean getPrestaciones() {
        return prestaciones;
    }

    public void setPrestaciones(boolean prestaciones) {
        boolean oldPrestaciones = this.prestaciones;
        this.prestaciones = prestaciones;
        changeSupport.firePropertyChange("prestaciones", oldPrestaciones, prestaciones);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVinculacion != null ? idVinculacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vinculacion)) {
            return false;
        }
        Vinculacion other = (Vinculacion) object;
        if ((this.idVinculacion == null && other.idVinculacion != null) || (this.idVinculacion != null && !this.idVinculacion.equals(other.idVinculacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Vinculacion[idVinculacion=" + idVinculacion + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
