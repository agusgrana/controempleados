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
@Table(name = "familiar")
@NamedQueries({
    @NamedQuery(name = "Familiar.findAll", query = "SELECT f FROM Familiar f"),
    @NamedQuery(name = "Familiar.findByIdFamiliar", query = "SELECT f FROM Familiar f WHERE f.idFamiliar = :idFamiliar"),
    @NamedQuery(name = "Familiar.findByNombres", query = "SELECT f FROM Familiar f WHERE f.nombres = :nombres"),
    @NamedQuery(name = "Familiar.findByApellidos", query = "SELECT f FROM Familiar f WHERE f.apellidos = :apellidos"),
    @NamedQuery(name = "Familiar.findByFechaNacimiento", query = "SELECT f FROM Familiar f WHERE f.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Familiar.findByParentesco", query = "SELECT f FROM Familiar f WHERE f.parentesco = :parentesco")})
public class Familiar implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idFamiliar")
    private Integer idFamiliar;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "parentesco")
    private String parentesco;
    @JoinColumn(name = "empleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private Empleado empleado;

    public Familiar() {
    }

    public Familiar(Integer idFamiliar) {
        this.idFamiliar = idFamiliar;
    }

    public Familiar(Integer idFamiliar, String nombres, String apellidos, Date fechaNacimiento, String parentesco) {
        this.idFamiliar = idFamiliar;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.parentesco = parentesco;
    }

    public Integer getIdFamiliar() {
        return idFamiliar;
    }

    public void setIdFamiliar(Integer idFamiliar) {
        Integer oldIdFamiliar = this.idFamiliar;
        this.idFamiliar = idFamiliar;
        changeSupport.firePropertyChange("idFamiliar", oldIdFamiliar, idFamiliar);
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        String oldNombres = this.nombres;
        this.nombres = nombres;
        changeSupport.firePropertyChange("nombres", oldNombres, nombres);
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        String oldApellidos = this.apellidos;
        this.apellidos = apellidos;
        changeSupport.firePropertyChange("apellidos", oldApellidos, apellidos);
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        Date oldFechaNacimiento = this.fechaNacimiento;
        this.fechaNacimiento = fechaNacimiento;
        changeSupport.firePropertyChange("fechaNacimiento", oldFechaNacimiento, fechaNacimiento);
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        String oldParentesco = this.parentesco;
        this.parentesco = parentesco;
        changeSupport.firePropertyChange("parentesco", oldParentesco, parentesco);
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
        hash += (idFamiliar != null ? idFamiliar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Familiar)) {
            return false;
        }
        Familiar other = (Familiar) object;
        if ((this.idFamiliar == null && other.idFamiliar != null) || (this.idFamiliar != null && !this.idFamiliar.equals(other.idFamiliar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "registrocontrol.clases.Familiar[idFamiliar=" + idFamiliar + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
