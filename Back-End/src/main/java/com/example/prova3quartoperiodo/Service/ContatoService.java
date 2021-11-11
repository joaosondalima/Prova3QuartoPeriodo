package com.example.prova3quartoperiodo.Service;

import com.example.prova3quartoperiodo.exceptions.ContatoAlreadyExistsException;
import com.example.prova3quartoperiodo.exceptions.ContatoNotFoundException;
import com.example.prova3quartoperiodo.model.ContatoModel;
import com.example.prova3quartoperiodo.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    public ContatoModel findById(long id) {
        Optional<ContatoModel> result = repository.findById(id);
        return result.orElseThrow(() -> new ContatoAlreadyExistsException("Contato não encontrado."));
    }

    public List<ContatoModel> index() {
        List<ContatoModel> result = repository.findAll();
        return result.stream().map(x -> new ContatoModel(x)).collect(Collectors.toList());
    }

    public ContatoModel create(ContatoModel contato){

        Optional<ContatoModel> contatoEmail = repository.findByContatoEmail(contato.getContatoEmail());
        if(contatoEmail.isPresent()){
            throw new ContatoAlreadyExistsException("Contato já existe");
        }

        Optional<ContatoModel> contatoTelefone = repository.findByContatoTelefone(contato.getContatoTelefone());
        if(contatoTelefone.isPresent()){
            throw new ContatoAlreadyExistsException("Contato já existe");
        }

        ContatoModel unit = new ContatoModel();
        unit.setContatoName(contato.getContatoName());
        unit.setContatoEmail(contato.getContatoEmail());
        unit.setContatoTelefone(contato.getContatoTelefone());

        unit = repository.save(unit);

        return unit;
    }

    public ContatoModel show(String email){
        Optional<ContatoModel> result = repository.findByContatoEmail(email);
        return result.orElseThrow(() -> new ContatoNotFoundException("Contato não encontrado."));
    }

    public ContatoModel update(Long id, ContatoModel update){
        ContatoModel updated = findById(id);

        Optional<ContatoModel> contatoEmail = repository.findByContatoEmail(update.getContatoEmail());
        if(contatoEmail.isPresent()){
            throw new ContatoAlreadyExistsException("Contato já existente");
        }

        Optional<ContatoModel> contatoTelephone = repository.findByContatoTelefone(update.getContatoTelefone());
        if(contatoTelephone.isPresent()){
            throw new ContatoAlreadyExistsException("Contato já existente");
        }

        updated.setContatoName(update.getContatoName());
        updated.setContatoEmail(update.getContatoEmail());
        updated.setContatoTelefone(update.getContatoTelefone());

        repository.save(updated);

        return updated;
    }

    public void delete(Long id){
        repository.delete(findById(id));
    }

}

