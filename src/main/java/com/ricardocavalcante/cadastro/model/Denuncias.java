package com.ricardocavalcante.cadastro.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Denuncias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long delator;

    @NotNull
    private Long rebelde;

    public void denunciar(Long delator, Long rebelde) {
        this.delator = delator;
        this.rebelde = rebelde;
    }

}
