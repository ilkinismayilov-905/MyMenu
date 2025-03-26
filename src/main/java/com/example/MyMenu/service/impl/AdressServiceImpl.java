package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.Address;
import com.example.MyMenu.repository.AddressRepository;
import com.example.MyMenu.service.AddressService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AdressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public void deleteById(Long id) {
        if(addressRepository.existsById(id)){
            addressRepository.deleteById(id);
        }
    }

    @Override
    public Address save(Address entity) {
        return addressRepository.save(entity);
    }

    @Override
    public Optional<Address> getById(Long id) {
        Optional<Address> adress = addressRepository.findById(id);

        if(adress.isEmpty()){
            throw new RuntimeException("Error");
        }
        return adress;
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }
}
