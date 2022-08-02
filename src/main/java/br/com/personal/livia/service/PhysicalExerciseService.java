package br.com.personal.livia.service;

import br.com.personal.livia.dto.PhysicalExerciseDto;
import br.com.personal.livia.exception.CustomException;
import br.com.personal.livia.model.PhysicalExerciseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PhysicalExerciseService {

    PhysicalExerciseModel save(PhysicalExerciseDto physicalExerciseDto) throws CustomException;

    ResponseEntity<Page<PhysicalExerciseModel>> findAll(Pageable pageable);

}
