//package br.com.personal.livia.service;
//
//import br.com.personal.livia.adapter.dto.PhysicalExerciseDto;
//import br.com.personal.livia.exception.CustomException;
//import br.com.personal.livia.adapter.db.model.MuscleGroupModel;
//import br.com.personal.livia.adapter.db.model.ExerciseModel;
//import br.com.personal.livia.application.repository.PhysicalExerciseRepository;
//import br.com.personal.livia.util.StringUtils;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PhysicalExerciseServiceImp implements PhysicalExerciseService{
//
//    private final PhysicalExerciseRepository physicalExerciseRepository;
//
//    public PhysicalExerciseServiceImp(PhysicalExerciseRepository physicalExerciseRepository) {
//        this.physicalExerciseRepository = physicalExerciseRepository;
//    }
//
//    public ExerciseModel save(PhysicalExerciseDto physicalExerciseDto) throws CustomException {
//        var physicalExerciseModel = new ExerciseModel();
//
//        String stringMuscleGroup = StringUtils.capitalize(physicalExerciseDto.getMuscleGroup());
//        MuscleGroupModel muscleGroupModel = MuscleGroupModel.getMuscleGroup(stringMuscleGroup);
//        if (muscleGroupModel == null) {
//            throw new CustomException("Unknown MuscleGroup: " + physicalExerciseDto.getMuscleGroup() + " please verify and try again.");
//        }
//
//        String name = StringUtils.capitalize(physicalExerciseDto.getName());
//        ExerciseModel exerciseModelAlreadyExists = physicalExerciseRepository.getByName(name);
//        if (exerciseModelAlreadyExists != null) {
//            throw new CustomException("PhysicalExercise: " + name + " already registered in system.");
//        }
//
//        physicalExerciseModel.setName(name);
//        physicalExerciseModel.setMuscleGroupEntity(muscleGroupModel);
//        physicalExerciseModel.setDescription(StringUtils.capitalize(physicalExerciseDto.getDescription()));
//
//        return physicalExerciseRepository.save(physicalExerciseModel);
//    }
//
//    public ResponseEntity<Page<ExerciseModel>> findAll(Pageable pageable) {
//        return ResponseEntity.status(HttpStatus.OK).body(physicalExerciseRepository.findAll(pageable));
//    }
//}
