package com.ricardocavalcante.cadastro.controller;

import com.ricardocavalcante.cadastro.model.Denuncias;
import com.ricardocavalcante.cadastro.model.Rebelde;
import com.ricardocavalcante.cadastro.repository.DenunciasRepository;
import com.ricardocavalcante.cadastro.repository.RebeldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping({"/rebeldes"})
public class RebeldeController {

    @Autowired
    private RebeldeRepository repositorio;

    @Autowired
    private DenunciasRepository  repositorioTraidor;

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

    @GetMapping("/{delator}/denunciar/{traidor}")
    public ResponseEntity<?> denunciar(@PathVariable Long delator, @PathVariable Long traidor) {
        Optional<Rebelde> rebeldeDelator = repositorio.findById(delator);
        if(rebeldeDelator==null) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("response","Para deunuciar precisa ser um rebelde"));
        }

        Optional<Rebelde> rebeldeTraidor = repositorio.findById(traidor);
        if(rebeldeTraidor==null) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("response","Apenas rebeldes podem ser denunciados, rebelde não encontrado."));
        }

        Denuncias denuncia = new Denuncias();
        denuncia.denunciar(delator,traidor);

        repositorioTraidor.save(denuncia);

        return ResponseEntity.ok().body(Collections.singletonMap("response","Denuncia realizada com sucesso."));
    }



}
