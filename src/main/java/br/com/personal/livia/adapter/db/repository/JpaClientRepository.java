package br.com.personal.livia.adapter.db.repository;

import br.com.personal.livia.adapter.db.mapper.ClientMapper;
import br.com.personal.livia.adapter.db.model.ClientModel;
import br.com.personal.livia.adapter.db.repository.data.JpaClientSpringData;
import br.com.personal.livia.domain.entity.Client;
import br.com.personal.livia.domain.usecase.port.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaClientRepository implements ClientRepository {

    final JpaClientSpringData jpaClientSpringData;

    public JpaClientRepository(JpaClientSpringData jpaClientSpringData) {
        this.jpaClientSpringData = jpaClientSpringData;
    }

    @Override
    public Client create(Client client) {
        var clientEntity = ClientMapper.toEntity(client);
        jpaClientSpringData.save(clientEntity);
        return client;
    }

    @Override
    public Optional<Client> findById(UUID id) {
        Optional<ClientModel> clientModelOptional = jpaClientSpringData.findById(id);
        if (clientModelOptional.isEmpty()) {
            return Optional.empty();
        }
        var client = ClientMapper.toClient(clientModelOptional.get());
        return Optional.of(client);
    }

    @Override
    public Optional<Client> findByCpf(String cpf) {
        Optional<ClientModel> clientModelOptional = jpaClientSpringData.findByCpf(cpf);
        if (clientModelOptional.isEmpty()) {
            return Optional.empty();
        }
        var client = ClientMapper.toClient(clientModelOptional.get());
        return Optional.of(client);
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        Optional<ClientModel> clientModelOptional = jpaClientSpringData.findByEmail(email);
        if (clientModelOptional.isEmpty()) {
            return Optional.empty();
        }
        var client = ClientMapper.toClient(clientModelOptional.get());
        return Optional.of(client);
    }

    @Override
    public List<Client> findAll() {
        List<ClientModel> clientModelList = jpaClientSpringData.findAll();
        List<Client> clientList = new ArrayList<>();
        for (ClientModel clientModel : clientModelList) {
            var client = ClientMapper.toClient(clientModel);
            clientList.add(client);
        }
        return clientList;
    }
}
