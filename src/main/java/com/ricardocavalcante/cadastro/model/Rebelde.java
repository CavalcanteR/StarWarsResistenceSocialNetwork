package com.ricardocavalcante.cadastro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Rebelde {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @Min(1)
    private int idade;

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    @NotBlank
    private String base;

    @NotNull
    private String genero;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="delacao",
            joinColumns={@JoinColumn(name="delator_id",
                    referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="traidor_id",
                    referencedColumnName="id")})
    @JsonIgnore
    private List<Rebelde> traidores = new ArrayList<>();


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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Rebelde(String nome, int idade, String genero, double latitude, double longitude, String base) {
        this.nome      = nome;
        this.idade     = idade;
        this.genero    = genero;
        this.latitude  = latitude;
        this.longitude = longitude;
        this.base      = base;
    }

    public void editarLocalizacao(double latitude, double longitude, String base) {
        this.latitude  = latitude;
        this.longitude = longitude;
        this.base      = base;
    }

    public void addTraidor(Rebelde traidor) throws Exception {


    }

}
