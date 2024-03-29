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
@Table(name = "Rapport")
public class Rapport implements Serializable{

        @Id
        @Column(name = "idRapport")
        @GeneratedValue
        private Integer idRapport;
        @Column(name = "descRapport")
           private String descRapport;

   /*@OneToMany(mappedBy = "rapport")
    private List<Checklist> checklist;
    @OneToMany(mappedBy = "famille")
    private List<Rapport> rapport;*/

    @OneToMany(mappedBy = "rapport")
    private List<Checklist> checklists;

    }


