package br.com.personal.livia.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PhysicalExerciseDto {

    @NotBlank
    @Size(max = 130)
    private String name;

    @NotBlank
    private String muscleGroup;

    private String description;

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
}
