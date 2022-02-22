package com.restApi.crud.springbootdockerpostgres.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Projet {
    @Id
    @SequenceGenerator(
            name = "projet_id_sequence",
            sequenceName = "projet_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "projet_id_sequence"
    )
    private int idProjet;
    @OneToMany(targetEntity = Taches.class,cascade = CascadeType.ALL)
    /*@JoinColumn(name = "idTache_fk",referencedColumnName = "idTaches")*/
    private List<Taches> tache;
    private String nomProjet;
    private Date dateDebut;
    private Date dateFin;

    public Projet(List<Taches> tache) {
        this.tache = tache;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
