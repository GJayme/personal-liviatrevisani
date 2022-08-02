package br.com.personal.livia.model;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "WORKOUT")
public class WorkOutModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String load;

    @Column
    private int rest;

    @Column
    private String cadence;

    @Column
    private int serie;

    @Column
    private int repeat;

    @Column
    private int time;

    @ManyToMany
    @JoinTable(
            name = "WORKOUT_PYSICAL_EXERCISE",
            joinColumns = @JoinColumn(name = "id_workout"),
            inverseJoinColumns = @JoinColumn(name = "id_pysical_exercise"))
    private Set<PhysicalExerciseModel> physicalExerciseModelSet;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    public String getCadence() {
        return cadence;
    }

    public void setCadence(String cadence) {
        this.cadence = cadence;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Set<PhysicalExerciseModel> getPhysicalExerciseModelSet() {
        return physicalExerciseModelSet;
    }

    public void setPhysicalExerciseModelSet(Set<PhysicalExerciseModel> physicalExerciseModelSet) {
        this.physicalExerciseModelSet = physicalExerciseModelSet;
    }
}
