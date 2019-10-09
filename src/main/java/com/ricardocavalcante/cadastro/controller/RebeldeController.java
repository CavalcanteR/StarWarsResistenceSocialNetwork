package com.ricardocavalcante.cadastro.controller;

import com.ricardocavalcante.cadastro.model.Rebelde;
import com.ricardocavalcante.cadastro.repository.RebeldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/rebeldes"})
public class RebeldeController {

    @Autowired
    private RebeldeRepository repositorio;

    @PostMapping
    public Rebelde adicionar(@Valid @RequestBody Rebelde rebelde) {
        return repositorio.save(rebelde);
    }

    @GetMapping
    public List<Rebelde> listar() {
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Long id) {
        Optional<Rebelde> rebelde = repositorio.findById(id);

        if(rebelde==null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(rebelde);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> editar(@PathVariable Long id, @RequestBody Rebelde rebelde) {
        return repositorio.findById(id)
                .map(retorno -> {
                    retorno.editarLocalizacao(rebelde.getLatitude(),rebelde.getLongitude(),rebelde.getBase());
                    Rebelde atualizado = repositorio.save(retorno);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }



}
