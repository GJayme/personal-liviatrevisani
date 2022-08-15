package br.com.personal.livia.adapter.controller;

import br.com.personal.livia.adapter.db.mapper.ClientMapper;
import br.com.personal.livia.adapter.dto.ClientDto;
import br.com.personal.livia.domain.entity.Client;
import br.com.personal.livia.domain.usecase.ClientCreateUseCase;
import br.com.personal.livia.domain.usecase.ClientFindUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/client")
public class ClientController {

    final ClientCreateUseCase clientCreateUseCase;
    final ClientFindUseCase clientFindUseCase;

    public ClientController(ClientCreateUseCase clientCreateUseCase, ClientFindUseCase clientFindUseCase) {
        this.clientCreateUseCase = clientCreateUseCase;
        this.clientFindUseCase = clientFindUseCase;
    }

    @PostMapping
    public ResponseEntity<Object> saveClient(@RequestBody @Valid ClientDto clientDto) {
        Client client = ClientMapper.toClient(clientDto);
        Client clientSaved = clientCreateUseCase.create(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
    }

    @GetMapping("/id={id}")
    public ResponseEntity<Object> getClientById(@PathVariable(value = "id") UUID id) {
        Client client = clientFindUseCase.findById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @GetMapping("/cpf={cpf}")
    public ResponseEntity<Object> getClientByCpf(@PathVariable(value = "cpf") String cpf) {
        Client client = clientFindUseCase.findByCpf(cpf);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @GetMapping("/email={email}")
    public ResponseEntity<Object> getClientById(@PathVariable(value = "email") String email) {
        Client client = clientFindUseCase.findByEmail(email);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @GetMapping()
    public ResponseEntity<Object> getAllClient() {
        List<Client> clientList = clientFindUseCase.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(clientList);
    }
}
