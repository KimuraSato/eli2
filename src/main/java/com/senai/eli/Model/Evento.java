package com.senai.eli.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "evento")
@Entity
@Getter
@Setter
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "ip")
    private String ip;

    @Column(name = "valor")
    @ColumnDefault("0")
    private double valor = 0;

    @Column(name = "banner")
    private String banner;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "aprovado", nullable = false)
    @ColumnDefault("false")
    private boolean aprovado = false;

    @Column(name = "indexador")
    private String indexador;

    @Column(name = "responsavel", nullable = false)
    private String responsavel;

    @Column(name = "cronograma", nullable = false)
    private String cronograma;

    @ManyToMany
    @JoinTable(name = "evento_calendario")
    private List<Calendario> calendarios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;

    @ManyToMany
    @JoinTable(name = "evento_grupo")
    private List<GrupoTrabalho> grupos = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "categorias")
    private List<Categoria> categorias = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "relatorios")
    private List<Relatorio> relatorios = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "participantes")
    private List<Participante> participantes = new ArrayList<>();

    @Column(name = "data")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

}
