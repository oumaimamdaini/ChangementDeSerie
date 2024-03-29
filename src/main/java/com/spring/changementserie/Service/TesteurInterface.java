package com.spring.changementserie.Service;


import com.spring.changementserie.Models.Testeur;

import java.util.List;
import java.util.Optional;

public interface TesteurInterface
{
    void deleteTesteur(Integer idTesteur);
    public Testeur createTesteur(Testeur testeur);
    public List<Testeur> getAllTesteur();
    public Testeur updateTesteur(Testeur testeur,Integer idTesteur);
    public Optional<Testeur> getTesteurByid(Integer idTesteur);
}
