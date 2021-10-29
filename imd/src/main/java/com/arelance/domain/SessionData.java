package com.arelance.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "session_data")
@NamedQueries({
    @NamedQuery(name = "SessionData.findAll", query = "SELECT d FROM SessionData d"),
    @NamedQuery(name = "SessionData.findBySessionDataId", query = "SELECT d FROM SessionData d WHERE d.sessionDataId = :sessionDataId"),
    @NamedQuery(name = "SessionData.findByUser", query = "SELECT d FROM SessionData d WHERE d.userImd = :userImd"),
    @NamedQuery(name = "SessionData.sessionValidate", query = "SELECT d FROM SessionData d WHERE d.userImd = :userImd AND d.password = :password"),
    @NamedQuery(name = "SessionData.findByPassword", query = "SELECT d FROM SessionData d WHERE d.password = :password")}
)
public class SessionData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_session_data")
    private Integer sessionDataId;
    @Column(name = "user_imd")
    private String userImd;
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @OneToOne(optional = false)
    private UserImd userSessionData;

    public SessionData() {
        super();
    }

    public Integer getSessionDataId() {
        return sessionDataId;
    }

    public void setSessionDataId(Integer sessionDataId) {
        this.sessionDataId = sessionDataId;
    }

    public String getUser() {
        return userImd;
    }

    public void setUser(String userImd) {
        this.userImd = userImd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserImd getUserSessionData() {
        return userSessionData;
    }

    public void setUserSessionData(UserImd userSessionData) {
        this.userSessionData = userSessionData;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.sessionDataId);
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
        final SessionData other = (SessionData) obj;
        if (!Objects.equals(this.userImd, other.userImd)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.sessionDataId, other.sessionDataId)) {
            return false;
        }
        return Objects.equals(this.userSessionData, other.userSessionData);
    }

}
