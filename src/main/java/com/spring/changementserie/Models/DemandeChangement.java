package com.spring.changementserie.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DemandeChangement")
public class DemandeChangement implements Serializable {
    @Id
    @Column(name = "idDemandeChangement")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDemandeChangement;
    @Column(name = "DescDemandeChangement")
    private String DescDemandeChangement;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
