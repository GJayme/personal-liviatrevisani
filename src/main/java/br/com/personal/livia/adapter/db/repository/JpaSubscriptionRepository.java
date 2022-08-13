package br.com.personal.livia.adapter.db.repository;

import br.com.personal.livia.adapter.db.mapper.SubscriptionMapper;
import br.com.personal.livia.adapter.db.repository.data.JpaSubscriptionSpringData;
import br.com.personal.livia.domain.entity.Subscription;
import br.com.personal.livia.domain.usecase.port.SubscriptionRepository;
import org.springframework.stereotype.Repository;

import java.time.YearMonth;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaSubscriptionRepository implements SubscriptionRepository {

    final JpaSubscriptionSpringData jpaSubscriptionSpringData;

    public JpaSubscriptionRepository(JpaSubscriptionSpringData jpaSubscriptionSpringData) {
        this.jpaSubscriptionSpringData = jpaSubscriptionSpringData;
    }

    @Override
    public Subscription create(Subscription subscription) {
        var subscriptionEntity = SubscriptionMapper.toEntity(subscription);
        jpaSubscriptionSpringData.save(subscriptionEntity);
        return subscription;
    }

    @Override
    public Subscription update(UUID clientId, YearMonth yearMonthReference) {
        return null;
    }

    @Override
    public Optional<Subscription> findByClientIdAndYearMonth(UUID clientId, YearMonth yearMonthReference) {
        return Optional.empty();
    }

    @Override
    public List<Subscription> findAll() {
        return null;
    }
}
