package br.com.personal.livia.service;

import br.com.personal.livia.dto.SubscriptionDto;
import br.com.personal.livia.model.SubscriptionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface SubscriptionService {

    SubscriptionModel save(SubscriptionDto subscriptionDto) throws Exception;

    ResponseEntity<Page<SubscriptionModel>> findAll(Pageable pageable);

}
