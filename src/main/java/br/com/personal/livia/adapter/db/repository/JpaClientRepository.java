package br.com.personal.livia.adapter.db.repository;

import br.com.personal.livia.adapter.db.mapper.ClientMapper;
import br.com.personal.livia.adapter.db.model.ClientModel;
import br.com.personal.livia.adapter.db.repository.data.JpaClientSpringData;
import br.com.personal.livia.domain.entity.Client;
import br.com.personal.livia.domain.usecase.port.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    public boolean delete(Client client) {
        return false;
    }

    @Override
    public Optional<Client> findByCpf(String cpf) {
//        return jpaClientSpringData.findByCpf(cpf);
        return null;
    }

    @Override
    public Optional<Client> findByEmail(String email) {
//        return jpaClientSpringData.findByEmail(email);
        return null;
    }

    @Override
    public List<Client> findAll() {
//        return jpaClientSpringData.;
        return null;
    }
}
