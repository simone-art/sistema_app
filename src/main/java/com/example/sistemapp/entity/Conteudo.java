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

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getPalavras() {
        return palavras;
    }

    public void setPalavras(int palavras) {
        this.palavras = palavras;
    }

    public int getCaracteres() {
        return caracteres;
    }

    public void setCaracteres(int caracteres) {
        this.caracteres = caracteres;
    }
}
