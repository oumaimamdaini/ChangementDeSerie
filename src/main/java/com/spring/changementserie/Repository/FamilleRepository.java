package com.spring.changementserie.Repository;

import com.spring.changementserie.Models.Famille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface FamilleRepository extends JpaRepository<Famille,Integer> {}