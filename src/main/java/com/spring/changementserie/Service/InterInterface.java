package com.spring.changementserie.Service;

import com.spring.changementserie.Models.Famille;
import com.spring.changementserie.Models.Interface;

import java.util.List;
import java.util.Optional;

public interface InterInterface {
    public void deleteInterface(Integer idInterface);
    public Interface createInterface(Interface interfaceObj);
    public List<Interface> getAllInterface();
    public Interface updateInterface(Interface interfaceObj, Integer idInterface);
    public Optional<Interface> getCInterfaceById(Integer idInterface);

}
