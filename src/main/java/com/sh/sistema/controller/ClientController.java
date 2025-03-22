package com.sh.sistema.controller;

import com.sh.sistema.entities.Client;
import com.sh.sistema.service.ClientService;
import jakarta.servlet.Servlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> list = clientService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{matricula}")
    public ResponseEntity<Client> findById(@PathVariable Integer matricula){
        Client obj = clientService.findById(matricula);
        return ResponseEntity.ok().body(obj);

    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client obj){
        obj = clientService.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{matricula}")
                .buildAndExpand(obj.getMatricula())
                .toUri();
        return ResponseEntity.created(uri).body(obj);

    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> delete(@PathVariable Integer matricula){
        clientService.delete(matricula);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{matricula}")
    public ResponseEntity<Client> update(@PathVariable Integer matricula, @RequestBody Client obj){
        obj = clientService.update(matricula, obj);
        return ResponseEntity.ok().body(obj);
    }


}

