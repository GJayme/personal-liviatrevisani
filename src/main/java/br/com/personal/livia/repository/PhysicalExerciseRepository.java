package br.com.personal.livia.repository;

import br.com.personal.livia.model.PhysicalExerciseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhysicalExerciseRepository extends JpaRepository<PhysicalExerciseModel, UUID> {
    PhysicalExerciseModel getByName(String name);
}
