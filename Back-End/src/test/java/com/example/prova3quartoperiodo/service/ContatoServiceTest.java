package com.example.prova3quartoperiodo.service;

import com.example.prova3quartoperiodo.exceptions.ContatoAlreadyExistsException;
import com.example.prova3quartoperiodo.exceptions.ContatoNotFoundException;
import com.example.prova3quartoperiodo.model.ContatoModel;
import com.example.prova3quartoperiodo.Service.ContatoService;
import com.example.prova3quartoperiodo.repositories.ContatoRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContatoServiceTest {

    @Autowired
    ContatoService service;

    @MockBean
    ContatoRepository repository;

    @Test
    @DisplayName("Retorna concluído quando inserir contato")
    public void shouldReturnConcluded_WhenInsideContato(){
        ContatoModel contatoTest = new ContatoModel(10L,"Paulo","paulolima@email.com","1111-1111");
        Assertions.assertDoesNotThrow(() -> service.create(contatoTest));
    }

    @Test
    @DisplayName("Retorna existente quando inserir contato com telefone já cadastrado")
    public void shouldReturnException_WhenInsertContatoWithExistentTelefone(){
        ContatoModel contatoTest = new ContatoModel(2L,"Lucas","lucas25@email.com","7070-7070");
        Assertions.assertThrows(ContatoAlreadyExistsException.class, () -> service.create(contatoTest));
    }

    @Test
    @DisplayName("Retorna existente quando inserir contato com email já cadastrado")
    public void shouldReturnException_WhenInsertContatoWithExistentEmail(){
        ContatoModel contatoTest = new ContatoModel(2L,"Lucas","lucas@email.com","2020-2020");
        Assertions.assertThrows(ContatoAlreadyExistsException.class, () -> service.create(contatoTest));
    }

    @BeforeEach
    public void setup(){
        ContatoModel contato = new ContatoModel(1L,"Lima","lucas@email.com","7070-7070");
        Mockito.when(repository.findById(contato.getIdContato())).thenReturn(java.util.Optional.of(contato));
    }
}
