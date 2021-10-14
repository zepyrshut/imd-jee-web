package com.arelance.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Pedro, Jorge
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido_a")
    private String apellidoA;
    @Column(name = "apellido_b")
    private String apellidoB;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarioSocio")
    private DatosSesion datosSesion;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "listaUsuarios")
    private ArrayList<Actividad> actividadesUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<MetodoPago> metodoPago;

    public Usuario() {
        this.actividadesUsuario = new ArrayList<>();
        this.metodoPago = new ArrayList<MetodoPago>();
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoA() {
        return apellidoA;
    }

    public void setApellidoA(String apellidoA) {
        this.apellidoA = apellidoA;
    }

    public String getApellidoB() {
        return apellidoB;
    }

    public void setApellidoB(String apellidoB) {
        this.apellidoB = apellidoB;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DatosSesion getDatosSesion() {
        return datosSesion;
    }

    public void setDatosSesion(DatosSesion datosSesion) {
        this.datosSesion = datosSesion;
    }

    public ArrayList<Actividad> getActividadesUsuario() {
        return actividadesUsuario;
    }

    public void addActivity(Actividad actividad) {
        actividadesUsuario.add(actividad);
        actividad.getListaUsuarios().add(this);
    }

    public List<MetodoPago> getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(List<MetodoPago> metodoPago) {
        this.metodoPago = metodoPago;
    }

}
