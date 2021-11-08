package com.arelance.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jorge
 */
@Entity
@Table(name = "payment_method")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PaymentMethod implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    protected Integer paymentId;
    @Column(name = "name_payment")
    protected String paymentName;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserImd userImd;

    protected PaymentMethod() {
        super();
    }

    protected PaymentMethod(String paymentName) {
        this.paymentName = paymentName;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public UserImd getUserImd() {
        return userImd;
    }

    public void setUserImd(UserImd userImd) {
        this.userImd = userImd;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentMethod)) {
            return false;
        }
        return paymentId != null && paymentId.equals(((PaymentMethod) obj).getPaymentId());

    }

}
