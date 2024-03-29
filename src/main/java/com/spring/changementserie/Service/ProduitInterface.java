package com.spring.changementserie.Service;

import com.spring.changementserie.Models.ChangementSerie;
import com.spring.changementserie.Models.Famille;
import com.spring.changementserie.Models.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitInterface {
    void deleteProduit(Integer idProduit);
    public Produit createProduit(Produit produit);
    public List<Produit> getAllProduit();
    public Produit updateProduit(Produit produit, Integer idProduit);
    public Optional<Produit> getProduitById(Integer idProduit);
}
