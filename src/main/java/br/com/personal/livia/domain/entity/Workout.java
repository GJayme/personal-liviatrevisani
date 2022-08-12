package br.com.personal.livia.domain.entity;

import br.com.personal.livia.domain.exception.WorkoutException;

import java.util.Set;

public class Workout {

    private final Set<Exercise> exerciseSet;

    public Workout(Set<Exercise> exerciseSet) {
        this.exerciseSet = exerciseSet;
    }

    public void addNewExercise(Exercise exercise) {
        if (exerciseSet.contains(exercise)) {
            throw new WorkoutException("This exercise is already in workout, please add new exercise.");
        }
        exerciseSet.add(exercise);
    }

    public void removeExercise(Exercise exercise) {
        exerciseSet.remove(exercise);
    }
}
