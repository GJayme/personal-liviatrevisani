package br.com.personal.livia.domain.usecase;

import br.com.personal.livia.domain.entity.Subscription;
import br.com.personal.livia.domain.exception.SubscriptionException;
import br.com.personal.livia.domain.usecase.port.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionCreateUseCase {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionCreateUseCase(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription create(Subscription subscription) {
        Optional<Subscription> optionalSubscription = subscriptionRepository.findByClientIdAndYearMonth(subscription.getClientId(), subscription.getYearMonthReference());
        if (optionalSubscription.isPresent()) {
            throw new SubscriptionException("The system had subscription of this month for this client.");
        }
        return subscriptionRepository.create(subscription);
    }
}
