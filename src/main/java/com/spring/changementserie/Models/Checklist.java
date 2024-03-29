package com.spring.changementserie.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Checklist")
@Builder
public class Checklist implements Serializable {
    @Id
    @Column(name = "idChecklist")
    @GeneratedValue
    private Integer idChecklist;
    @Column(name = "Titre")
    private String titre;
    @Column(name = "Outillage")
    private String outillage;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Date")
    private Date date;


    @ManyToOne
    @JoinColumn(name="id_famille")
    private Famille famille;

   @ManyToOne
   @JoinColumn(name = "id_Rapport")
   private Rapport rapport;

    @ManyToOne
    @JoinColumn(name = "id_Testeur")
    private Testeur testeur;

    @ManyToMany(mappedBy = "checklists")
    private Set<User> users;

    @OneToMany(mappedBy = "checklist")
    private List<Produit> produits;

    @ManyToOne
    @JoinColumn(name = "idChangementSerie")
    private ChangementSerie changementSerie;


}
