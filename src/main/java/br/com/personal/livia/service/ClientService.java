package br.com.personal.livia.service;

import br.com.personal.livia.dto.ClientDto;
import br.com.personal.livia.exception.CustomException;
import br.com.personal.livia.model.ClientModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ClientService {

    ClientModel save(ClientDto clientDto) throws CustomException;

    ResponseEntity<Page<ClientModel>> findAll(Pageable pageable);

    ClientModel getByCpf(String cpf);

    Optional<ClientModel> getById(String clientId) throws Exception;

}
