package com.arelance.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "user_imd")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM UserImd u"),
    @NamedQuery(name = "User.findByIdUsuario", query = "SELECT u FROM UserImd u WHERE u.userId = :userId"),
    @NamedQuery(name = "Usuario.findByName", query = "SELECT u FROM UserImd u WHERE u.name = :name"),
    @NamedQuery(name = "User.findBySurnameA", query = "SELECT u FROM UserImd u WHERE u.surnameA = :surnameA"),
    @NamedQuery(name = "User.findBySurnameB", query = "SELECT u FROM UserImd u WHERE u.surnameB = :surnameB"),
    @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM UserImd u WHERE u.phone = :phone"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM UserImd u WHERE u.email = :email")})
public class UserImd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer userId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname_a")
    private String surnameA;
    @Column(name = "surname_b")
    private String surnameB;
    @Column(name = "phone")
    private String phone;
    //@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userSessionData")
    private SessionData sessionData;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userImd")
    private List<UserHasActivity> userHasActivity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userImd")
    private List<PaymentMethod> paymentsMethods;

    public UserImd() {
        super();
        this.userHasActivity = new ArrayList<>();
        this.paymentsMethods = new ArrayList<>();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnameA() {
        return surnameA;
    }

    public void setSurnameA(String surnameA) {
        this.surnameA = surnameA;
    }

    public String getSurnameB() {
        return surnameB;
    }

    public void setSurnameB(String surnameB) {
        this.surnameB = surnameB;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SessionData getSessionData() {
        return sessionData;
    }

    public void setSessionData(SessionData sessionData) {
        this.sessionData = sessionData;
    }

    public List<UserHasActivity> getUserHasActivity() {
        return userHasActivity;
    }

    public void setUserHasActivity(List<UserHasActivity> userHasActivity) {
        this.userHasActivity = userHasActivity;
    }

    public List<PaymentMethod> getPaymentsMethods() {
        return paymentsMethods;
    }

    public void setPaymentsMethods(List<PaymentMethod> paymentsMethods) {
        this.paymentsMethods = paymentsMethods;
    }

    public void addPaymentMethod(PaymentMethod paymentMethod) {
        paymentsMethods.add(paymentMethod);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.userId);
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
        final UserImd other = (UserImd) obj;
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return true;
    }

}
