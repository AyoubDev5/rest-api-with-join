package com.restApi.crud.springbootdockerpostgres.controller;

import com.restApi.crud.springbootdockerpostgres.dto.Orderresponse;
import com.restApi.crud.springbootdockerpostgres.entity.Projet;
import com.restApi.crud.springbootdockerpostgres.repository.Projetrepository;
import com.restApi.crud.springbootdockerpostgres.repository.Tachesrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableJpaRepositories
public class Allcontroller {
    @Autowired
    private Projetrepository projetrepository;
    @Autowired
    private Tachesrepository tachesrepository;

    @PostMapping("/projets")
    public Projet addprojet(@RequestBody Projet projet){
        return projetrepository.save(projet);
    }

    @GetMapping("/projets-id")
    public ResponseEntity<List<Projet>> findAll(){
        return ResponseEntity.ok(projetrepository.findAll());
    }

    @GetMapping("projets/{id}")
    public ResponseEntity<Projet> findProjetById(@PathVariable(value = "id") Integer idProjet) {
        Projet projet = projetrepository.findById(idProjet).orElseThrow(
                () -> new ResouceNotFoundException("Projet not found" + idProjet));
        return ResponseEntity.ok().body(projet);
    }

    @PutMapping("projets/{id}")
    public ResponseEntity<Projet> Projet(@PathVariable(value = "id") Integer idProjet,
                                         @RequestBody Projet projetDetails) {
        Projet projet = projetrepository.findById(idProjet)
                .orElseThrow(() -> new ResouceNotFoundException("Projet not found for this id :: " + idProjet));
        projet.setNomProjet(projetDetails.getNomProjet());
        final Projet updatedProjet = projetrepository.save(projet);
        return ResponseEntity.ok(updatedProjet);

    }

    @DeleteMapping("projets/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable(value = "id") Integer idProjet) {
        Projet projet = projetrepository.findById(idProjet).orElseThrow(
                () -> new ResouceNotFoundException("Projet not found" + idProjet));
        projetrepository.delete(projet);
        return ResponseEntity.ok().build();
    }
}
