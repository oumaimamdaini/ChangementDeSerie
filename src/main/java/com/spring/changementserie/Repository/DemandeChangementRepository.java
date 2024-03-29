package com.spring.changementserie.Repository;

import com.spring.changementserie.Models.DemandeChangement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface DemandeChangementRepository extends JpaRepository<DemandeChangement,Integer> {
}
