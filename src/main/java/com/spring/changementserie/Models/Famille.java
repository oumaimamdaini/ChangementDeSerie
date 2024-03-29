package com.spring.changementserie.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Famille")
public class Famille implements Serializable {
    @Id
    @Column(name = "idFamille")
    @GeneratedValue
    private Integer idFamille;
    @Column(name = "nomFamille")
    private String nomFamille;


    @OneToMany(mappedBy = "famille")
    private List<Checklist> checklists;

}