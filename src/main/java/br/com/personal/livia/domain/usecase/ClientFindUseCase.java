package br.com.personal.livia.domain.usecase;

import br.com.personal.livia.domain.entity.Client;
import br.com.personal.livia.domain.exception.ClientException;
import br.com.personal.livia.domain.usecase.port.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientFindUseCase {

    private final ClientRepository clientRepository;

    public ClientFindUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findById(UUID id) {
        Optional<Client> optionalClientById = clientRepository.findById(id);
        if (optionalClientById.isEmpty()) {
            throw new ClientException("The system has no find the client of id: " + id + ". Please verify and try again.");
        }
        return optionalClientById.get();
    }

    public Client findByCpf(String cpf) {
        Optional<Client> optionalClientByCpf = clientRepository.findByCpf(cpf);
        if (optionalClientByCpf.isEmpty()) {
            throw new ClientException("The system has no find the client of cpf: " + cpf + ". Please verify and try again.");
        }
        return optionalClientByCpf.get();
    }

    public Client findByEmail(String email) {
        Optional<Client> optionalClientByEmail = clientRepository.findByEmail(email);
        if (optionalClientByEmail.isEmpty()) {
            throw new ClientException("The system has no find the client of email: " + email + ". Please verify and try again.");
        }
        return optionalClientByEmail.get();
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
