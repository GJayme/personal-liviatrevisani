package br.com.personal.livia.service;

import br.com.personal.livia.dto.ClientDto;
import br.com.personal.livia.exception.CustomException;
import br.com.personal.livia.model.ClientModel;
import br.com.personal.livia.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceImp implements ClientService{

    final ClientRepository clientRepository;

    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public ClientModel save(ClientDto clientDto) throws CustomException {
        var clientModel = new ClientModel();
        BeanUtils.copyProperties(clientDto, clientModel);

        clientModel.setCreateDate(LocalDateTime.now(ZoneId.of("UTC")));
        clientModel.setUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        clientModel.setBirthday(LocalDate.parse(clientDto.getBirthday()));
        clientModel.setGender(clientDto.getGender().toUpperCase().charAt(0));

        ClientModel clientModelAlreadyExists = getByCpf(clientDto.getCpf());

        if (clientModelAlreadyExists != null) {
            throw new CustomException("Client: " + clientDto.getName() + " already registered in system");
        }

        return clientRepository.save(clientModel);
    }

    public ResponseEntity<Page<ClientModel>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.findAll(pageable));
    }

    public Optional<ClientModel> getById(String clientId) {
        return clientRepository.findById(UUID.fromString(clientId));
    }

    public ClientModel getByCpf(String cpf) {
        return clientRepository.findByCpf(cpf);
    }
}
