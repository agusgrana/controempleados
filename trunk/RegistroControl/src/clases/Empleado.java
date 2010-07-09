/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author GeRmAn
 */
@Entity
@Table(name = "empleado")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleado.findByNombres", query = "SELECT e FROM Empleado e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Empleado.findByFechaNacimiento", query = "SELECT e FROM Empleado e WHERE e.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Empleado.findByDireccion", query = "SELECT e FROM Empleado e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empleado.findByTelefono", query = "SELECT e FROM Empleado e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Empleado.findByEmail", query = "SELECT e FROM Empleado e WHERE e.email = :email"),
    @NamedQuery(name = "Empleado.findByTipoSangre", query = "SELECT e FROM Empleado e WHERE e.tipoSangre = :tipoSangre")})
public class Empleado implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idEmpleado")
    private Integer idEmpleado;
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
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "tipoSangre")
    private String tipoSangre;
    @Basic(optional = false)
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Familiar> familiarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Salario> salarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Turnos> turnosList;
    @JoinColumn(name = "vinculacion", referencedColumnName = "idVinculacion")
    @ManyToOne(optional = false)
    private Vinculacion vinculacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Historialaboral> historialaboralList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Huellas> huellasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Anomalia> anomaliaList;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(Integer idEmpleado, String nombres, String apellidos, Date fechaNacimiento, String direccion, int telefono, String email, String tipoSangre, byte[] foto) {
        this.idEmpleado = idEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.tipoSangre = tipoSangre;
        this.foto = foto;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        Integer oldIdEmpleado = this.idEmpleado;
        this.idEmpleado = idEmpleado;
        changeSupport.firePropertyChange("idEmpleado", oldIdEmpleado, idEmpleado);
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        String oldDireccion = this.direccion;
        this.direccion = direccion;
        changeSupport.firePropertyChange("direccion", oldDireccion, direccion);
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        int oldTelefono = this.telefono;
        this.telefono = telefono;
        changeSupport.firePropertyChange("telefono", oldTelefono, telefono);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        String oldTipoSangre = this.tipoSangre;
        this.tipoSangre = tipoSangre;
        changeSupport.firePropertyChange("tipoSangre", oldTipoSangre, tipoSangre);
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        byte[] oldFoto = this.foto;
        this.foto = foto;
        changeSupport.firePropertyChange("foto", oldFoto, foto);
    }

    public List<Familiar> getFamiliarList() {
        return familiarList;
    }

    public void setFamiliarList(List<Familiar> familiarList) {
        this.familiarList = familiarList;
    }

    public List<Salario> getSalarioList() {
        return salarioList;
    }

    public void setSalarioList(List<Salario> salarioList) {
        this.salarioList = salarioList;
    }

    public List<Turnos> getTurnosList() {
        return turnosList;
    }

    public void setTurnosList(List<Turnos> turnosList) {
        this.turnosList = turnosList;
    }

    public Vinculacion getVinculacion() {
        return vinculacion;
    }

    public void setVinculacion(Vinculacion vinculacion) {
        Vinculacion oldVinculacion = this.vinculacion;
        this.vinculacion = vinculacion;
        changeSupport.firePropertyChange("vinculacion", oldVinculacion, vinculacion);
    }

    public List<Historialaboral> getHistorialaboralList() {
        return historialaboralList;
    }

    public void setHistorialaboralList(List<Historialaboral> historialaboralList) {
        this.historialaboralList = historialaboralList;
    }

    public List<Huellas> getHuellasList() {
        return huellasList;
    }

    public void setHuellasList(List<Huellas> huellasList) {
        this.huellasList = huellasList;
    }

    public List<Anomalia> getAnomaliaList() {
        return anomaliaList;
    }

    public void setAnomaliaList(List<Anomalia> anomaliaList) {
        this.anomaliaList = anomaliaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "registrocontrol.clases.Empleado[idEmpleado=" + idEmpleado + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public void setDescripcion(String nombreEmpleado) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
