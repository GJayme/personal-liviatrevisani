package br.com.personal.livia.adapter.db.model;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "WORKOUT")
public class WorkOutModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToMany
    @JoinTable(
            name = "WORKOUT_PYSICAL_EXERCISE",
            joinColumns = @JoinColumn(name = "id_workout"),
            inverseJoinColumns = @JoinColumn(name = "id_pysical_exercise"))
    private Set<ExerciseModel> exerciseModelSet;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<ExerciseModel> getPhysicalExerciseModelSet() {
        return exerciseModelSet;
    }

    public void setPhysicalExerciseModelSet(Set<ExerciseModel> exerciseModelSet) {
        this.exerciseModelSet = exerciseModelSet;
    }
}
