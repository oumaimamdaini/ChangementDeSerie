package com.spring.changementserie.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Produit")
public class Produit {
    @Id
    @Column(name = "idProduit")
    @GeneratedValue
    private Integer idProduit;
    @Column(name="nomProduit")
    private String nomProduit;

    @ManyToOne
    @JoinColumn(name = "checklist_id")
    private Checklist checklist;


}