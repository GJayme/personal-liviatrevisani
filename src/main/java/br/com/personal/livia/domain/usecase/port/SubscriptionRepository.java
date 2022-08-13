package br.com.personal.livia.domain.usecase.port;

import br.com.personal.livia.domain.entity.Subscription;

import java.time.YearMonth;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubscriptionRepository {

    Subscription create(Subscription subscription);

    Subscription update(UUID clientId, YearMonth yearMonthReference);

    Optional<Subscription> findByClientIdAndYearMonth(UUID clientId, YearMonth yearMonthReference);

    List<Subscription> findAll();
}
