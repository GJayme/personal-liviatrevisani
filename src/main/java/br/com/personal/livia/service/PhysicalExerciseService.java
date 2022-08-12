package br.com.personal.livia.service;

import br.com.personal.livia.adapter.dto.PhysicalExerciseDto;
import br.com.personal.livia.exception.CustomException;
import br.com.personal.livia.adapter.db.model.ExerciseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PhysicalExerciseService {

    ExerciseModel save(PhysicalExerciseDto physicalExerciseDto) throws CustomException;

    ResponseEntity<Page<ExerciseModel>> findAll(Pageable pageable);

}
