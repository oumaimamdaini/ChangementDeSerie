package com.spring.changementserie.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Interface")
@Builder
public class Interface implements Serializable {

    @Id
    @GeneratedValue
    private Integer idInterface;
    @Column(name="nomInterface")
    private String nomInterface;
    @Column(name = "quantité")
    private Long quantite;
    @Enumerated(EnumType.STRING)
    private Etat etat;

    @ManyToOne
    @JoinColumn(name = "testeur_id")
    private Testeur testeur;

}
