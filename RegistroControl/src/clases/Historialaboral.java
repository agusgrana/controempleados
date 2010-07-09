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
 * @author GeRmAn
 */
@Entity
@Table(name = "historialaboral")
@NamedQueries({
    @NamedQuery(name = "Historialaboral.findAll", query = "SELECT h FROM Historialaboral h"),
    @NamedQuery(name = "Historialaboral.findByIdHistoriaLaboral", query = "SELECT h FROM Historialaboral h WHERE h.idHistoriaLaboral = :idHistoriaLaboral"),
    @NamedQuery(name = "Historialaboral.findByCargo", query = "SELECT h FROM Historialaboral h WHERE h.cargo = :cargo"),
    @NamedQuery(name = "Historialaboral.findByFechaInicio", query = "SELECT h FROM Historialaboral h WHERE h.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Historialaboral.findByFechaSalida", query = "SELECT h FROM Historialaboral h WHERE h.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "Historialaboral.findBySalarioBase", query = "SELECT h FROM Historialaboral h WHERE h.salarioBase = :salarioBase"),
    @NamedQuery(name = "Historialaboral.findByValorHoraExtra", query = "SELECT h FROM Historialaboral h WHERE h.valorHoraExtra = :valorHoraExtra")})
public class Historialaboral implements Serializable {
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
    @Basic(optional = false)
    @Column(name = "fechaSalida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Basic(optional = false)
    @Column(name = "salarioBase")
    private int salarioBase;
    @Basic(optional = false)
    @Column(name = "valorHoraExtra")
    private int valorHoraExtra;
    @JoinColumn(name = "empleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private Empleado empleado;

    public Historialaboral() {
    }

    public Historialaboral(Integer idHistoriaLaboral) {
        this.idHistoriaLaboral = idHistoriaLaboral;
    }

    public Historialaboral(Integer idHistoriaLaboral, String cargo, Date fechaInicio, Date fechaSalida, int salarioBase, int valorHoraExtra) {
        this.idHistoriaLaboral = idHistoriaLaboral;
        this.cargo = cargo;
        this.fechaInicio = fechaInicio;
        this.fechaSalida = fechaSalida;
        this.salarioBase = salarioBase;
        this.valorHoraExtra = valorHoraExtra;
    }

    public Integer getIdHistoriaLaboral() {
        return idHistoriaLaboral;
    }

    public void setIdHistoriaLaboral(Integer idHistoriaLaboral) {
        this.idHistoriaLaboral = idHistoriaLaboral;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getValorHoraExtra() {
        return valorHoraExtra;
    }

    public void setValorHoraExtra(int valorHoraExtra) {
        this.valorHoraExtra = valorHoraExtra;
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
        return "registrocontrol.clases.Historialaboral[idHistoriaLaboral=" + idHistoriaLaboral + "]";
    }

}
