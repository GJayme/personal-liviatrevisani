package br.com.personal.livia.adapter.db.repository.data;

import br.com.personal.livia.adapter.db.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaClientSpringData extends JpaRepository<ClientModel, UUID> {

    Optional<ClientModel> findById(UUID id);

    Optional<ClientModel> findByCpf(String cpf);

    Optional<ClientModel> findByEmail(String email);
}
