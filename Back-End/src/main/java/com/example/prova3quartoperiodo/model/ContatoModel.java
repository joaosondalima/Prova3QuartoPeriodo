package com.example.prova3quartoperiodo.model;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_contato")
public class ContatoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContato;

    private String contatoName;
    private String contatoEmail;
    private String contatoTelefone;

    public ContatoModel (ContatoModel entity){
        idContato = entity.getIdContato();
        contatoName = entity.getContatoName();
        contatoEmail = entity.getContatoEmail();
        contatoTelefone = entity.getContatoTelefone();
    }
}

