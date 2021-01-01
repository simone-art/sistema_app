package com.example.sistemapp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy = "native")
    private long codigo;

    @Column
    @NotBlank
    //@NotNull(message = "Nome não pode ser nulo")
    //@NotEmpty(message="Nome não pode ser vazio")
    private String Nome;

    @Column
    @NotBlank
    //@NotNull(message = "Sobrenome não pode ser nulo")
    //@NotEmpty(message="Sobrenome não pode ser vazio")
    private String Sobrenome;

    @Column(unique = true)
    @NotBlank
    //@NotNull(message = "Email não pode ser nulo")
    //@NotEmpty(message="Email não pode ser vazio")
    private String email;

    @Column
    @NotBlank
    //@NotNull(message = "Senha não pode ser nula")
    //@NotEmpty(message="Senha não pode ser vazia")
    private String senha;

    @Transient
    //@NotEmpty(message="Senha não foi confirmada. Por favor digite novamente")
    private String confirmaSenha;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
}
