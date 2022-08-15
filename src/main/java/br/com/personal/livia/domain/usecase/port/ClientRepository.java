package br.com.personal.livia.domain.usecase.port;

import br.com.personal.livia.domain.entity.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository {

    Client create(Client client);

    Optional<Client> findById(UUID id);

    Optional<Client> findByCpf(String cpf);

    Optional<Client> findByEmail(String email);

    List<Client> findAll();
}
