package com.spring.changementserie.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Changement_Serie")
@Builder
public class ChangementSerie {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Integer idChserie;
    @Column(name = "Description")
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Date")
    private Date dateChangement;

    @OneToMany(mappedBy = "changementSerie")
    private List<Checklist> checklists;
}
