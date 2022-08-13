package br.com.personal.livia.adapter.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/physical-exercise")
public class PhysicalExerciseController {

//    final PhysicalExerciseService physicalExerciseService;
//
//    public PhysicalExerciseController(PhysicalExerciseService physicalExerciseService) {
//        this.physicalExerciseService = physicalExerciseService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Object> saveClient(@RequestBody @Valid PhysicalExerciseDto physicalExerciseDto) throws CustomException {
//        ExerciseModel exerciseModel = physicalExerciseService.save(physicalExerciseDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(exerciseModel);
//    }
//
//    @GetMapping
//    public ResponseEntity<Page<ExerciseModel>> getAllClient(@PageableDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
//        return physicalExerciseService.findAll(pageable);
//    }
}
