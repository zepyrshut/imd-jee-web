package com.arelance.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "activity")
@NamedQueries({
    @NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a"),
    @NamedQuery(name = "Activity.findByIdActividad", query = "SELECT a FROM Activity a WHERE a.activityId = :activityId")})
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_activity")
    private Integer activityId;
    @Column(name = "name_activity")
    private String activityName;
    @Column(name = "description_activity")
    private String activityDescription;
    @Column(name = "category_activity")
    private String activityCategory;
    @Column(name = "price_activity")
    private Double activityPrice;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private TrainerHasActivity trainerHasActivity;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activity")
    private UserHasActivity userHasActivity;

    public Activity() {
        super();
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public String getActivityCategory() {
        return activityCategory;
    }

    public void setActivityCategory(String activityCategory) {
        this.activityCategory = activityCategory;
    }

    public Double getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(Double activityPrice) {
        this.activityPrice = activityPrice;
    }

    public TrainerHasActivity getTrainerHasActivity() {
        return trainerHasActivity;
    }

    public void setTrainerHasActivity(TrainerHasActivity trainerHasActivity) {
        this.trainerHasActivity = trainerHasActivity;
    }

    public UserHasActivity getUserHasActivity() {
        return userHasActivity;
    }

    public void setUserHasActivity(UserHasActivity userHasActivity) {
        this.userHasActivity = userHasActivity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.activityId);
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
        final Activity other = (Activity) obj;
        if (!Objects.equals(this.activityName, other.activityName)) {
            return false;
        }
        if (!Objects.equals(this.activityDescription, other.activityDescription)) {
            return false;
        }
        if (!Objects.equals(this.activityCategory, other.activityCategory)) {
            return false;
        }
        if (!Objects.equals(this.activityId, other.activityId)) {
            return false;
        }
        if (!Objects.equals(this.activityPrice, other.activityPrice)) {
            return false;
        }
        if (!Objects.equals(this.trainerHasActivity, other.trainerHasActivity)) {
            return false;
        }
        return Objects.equals(this.userHasActivity, other.userHasActivity);
    }
    
}
