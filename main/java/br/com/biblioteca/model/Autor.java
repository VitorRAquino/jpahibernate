package br.com.biblioteca.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataCadastro = LocalDate.now();

    public Autor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


    public Autor() {

    }

}
