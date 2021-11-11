package com.example.prova3quartoperiodo.controller;

import com.example.prova3quartoperiodo.model.ContatoModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContatoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ContatoController controller;

    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Retorna concluído quando inserir contato")
    public void shouldReturnConcluded_WhenInsideContato() throws Exception{
        ContatoModel contato = new ContatoModel(1L,"Paulo","paulolima@email.com","1111-1111");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(contato);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contato")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @DisplayName("Retorna existente quando inserir contato com telefone já cadastrado")
    public void shouldReturnException_WhenInsertContatoWithExistentTelefone() throws Exception {
        ContatoModel existingContato = new ContatoModel(2L,"Lucas","lucas25@email.com","7070-7070");
        ContatoModel contato = new ContatoModel(3L,"Luquinhas","luquinhas123@email.com","7070-7070");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(existingContato);
        String json2 = mapper.writeValueAsString(contato);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contato")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contato")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json2))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
    }

    @Test
    @DisplayName("Retorna existente quando inserir contato com email já cadastrado")
    public void shouldReturnException_WhenInsertContatoWithExistentEmail() throws Exception {
        ContatoModel existingContato = new ContatoModel(2L,"Lucas","lucas25@email.com","7070-7070");
        ContatoModel contato = new ContatoModel(3L,"Luquinhas","lucas25@email.com","2525-7070");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(existingContato);
        String json2 = mapper.writeValueAsString(contato);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contato")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contato")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json2))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
    }
}

