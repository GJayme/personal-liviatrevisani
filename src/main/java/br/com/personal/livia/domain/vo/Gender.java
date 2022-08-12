package br.com.personal.livia.domain.vo;

import java.util.Arrays;

public enum Gender {
    MALE("Masculino"),
    FEMALE("Feminino"),
    OTHER("Outro");

    private final String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Gender getGender(String description) {
        return Arrays.stream(Gender.values())
                .filter(gender -> gender.getDescription().equals(description))
                .findFirst().orElse(null);
    }
}
