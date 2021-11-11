package com.example.prova3quartoperiodo.controller;

import com.example.prova3quartoperiodo.model.ContatoModel;
import com.example.prova3quartoperiodo.repositories.ContatoRepository;
import com.example.prova3quartoperiodo.Service.ContatoService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/contato")
public class ContatoController {

    @Autowired
    private ContatoService service;
    private ContatoRepository repository;

    @GetMapping
    public ResponseEntity<List<ContatoModel>> index() {
        List<ContatoModel> list = service.index();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<ContatoModel> show(@PathVariable String email) {
        return ResponseEntity.ok(service.show(email));
    }

    @PostMapping
    public ResponseEntity<ContatoModel> create(@RequestBody ContatoModel entity) {
            try {
                    ContatoModel obj = service.create(entity);
                    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                            .buildAndExpand(obj.getIdContato()).toUri();
                    return ResponseEntity.created(uri).body(obj);
            }catch (ServiceException e) {
                return ResponseEntity.unprocessableEntity().build();
            }
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<ContatoModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ContatoModel> editContatoModel(@PathVariable Long id, @RequestBody ContatoModel update){
        return ResponseEntity.ok(service.update(id, update));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("Contato" + id + " deleted!");
    }
}
