package com.spring.changementserie.Service;

import com.spring.changementserie.Models.Rapport;
import java.util.List;
import java.util.Optional;

public interface RapportInterface {
  public Rapport createRapport(Rapport rapport);
  public Optional<Rapport> getByid(Integer idRapport);
  public List<Rapport> getAllRapport();
  void deleteRapport(Integer idRapport);
  public Rapport updateRapport(Rapport rapport,Integer idRapport);
}
