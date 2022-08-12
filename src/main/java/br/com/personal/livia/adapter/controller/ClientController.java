package br.com.personal.livia.adapter.controller;

import br.com.personal.livia.adapter.db.mapper.ClientMapper;
import br.com.personal.livia.adapter.db.model.ClientModel;
import br.com.personal.livia.adapter.dto.ClientDto;
import br.com.personal.livia.domain.entity.Client;
import br.com.personal.livia.domain.usecase.CreateClientUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/client")
public class ClientController {

    final CreateClientUseCase createClientUseCase;

    public ClientController(CreateClientUseCase createClientUseCase) {
        this.createClientUseCase = createClientUseCase;
    }

    @PostMapping
    public ResponseEntity<Object> saveClient(@RequestBody @Valid ClientDto clientDto) throws Exception {
        Client client = ClientMapper.toClient(clientDto);
        Client clientSaved = createClientUseCase.create(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientSaved);
    }

    @GetMapping
    public ResponseEntity<Page<ClientModel>> getAllClient(@PageableDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
//        return clientService.findAll(pageable);
        return null;
    }
}
