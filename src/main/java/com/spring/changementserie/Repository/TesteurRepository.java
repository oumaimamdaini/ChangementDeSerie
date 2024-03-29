package com.spring.changementserie.Repository;

import com.spring.changementserie.Models.Testeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface TesteurRepository extends JpaRepository<Testeur,Integer> {}
