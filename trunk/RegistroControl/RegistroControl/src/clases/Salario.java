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
@Table(name = "salario")
@NamedQueries({
    @NamedQuery(name = "Salario.findAll", query = "SELECT s FROM Salario s"),
    @NamedQuery(name = "Salario.findByIdsalario", query = "SELECT s FROM Salario s WHERE s.idsalario = :idsalario"),
    @NamedQuery(name = "Salario.findByFecha", query = "SELECT s FROM Salario s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "Salario.findByValorBruto", query = "SELECT s FROM Salario s WHERE s.valorBruto = :valorBruto"),
    @NamedQuery(name = "Salario.findByValorNeto", query = "SELECT s FROM Salario s WHERE s.valorNeto = :valorNeto"),
    @NamedQuery(name = "Salario.findBySalud", query = "SELECT s FROM Salario s WHERE s.salud = :salud"),
    @NamedQuery(name = "Salario.findByPension", query = "SELECT s FROM Salario s WHERE s.pension = :pension"),
    @NamedQuery(name = "Salario.findByAccionJudicial", query = "SELECT s FROM Salario s WHERE s.accionJudicial = :accionJudicial"),
    @NamedQuery(name = "Salario.findByCooperativa", query = "SELECT s FROM Salario s WHERE s.cooperativa = :cooperativa"),
    @NamedQuery(name = "Salario.findByPrestaciones", query = "SELECT s FROM Salario s WHERE s.prestaciones = :prestaciones"),
    @NamedQuery(name = "Salario.findByExtras", query = "SELECT s FROM Salario s WHERE s.extras = :extras"),
    @NamedQuery(name = "Salario.findByAdicionales", query = "SELECT s FROM Salario s WHERE s.adicionales = :adicionales"),
    @NamedQuery(name = "Salario.findByCesantias", query = "SELECT s FROM Salario s WHERE s.cesantias = :cesantias"),
    @NamedQuery(name = "Salario.findByPrimas", query = "SELECT s FROM Salario s WHERE s.primas = :primas"),
    @NamedQuery(name = "Salario.findByBonificaciones", query = "SELECT s FROM Salario s WHERE s.bonificaciones = :bonificaciones")})
public class Salario implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsalario")
    private Integer idsalario;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "valorBruto")
    private int valorBruto;
    @Basic(optional = false)
    @Column(name = "valorNeto")
    private int valorNeto;
    @Basic(optional = false)
    @Column(name = "salud")
    private int salud;
    @Basic(optional = false)
    @Column(name = "pension")
    private int pension;
    @Basic(optional = false)
    @Column(name = "accionJudicial")
    private int accionJudicial;
    @Basic(optional = false)
    @Column(name = "cooperativa")
    private int cooperativa;
    @Basic(optional = false)
    @Column(name = "prestaciones")
    private int prestaciones;
    @Basic(optional = false)
    @Column(name = "extras")
    private int extras;
    @Basic(optional = false)
    @Column(name = "adicionales")
    private int adicionales;
    @Basic(optional = false)
    @Column(name = "cesantias")
    private int cesantias;
    @Basic(optional = false)
    @Column(name = "primas")
    private int primas;
    @Basic(optional = false)
    @Column(name = "bonificaciones")
    private int bonificaciones;
    @JoinColumn(name = "codEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private Empleado empleado;

    public Salario() {
    }

    public Salario(Integer idsalario) {
        this.idsalario = idsalario;
    }

    public Salario(Integer idsalario, Date fecha, int valorBruto, int valorNeto, int salud, int pension, int accionJudicial, int cooperativa, int prestaciones, int extras, int adicionales, int cesantias, int primas, int bonificaciones) {
        this.idsalario = idsalario;
        this.fecha = fecha;
        this.valorBruto = valorBruto;
        this.valorNeto = valorNeto;
        this.salud = salud;
        this.pension = pension;
        this.accionJudicial = accionJudicial;
        this.cooperativa = cooperativa;
        this.prestaciones = prestaciones;
        this.extras = extras;
        this.adicionales = adicionales;
        this.cesantias = cesantias;
        this.primas = primas;
        this.bonificaciones = bonificaciones;
    }

    public Integer getIdsalario() {
        return idsalario;
    }

    public void setIdsalario(Integer idsalario) {
        Integer oldIdsalario = this.idsalario;
        this.idsalario = idsalario;
        changeSupport.firePropertyChange("idsalario", oldIdsalario, idsalario);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public int getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(int valorBruto) {
        int oldValorBruto = this.valorBruto;
        this.valorBruto = valorBruto;
        changeSupport.firePropertyChange("valorBruto", oldValorBruto, valorBruto);
    }

    public int getValorNeto() {
        return valorNeto;
    }

    public void setValorNeto(int valorNeto) {
        int oldValorNeto = this.valorNeto;
        this.valorNeto = valorNeto;
        changeSupport.firePropertyChange("valorNeto", oldValorNeto, valorNeto);
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        int oldSalud = this.salud;
        this.salud = salud;
        changeSupport.firePropertyChange("salud", oldSalud, salud);
    }

    public int getPension() {
        return pension;
    }

    public void setPension(int pension) {
        int oldPension = this.pension;
        this.pension = pension;
        changeSupport.firePropertyChange("pension", oldPension, pension);
    }

    public int getAccionJudicial() {
        return accionJudicial;
    }

    public void setAccionJudicial(int accionJudicial) {
        int oldAccionJudicial = this.accionJudicial;
        this.accionJudicial = accionJudicial;
        changeSupport.firePropertyChange("accionJudicial", oldAccionJudicial, accionJudicial);
    }

    public int getCooperativa() {
        return cooperativa;
    }

    public void setCooperativa(int cooperativa) {
        int oldCooperativa = this.cooperativa;
        this.cooperativa = cooperativa;
        changeSupport.firePropertyChange("cooperativa", oldCooperativa, cooperativa);
    }

    public int getPrestaciones() {
        return prestaciones;
    }

    public void setPrestaciones(int prestaciones) {
        int oldPrestaciones = this.prestaciones;
        this.prestaciones = prestaciones;
        changeSupport.firePropertyChange("prestaciones", oldPrestaciones, prestaciones);
    }

    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        int oldExtras = this.extras;
        this.extras = extras;
        changeSupport.firePropertyChange("extras", oldExtras, extras);
    }

    public int getAdicionales() {
        return adicionales;
    }

    public void setAdicionales(int adicionales) {
        int oldAdicionales = this.adicionales;
        this.adicionales = adicionales;
        changeSupport.firePropertyChange("adicionales", oldAdicionales, adicionales);
    }

    public int getCesantias() {
        return cesantias;
    }

    public void setCesantias(int cesantias) {
        int oldCesantias = this.cesantias;
        this.cesantias = cesantias;
        changeSupport.firePropertyChange("cesantias", oldCesantias, cesantias);
    }

    public int getPrimas() {
        return primas;
    }

    public void setPrimas(int primas) {
        int oldPrimas = this.primas;
        this.primas = primas;
        changeSupport.firePropertyChange("primas", oldPrimas, primas);
    }

    public int getBonificaciones() {
        return bonificaciones;
    }

    public void setBonificaciones(int bonificaciones) {
        int oldBonificaciones = this.bonificaciones;
        this.bonificaciones = bonificaciones;
        changeSupport.firePropertyChange("bonificaciones", oldBonificaciones, bonificaciones);
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
        hash += (idsalario != null ? idsalario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salario)) {
            return false;
        }
        Salario other = (Salario) object;
        if ((this.idsalario == null && other.idsalario != null) || (this.idsalario != null && !this.idsalario.equals(other.idsalario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "registrocontrol.clases.Salario[idsalario=" + idsalario + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
