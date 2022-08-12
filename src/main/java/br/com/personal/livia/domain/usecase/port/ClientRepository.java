package br.com.personal.livia.domain.usecase.port;

import br.com.personal.livia.domain.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Client create(Client client);

    boolean delete(Client client);

    Optional<Client> findByCpf(String cpf);

    Optional<Client> findByEmail(String email);

    List<Client> findAll();
}
