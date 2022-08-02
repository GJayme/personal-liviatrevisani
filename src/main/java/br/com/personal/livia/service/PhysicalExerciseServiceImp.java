package br.com.personal.livia.service;

import br.com.personal.livia.dto.PhysicalExerciseDto;
import br.com.personal.livia.exception.CustomException;
import br.com.personal.livia.model.MuscleGroup;
import br.com.personal.livia.model.PhysicalExerciseModel;
import br.com.personal.livia.repository.PhysicalExerciseRepository;
import br.com.personal.livia.util.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PhysicalExerciseServiceImp implements PhysicalExerciseService{

    private final PhysicalExerciseRepository physicalExerciseRepository;

    public PhysicalExerciseServiceImp(PhysicalExerciseRepository physicalExerciseRepository) {
        this.physicalExerciseRepository = physicalExerciseRepository;
    }

    public PhysicalExerciseModel save(PhysicalExerciseDto physicalExerciseDto) throws CustomException {
        var physicalExerciseModel = new PhysicalExerciseModel();

        String stringMuscleGroup = StringUtils.capitalize(physicalExerciseDto.getMuscleGroup());
        MuscleGroup muscleGroup = MuscleGroup.getMuscleGroup(stringMuscleGroup);
        if (muscleGroup == null) {
            throw new CustomException("Unknown MuscleGroup: " + physicalExerciseDto.getMuscleGroup() + " please verify and try again.");
        }

        String name = StringUtils.capitalize(physicalExerciseDto.getName());
        PhysicalExerciseModel physicalExerciseModelAlreadyExists = physicalExerciseRepository.getByName(name);
        if (physicalExerciseModelAlreadyExists != null) {
            throw new CustomException("PhysicalExercise: " + name + " already registered in system.");
        }

        physicalExerciseModel.setName(name);
        physicalExerciseModel.setMuscleGroup(muscleGroup);
        physicalExerciseModel.setDescription(StringUtils.capitalize(physicalExerciseDto.getDescription()));

        return physicalExerciseRepository.save(physicalExerciseModel);
    }

    public ResponseEntity<Page<PhysicalExerciseModel>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(physicalExerciseRepository.findAll(pageable));
    }
}
