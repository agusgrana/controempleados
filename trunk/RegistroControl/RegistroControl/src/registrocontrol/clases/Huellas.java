/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package registrocontrol.clases;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author gurzaf
 */
@Entity
@Table(name = "huellas")
@NamedQueries({
    @NamedQuery(name = "Huellas.findAll", query = "SELECT h FROM Huellas h"),
    @NamedQuery(name = "Huellas.findByEmpleado", query = "SELECT h FROM Huellas h JOIN h.empleado e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Huellas.findByIdHuellas", query = "SELECT h FROM Huellas h WHERE h.idHuellas = :idHuellas"),
    @NamedQuery(name = "Huellas.findByDescripcion", query = "SELECT h FROM Huellas h WHERE h.descripcion = :descripcion")})
public class Huellas implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHuellas")
    private Integer idHuellas;
    @Basic(optional = false)
    @Lob
    @Column(name = "Huella")
    private byte[] huella;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "Empleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private Empleado empleado;

    public Huellas() {
    }

    public Huellas(Integer idHuellas) {
        this.idHuellas = idHuellas;
    }

    public Huellas(Integer idHuellas, byte[] huella, String descripcion) {
        this.idHuellas = idHuellas;
        this.huella = huella;
        this.descripcion = descripcion;
    }

    public Integer getIdHuellas() {
        return idHuellas;
    }

    public void setIdHuellas(Integer idHuellas) {
        Integer oldIdHuellas = this.idHuellas;
        this.idHuellas = idHuellas;
        changeSupport.firePropertyChange("idHuellas", oldIdHuellas, idHuellas);
    }

    public byte[] getHuella() {
        return huella;
    }

    public void setHuella(byte[] huella) {
        byte[] oldHuella = this.huella;
        this.huella = huella;
        changeSupport.firePropertyChange("huella", oldHuella, huella);
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
        hash += (idHuellas != null ? idHuellas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Huellas)) {
            return false;
        }
        Huellas other = (Huellas) object;
        if ((this.idHuellas == null && other.idHuellas != null) || (this.idHuellas != null && !this.idHuellas.equals(other.idHuellas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Huellas[idHuellas=" + idHuellas + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
