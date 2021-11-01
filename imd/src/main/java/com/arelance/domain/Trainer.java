package com.arelance.domain;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.Table;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "trainer")
@NamedQueries({
    @NamedQuery(name = "Trainer.findAll", query = "SELECT e FROM Trainer e"),
    @NamedQuery(name = "Trainer.findByIdTrainer", query = "SELECT e FROM Trainer e WHERE e.trainerId = :trainerId"),
    @NamedQuery(name = "Trainer.findByNameTrainer", query = "SELECT e FROM Trainer e WHERE e.nameTrainer = :nameTrainer"),
    @NamedQuery(name = "Trainer.findBySurnameTrainer", query = "SELECT e FROM Trainer e WHERE e.surnameTrainer = :surnameTrainer")})
public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trainer")
    private Integer trainerId;
    @Column(name = "name_trainer")
    private String nameTrainer;
    @Column(name = "surname_trainer")
    private String surnameTrainer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainer")
    private Collection<TrainerHasActivity> trainerHasActivities;

    public Trainer() {
        super();
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public String getNameTrainer() {
        return nameTrainer;
    }

    public void setNameTrainer(String nameTrainer) {
        this.nameTrainer = nameTrainer;
    }

    public String getSurnameTrainer() {
        return surnameTrainer;
    }

    public void setSurnameTrainer(String surnameTrainer) {
        this.surnameTrainer = surnameTrainer;
    }

    public Collection<TrainerHasActivity> getTrainerHasActivities() {
        return trainerHasActivities;
    }

    public void setTrainerHasActivities(Collection<TrainerHasActivity> trainerHasActivities) {
        this.trainerHasActivities = trainerHasActivities;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.trainerId);
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
        final Trainer other = (Trainer) obj;
        if (!Objects.equals(this.nameTrainer, other.nameTrainer)) {
            return false;
        }
        if (!Objects.equals(this.surnameTrainer, other.surnameTrainer)) {
            return false;
        }
        if (!Objects.equals(this.trainerId, other.trainerId)) {
            return false;
        }
        return Objects.equals(this.trainerHasActivities, other.trainerHasActivities);
    }

}
