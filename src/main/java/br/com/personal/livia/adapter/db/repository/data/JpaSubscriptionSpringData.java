package br.com.personal.livia.adapter.db.repository.data;

import br.com.personal.livia.adapter.db.model.SubscriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaSubscriptionSpringData extends JpaRepository<SubscriptionModel, UUID> {
}
