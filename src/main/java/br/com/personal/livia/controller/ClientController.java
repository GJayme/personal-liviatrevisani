package br.com.personal.livia.controller;

import br.com.personal.livia.dto.ClientDto;
import br.com.personal.livia.model.ClientModel;
import br.com.personal.livia.service.ClientService;
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

    final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Object> saveClient(@RequestBody @Valid ClientDto clientDto) throws Exception {
        ClientModel clientModelSaved = clientService.save(clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientModelSaved);
    }

    @GetMapping
    public ResponseEntity<Page<ClientModel>> getAllClient(@PageableDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        return clientService.findAll(pageable);
    }
}
