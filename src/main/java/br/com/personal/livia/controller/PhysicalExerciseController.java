package br.com.personal.livia.controller;

import br.com.personal.livia.dto.PhysicalExerciseDto;
import br.com.personal.livia.model.PhysicalExerciseModel;
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

    final PhysicalExerciseService physicalExerciseService;

    public PhysicalExerciseController(PhysicalExerciseService physicalExerciseService) {
        this.physicalExerciseService = physicalExerciseService;
    }

    @PostMapping
    public ResponseEntity<Object> saveClient(@RequestBody @Valid PhysicalExerciseDto physicalExerciseDto) {
        PhysicalExerciseModel physicalExerciseModel = physicalExerciseService.save(physicalExerciseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(physicalExerciseModel);
    }

    @GetMapping
    public ResponseEntity<Page<PhysicalExerciseModel>> getAllClient(@PageableDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        return physicalExerciseService.findAll(pageable);
    }
}
