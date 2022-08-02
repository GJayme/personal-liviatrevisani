package br.com.personal.livia.model;

import java.util.Objects;

public enum MuscleGroup {
    BICEPS("Biceps"),
    CORE("Core"),
    DELTOIDE("Deltoide"),
    EXTRENSECOS_COSTAS("Extrinsecos das costas"),
    FLEXORES_QUADRIL("Flexores de quadril"),
    GLUTEOS("Gluteos"),
    ISQUIOTIBIAIS("Isquiotibiais"),
    PANTURRILHA("Panturrilha"),
    QUADRICEPS("Quadriceps"),
    TRICEPS("Triceps");

    private final String description;

    MuscleGroup(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static MuscleGroup getMuscleGroup(String description) {
        for (MuscleGroup muscleGroup : MuscleGroup.values()) {
            if (Objects.equals(muscleGroup.getDescription(), description)) {
                return muscleGroup;
            }
        }
        return null;
    }
}
