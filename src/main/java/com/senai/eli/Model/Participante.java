package com.senai.eli.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

    @Table(name = "participante")
    @Getter
    @Setter
    @Entity


public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "participantes")
    private List<Evento> eventos = new ArrayList<>();
}
