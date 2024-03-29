package com.spring.changementserie.Service.impl;


import com.spring.changementserie.Models.Interface;
import com.spring.changementserie.Repository.InterfaceRepository;
import com.spring.changementserie.Service.InterInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterfaceService implements InterInterface {
    @Autowired
    private InterfaceRepository interfaceRepository;


    @Override
    public Interface createInterface(Interface interfaceObj) {
        return interfaceRepository.save(interfaceObj);
    }
    @Override
    public void deleteInterface(Integer idInterface) {
        interfaceRepository.deleteById(idInterface);
    }

    @Override
    public List<Interface> getAllInterface() {
        return interfaceRepository.findAll();
    }

    @Override
    public Interface updateInterface(Interface updatedInterface, Integer idInterface) {
        Optional<Interface> optionalInterface = interfaceRepository.findById(idInterface);

        if (optionalInterface.isPresent()) {
            Interface existingInterface = optionalInterface.get();

            if (updatedInterface.getEtat() != null) {
                existingInterface.setEtat(updatedInterface.getEtat());
            }

            if (updatedInterface.getNomInterface() != null) {
                existingInterface.setNomInterface(updatedInterface.getNomInterface());
            }

            if (updatedInterface.getQuantite() != null) {
                existingInterface.setQuantite(updatedInterface.getQuantite());
            }

            return interfaceRepository.save(existingInterface);
        }

        return null;
    }

    @Override
    public Optional<Interface> getCInterfaceById(Integer idInterface) {
        return interfaceRepository.findById(idInterface);
    }

}
