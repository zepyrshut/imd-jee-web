package com.arelance.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Pedro
 */
@Embeddable
public class UserHasActivityPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id_user")
    private int userId;
    @Column(name = "id_activity")
    private int activityId;
    @Column(name = "id_payment")
    private int paymentId;

    public UserHasActivityPK() {
    }

    public UserHasActivityPK(int userId, int activityId, int paymentId) {
        this.userId = userId;
        this.activityId = activityId;
        this.paymentId = paymentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.userId;
        hash = 37 * hash + this.activityId;
        hash = 37 * hash + this.paymentId;
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
        final UserHasActivityPK other = (UserHasActivityPK) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.activityId != other.activityId) {
            return false;
        }
        return this.paymentId == other.paymentId;
    }

}
