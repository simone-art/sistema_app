package com.example.sistemapp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;


@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy = "native")
    private long codigo;

    @Column
    //@NotBlank
   //@Size(min= 3, max = 50, message = "O campo não cumpre a regra de tamanho")
//    @NotEmpty
    private String Nome;

    @Column
    //@NotBlank
//    @NotEmpty
    private String Sobrenome;

    @Column(unique = true)
    //@NotBlank
    //@Email
//    @NotEmpty
//    @Email
    private String email;

    @Column
    //@NotBlank
    //@NotEmpty
//    @NotNull
    private String senha;

    @Transient
    //@NotEmpty
    //@NotBlank
//    @NotNull
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
