package com.arelance.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "user_has_activty")
@NamedQueries({
    @NamedQuery(name = "UserHasActivity.findAll", query = "SELECT u FROM UserHasActivity u")})
public class UserHasActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserHasActivityPK userHasActivityPK;
    @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)
    @ManyToOne
    private Activity activity;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
    @ManyToOne
    private UserImd userImd;
    @JoinColumn(name = "id_payment", referencedColumnName = "id_payment", insertable = false, updatable = false)
    @ManyToOne
    private PaymentMethod paymentMethod;

    public UserHasActivity() {
        super();
    }

    public UserHasActivityPK getUserHasActivityPK() {
        return userHasActivityPK;
    }

    public void setUserHasActivityPK(UserHasActivityPK userHasActivityPK) {
        this.userHasActivityPK = userHasActivityPK;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public UserImd getUserImd() {
        return userImd;
    }

    public void setUserImd(UserImd userImd) {
        this.userImd = userImd;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.userHasActivityPK);
        hash = 17 * hash + Objects.hashCode(this.activity);
        hash = 17 * hash + Objects.hashCode(this.userImd);
        hash = 17 * hash + Objects.hashCode(this.paymentMethod);
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
        final UserHasActivity other = (UserHasActivity) obj;
        if (!Objects.equals(this.userHasActivityPK, other.userHasActivityPK)) {
            return false;
        }
        if (!Objects.equals(this.activity, other.activity)) {
            return false;
        }
        if (!Objects.equals(this.userImd, other.userImd)) {
            return false;
        }
        return Objects.equals(this.paymentMethod, other.paymentMethod);
    }

}
