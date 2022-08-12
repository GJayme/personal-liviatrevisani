package br.com.personal.livia.domain.entity;

import br.com.personal.livia.domain.vo.MuscleGroup;

import java.util.Objects;

public class Exercise {

    private String name;
    private MuscleGroup muscleGroup;
    private ExerciseExecution exerciseExecution;
    private String description;

    public Exercise(String name, MuscleGroup muscleGroup, ExerciseExecution exerciseExecution, String description) {
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.exerciseExecution = exerciseExecution;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(name, exercise.name) && muscleGroup == exercise.muscleGroup && Objects.equals(exerciseExecution, exercise.exerciseExecution) && Objects.equals(description, exercise.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, muscleGroup, exerciseExecution, description);
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", muscleGroup=" + muscleGroup +
                ", exerciseExecution=" + exerciseExecution +
                ", description='" + description + '\'' +
                '}';
    }
}
