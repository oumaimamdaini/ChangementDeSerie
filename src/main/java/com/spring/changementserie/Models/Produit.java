package com.spring.changementserie.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduit;
    @Column(name="nomProduit")
    private String nomProduit;

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "checklist_id")
    @JsonIgnore
    private Checklist checklist;


}