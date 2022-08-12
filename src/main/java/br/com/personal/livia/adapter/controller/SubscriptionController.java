package br.com.personal.livia.adapter.controller;

import br.com.personal.livia.adapter.dto.SubscriptionDto;
import br.com.personal.livia.adapter.db.model.SubscriptionModel;
import br.com.personal.livia.service.SubscriptionService;
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
@RequestMapping("/api/v1/subscription")
public class SubscriptionController {

//    final SubscriptionService subscriptionService;
//
//    public SubscriptionController(SubscriptionService subscriptionService) {
//        this.subscriptionService = subscriptionService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Object> saveSubscription(@RequestBody @Valid SubscriptionDto subscriptionDto) throws Exception {
//        SubscriptionModel subscriptionModelSaved = subscriptionService.save(subscriptionDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionModelSaved);
//    }
//
//    @GetMapping
//    public ResponseEntity<Page<SubscriptionModel>> getAllSubscription(@PageableDefault(sort = "date", direction = Sort.Direction.ASC) Pageable pageable) {
//        return subscriptionService.findAll(pageable);
//    }
}
