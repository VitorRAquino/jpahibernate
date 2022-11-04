package br.com.loja.modelo;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;

@Embeddable
public class CategoriaId implements Serializable {

    private static final long serialVersionUID = -9739609563212528L;
    private String nome;
    private String tipo;


    public CategoriaId(){}

    public CategoriaId(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
