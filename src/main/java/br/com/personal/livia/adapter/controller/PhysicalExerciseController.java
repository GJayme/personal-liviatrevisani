package br.com.personal.livia.adapter.controller;

import br.com.personal.livia.adapter.dto.PhysicalExerciseDto;
import br.com.personal.livia.exception.CustomException;
import br.com.personal.livia.adapter.db.model.ExerciseModel;
import br.com.personal.livia.service.PhysicalExerciseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
