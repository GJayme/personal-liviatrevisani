package br.com.personal.livia.domain.usecase;

import br.com.personal.livia.domain.entity.Client;
import br.com.personal.livia.domain.exception.ClientException;
import br.com.personal.livia.domain.usecase.port.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientCreateUseCase {

    private final ClientRepository clientRepository;

    public ClientCreateUseCase(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client create(Client client) {
        Optional<Client> optionalClientByCpf = clientRepository.findByCpf(client.getCpf());
//        if (optionalClientByCpf.isPresent()) {
//            throw new ClientException("The system had one client whit this cpf: " + client.getCpf() + "Please verify and try again.");
//        }
//
//        Optional<Client> optionalClientByEmail = clientRepository.findByEmail(client.getEmail());
//        if (optionalClientByEmail.isPresent()) {
//            throw new ClientException("The system had one client whit this email: " + client.getEmail() + "Please verify and try again.");
//        }

        return clientRepository.create(client);
    }
}
