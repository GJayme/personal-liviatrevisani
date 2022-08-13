package br.com.personal.livia.adapter.controller;

import br.com.personal.livia.adapter.db.mapper.SubscriptionMapper;
import br.com.personal.livia.adapter.dto.SubscriptionDto;
import br.com.personal.livia.adapter.db.model.SubscriptionModel;
import br.com.personal.livia.domain.entity.Subscription;
import br.com.personal.livia.domain.usecase.SubscriptionCreateUseCase;
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

    final SubscriptionCreateUseCase subscriptionCreateUseCase;

    public SubscriptionController(SubscriptionCreateUseCase subscriptionCreateUseCase) {
        this.subscriptionCreateUseCase = subscriptionCreateUseCase;
    }

    @PostMapping
    public ResponseEntity<Object> createSubscription(@RequestBody @Valid SubscriptionDto subscriptionDto) throws Exception {
        Subscription subscription = SubscriptionMapper.toSubscription(subscriptionDto);
        Subscription subscriptionSaved = subscriptionCreateUseCase.create(subscription);
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionSaved);
    }

    @GetMapping
    public ResponseEntity<Page<SubscriptionModel>> getAllSubscription(@PageableDefault(sort = "date", direction = Sort.Direction.ASC) Pageable pageable) {
//        return subscriptionService.findAll(pageable);
        return null;
    }
}
