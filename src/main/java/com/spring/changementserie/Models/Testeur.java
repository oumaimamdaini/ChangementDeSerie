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
@Table(name = "Testeur")
public class Testeur implements Serializable {
    @Id
    @Column(name = "idTesteur")
    @GeneratedValue
    private Integer idTesteur;

    @Column(name = "nomTesteur")
    private String nomTesteur;

    @Column(name = "qteTesteur")
    private Integer qteTesteur;

    @Column(name = "UF")
    private String UF;

    @Column(name = "ligneCMS2")
    private String ligneCMS2;

    @Column(name = "Atelier")
    private String Atelier;

    @OneToMany(mappedBy = "testeur")
    private List<Checklist> checklists;

    @OneToMany(mappedBy = "testeur")
    private List<Interface> interfaces;

}
