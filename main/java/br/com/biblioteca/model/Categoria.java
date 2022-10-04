package br.com.biblioteca.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataCadastro = LocalDate.now();


    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria() {

    }

    public String getNome() {
        return nome;
    }
}

