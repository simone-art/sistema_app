package com.example.sistemapp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Conteudo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy = "native")
    private long codigo;

    @Column
    private String conteudo;
    @Column
    private int palavras;
    @Column
    private int caracteres;
}
