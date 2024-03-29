package com.spring.changementserie.Service.impl;

import com.spring.changementserie.Models.ChangementSerie;
import com.spring.changementserie.Models.Produit;
import com.spring.changementserie.Repository.ProduitRepository;
import com.spring.changementserie.Service.ProduitInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService implements ProduitInterface {
    @Autowired
    private ProduitRepository produitRepository;
    @Override
    public void deleteProduit(Integer idProduit) {

        produitRepository.deleteById(idProduit);
    }

    @Override
    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> getAllProduit() {

        return produitRepository.findAll();
    }

    @Override
    public Produit updateProduit(Produit updatedProduit, Integer idProduit) {
        Optional<Produit> optionalProduit = produitRepository.findById(idProduit);

        if (optionalProduit.isPresent()) {
            Produit existingProduit = optionalProduit.get();

            if (updatedProduit.getNomProduit() != null) {
                existingProduit.setNomProduit(updatedProduit.getNomProduit());
            }

            return produitRepository.save(existingProduit);
        }

        return null;
    }


    @Override
    public Optional<Produit> getProduitById(Integer idProduit) {
        return produitRepository.findById(idProduit);
    }
}

