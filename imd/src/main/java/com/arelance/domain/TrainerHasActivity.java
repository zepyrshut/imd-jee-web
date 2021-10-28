package com.arelance.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "trainer_has_activity")
@NamedQueries({
    @NamedQuery(name = "TrainerHasActivity.findAll", query = "SELECT e FROM TrainerHasActivity e"),
    @NamedQuery(name = "TrainerHasActivity.findByIdTrainer", query = "SELECT e FROM TrainerHasActivity e WHERE e.trainerHasActivityPK.trainerId = :trainerId"),
    @NamedQuery(name = "TrainerHasActivity.findByIdActivity", query = "SELECT e FROM TrainerHasActivity e WHERE e.trainerHasActivityPK.activityId = :activityId")})
public class TrainerHasActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrainerHasActivityPK trainerHasActivityPK;
    @JoinColumns({
        @JoinColumn(name = "id_activity", referencedColumnName = "id_activity", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "id_trainer", referencedColumnName = "id_trainer", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Trainer trainer;

    public TrainerHasActivity() {
        super();
    }

    public TrainerHasActivityPK getTrainerHasActivityPK() {
        return trainerHasActivityPK;
    }

    public void setTrainerHasActivityPK(TrainerHasActivityPK trainerHasActivityPK) {
        this.trainerHasActivityPK = trainerHasActivityPK;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.trainerHasActivityPK);
        hash = 23 * hash + Objects.hashCode(this.activity);
        hash = 23 * hash + Objects.hashCode(this.trainer);
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
        final TrainerHasActivity other = (TrainerHasActivity) obj;
        if (!Objects.equals(this.trainerHasActivityPK, other.trainerHasActivityPK)) {
            return false;
        }
        if (!Objects.equals(this.activity, other.activity)) {
            return false;
        }
        return Objects.equals(this.trainer, other.trainer);
    }

}
