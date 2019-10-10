package com.ricardocavalcante.cadastro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Item {
    @Id
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    @Min(1)
    private int valor;

    public Item(String nome, int valor) {
        this.nome  = nome;
        this.valor = valor;
    }

    public static int valorInventario(ArrayList<Item> inventario) {
        return inventario.stream().mapToInt(item -> item.getValor()).sum();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}