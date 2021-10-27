package com.arelance.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Pedro
 */
@Embeddable
public class TrainerHasActivityPK implements Serializable {

    @Column(name = "id_trainer")
    private int trainerId;
    @Column(name = "id_activity")
    private int activityId;

    public TrainerHasActivityPK() {
        super();
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.trainerId;
        hash = 31 * hash + this.activityId;
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
        final TrainerHasActivityPK other = (TrainerHasActivityPK) obj;
        if (this.trainerId != other.trainerId) {
            return false;
        }
        if (this.activityId != other.activityId) {
            return false;
        }
        return true;
    }

}
