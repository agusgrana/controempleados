/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.io.Serializable;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vinculacion")
    private List<Empleado> empleadoList;

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
        this.idVinculacion = idVinculacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getPrestaciones() {
        return prestaciones;
    }

    public void setPrestaciones(boolean prestaciones) {
        this.prestaciones = prestaciones;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
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

}
