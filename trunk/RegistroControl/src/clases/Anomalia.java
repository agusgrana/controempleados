/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

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
@Table(name = "anomalia")
@NamedQueries({
    @NamedQuery(name = "Anomalia.findAll", query = "SELECT a FROM Anomalia a"),
    @NamedQuery(name = "Anomalia.findByIdAnomalia", query = "SELECT a FROM Anomalia a WHERE a.idAnomalia = :idAnomalia"),
    @NamedQuery(name = "Anomalia.findByFecha", query = "SELECT a FROM Anomalia a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Anomalia.findByDescripcion", query = "SELECT a FROM Anomalia a WHERE a.descripcion = :descripcion")})
public class Anomalia implements Serializable {
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
        this.idAnomalia = idAnomalia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        return "clases.Anomalia[idAnomalia=" + idAnomalia + "]";
    }

}
