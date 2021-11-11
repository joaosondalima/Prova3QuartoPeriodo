package com.example.prova3quartoperiodo.repositories;

import com.example.prova3quartoperiodo.model.ContatoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContatoRepository extends JpaRepository<ContatoModel, Long>{
    Optional<ContatoModel> findByContatoEmail(String email);
    Optional<ContatoModel> findByContatoTelefone(String Telefone);
}
