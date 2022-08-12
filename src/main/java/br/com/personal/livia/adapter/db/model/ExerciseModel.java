package br.com.personal.livia.adapter.db.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "EXERCISE")
public class ExerciseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 130)
    private String name;
    @Column(nullable = false)
    private MuscleGroupModel muscleGroupModel;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    private ExerciseExecutionModel exerciseExecutionModel;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MuscleGroupModel getMuscleGroupEntity() {
        return muscleGroupModel;
    }

    public void setMuscleGroupEntity(MuscleGroupModel muscleGroupModel) {
        this.muscleGroupModel = muscleGroupModel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExerciseExecutionModel getExerciseExecution() {
        return exerciseExecutionModel;
    }

    public void setExerciseExecution(ExerciseExecutionModel exerciseExecutionModel) {
        this.exerciseExecutionModel = exerciseExecutionModel;
    }
}
