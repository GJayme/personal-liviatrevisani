package br.com.personal.livia.adapter.db.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "EXERCISE_EXECUTION")
public class ExerciseExecutionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
