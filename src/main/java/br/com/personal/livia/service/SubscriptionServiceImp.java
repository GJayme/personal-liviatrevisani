package br.com.personal.livia.service;

import br.com.personal.livia.dto.SubscriptionDto;
import br.com.personal.livia.exception.CustomException;
import br.com.personal.livia.model.ClientModel;
import br.com.personal.livia.model.SubscriptionModel;
import br.com.personal.livia.repository.SubscriptionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
public class SubscriptionServiceImp implements SubscriptionService {

    final SubscriptionRepository subscriptionRepository;
    final ClientServiceImp clientService;

    public SubscriptionServiceImp(SubscriptionRepository subscriptionRepository, ClientServiceImp clientService) {
        this.subscriptionRepository = subscriptionRepository;
        this.clientService = clientService;
    }

    @Transactional
    public SubscriptionModel save(SubscriptionDto subscriptionDto) throws Exception {
        Optional<ClientModel> optionalClientModel = clientService.getById(subscriptionDto.getClientId());
        if (optionalClientModel.isEmpty()) {
            throw new CustomException("Error to save new Subscription. ClientId: " + subscriptionDto.getClientId() + " doesn't exists.");
        }

        var subscriptionModel = new SubscriptionModel();
        subscriptionModel.setFrequencyDays(subscriptionDto.getFrequencyDays());
        subscriptionModel.setValueHour(subscriptionDto.getValueHour());
        subscriptionModel.setDate(LocalDate.parse(subscriptionDto.getDate()));
        subscriptionModel.setClientModel(optionalClientModel.get());
        subscriptionModel.setCreateDate(LocalDateTime.now(ZoneId.of("UTC")));
        subscriptionModel.setUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));

        return subscriptionRepository.save(subscriptionModel);
    }

    public ResponseEntity<Page<SubscriptionModel>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionRepository.findAll(pageable));
    }
}
