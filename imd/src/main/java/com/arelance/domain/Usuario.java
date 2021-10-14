package com.arelance.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")})
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
    private ArrayList<Actividad> actividadesUsuario = new ArrayList<>();
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Paypal paypal;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Tarjeta tarjeta;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Transferencia transferencia;

    public Usuario() {
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

    public Paypal getPaypal() {
        return paypal;
    }

    public void setPaypal(Paypal paypal) {
        this.paypal = paypal;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idUsuario);
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.apellidoA);
        hash = 59 * hash + Objects.hashCode(this.apellidoB);
        hash = 59 * hash + Objects.hashCode(this.telefono);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.datosSesion);
        hash = 59 * hash + Objects.hashCode(this.actividadesUsuario);
        hash = 59 * hash + Objects.hashCode(this.paypal);
        hash = 59 * hash + Objects.hashCode(this.tarjeta);
        hash = 59 * hash + Objects.hashCode(this.transferencia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidoA, other.apellidoA)) {
            return false;
        }
        if (!Objects.equals(this.apellidoB, other.apellidoB)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        if (!Objects.equals(this.datosSesion, other.datosSesion)) {
            return false;
        }
        if (!Objects.equals(this.actividadesUsuario, other.actividadesUsuario)) {
            return false;
        }
        if (!Objects.equals(this.paypal, other.paypal)) {
            return false;
        }
        if (!Objects.equals(this.tarjeta, other.tarjeta)) {
            return false;
        }
        return Objects.equals(this.transferencia, other.transferencia);
    }
}
