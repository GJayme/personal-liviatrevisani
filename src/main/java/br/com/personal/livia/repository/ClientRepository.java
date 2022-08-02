package br.com.personal.livia.repository;

import br.com.personal.livia.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, UUID> {
    ClientModel findByCpf(String cpf);
}
