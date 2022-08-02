package br.com.personal.livia.service;

import br.com.personal.livia.dto.PhysicalExerciseDto;
import br.com.personal.livia.model.PhysicalExerciseModel;
import br.com.personal.livia.repository.PhysicalExerciseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PhysicalExerciseServiceImp implements PhysicalExerciseService{

    private PhysicalExerciseRepository physicalExerciseRepository;


    public PhysicalExerciseModel save(PhysicalExerciseDto physicalExerciseDto) {
        return null;
    }

    public ResponseEntity<Page<PhysicalExerciseModel>> findAll(Pageable pageable) {
        return null;
    }
}
