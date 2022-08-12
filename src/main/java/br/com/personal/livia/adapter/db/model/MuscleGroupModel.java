package br.com.personal.livia.adapter.db.model;

import java.util.Objects;

public enum MuscleGroupModel {
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

    MuscleGroupModel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static MuscleGroupModel getMuscleGroup(String description) {
        for (MuscleGroupModel muscleGroupModel : MuscleGroupModel.values()) {
            if (Objects.equals(muscleGroupModel.getDescription(), description)) {
                return muscleGroupModel;
            }
        }
        return null;
    }
}
