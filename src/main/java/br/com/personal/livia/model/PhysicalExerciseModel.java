package br.com.personal.livia.model;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "PHYSICAL_EXERCISE")
public class PhysicalExerciseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 130)
    private String name;

    @Column(nullable = false)
    private String muscleGroup;

    @Column
    private String description;

    @ManyToMany(mappedBy = "physicalExerciseModelSet")
    private Set<WorkOutModel> workOutModelSet;

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

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<WorkOutModel> getWorkOutModelSet() {
        return workOutModelSet;
    }

    public void setWorkOutModelSet(Set<WorkOutModel> workOutModelSet) {
        this.workOutModelSet = workOutModelSet;
    }
}
