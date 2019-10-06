package com.ricardocavalcante.cadastro.controller;

import com.ricardocavalcante.cadastro.model.Rebelde;
import com.ricardocavalcante.cadastro.repository.RebeldeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping({"/rebelde"})
public class RebeldeController {

    private RebeldeRepository repository;

    RebeldeController(RebeldeRepository rebeldeRepository) {
        this.repository = rebeldeRepository;
    }

    //Selecionar o rebelde
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    //Criar rebelde
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Rebelde rebelde){
        Rebelde novo = repository.save(rebelde);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{idDelator}/delatar/{idTraidor}")
    public ResponseEntity<?> delatar(@PathVariable Long idDelator,
                                     @PathVariable Long idTraidor) {
        return repository.findById(idDelator)
        .map(delator ->repository.findById(idTraidor)
            .map(traidor -> {
                try {
                    delator.addTraidor(traidor);
                } catch (Exception e) {
                    return ResponseEntity.badRequest().body(Collections.singletonMap("response", e.getMessage()));
                }
                Rebelde delatorAtualizado = repository.save(delator);
                return ResponseEntity.ok().body(Collections.singletonMap("response", "A registẽncia agradece."));
            }).orElse(ResponseEntity.notFound().build())
        ).orElse(ResponseEntity.notFound().build());
    }


}
