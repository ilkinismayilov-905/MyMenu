package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.Address;
import com.example.MyMenu.enums.AddressCity;
import com.example.MyMenu.enums.AddressDistrict;
import com.example.MyMenu.exceptions.EmptyListException;
import com.example.MyMenu.exceptions.NoAddressByCityException;
import com.example.MyMenu.exceptions.NoAddressByDistrictException;
import com.example.MyMenu.exceptions.NoEntityByIdException;
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
    public void deleteById(Long id) throws NoEntityByIdException {
        if(addressRepository.existsById(id)){
            addressRepository.deleteById(id);
        }else {
            throw new NoEntityByIdException(id);
        }
    }

    @Override
    public Address save(Address entity) {
        return addressRepository.save(entity);
    }

    @Override
    public Optional<Address> getById(Long id) throws NoEntityByIdException {
        Optional<Address> adress = addressRepository.findById(id);

        if(adress.isEmpty()){
            throw new NoEntityByIdException(id);
        }
        return adress;
    }

    @Override
    public List<Address> getAll() throws EmptyListException {

        List<Address> list = addressRepository.findAll();
        if(list.isEmpty()){
            throw new EmptyListException();
        }
        return list;

    }

    public List<Address> getByCity(AddressCity city) throws NoAddressByCityException {
        List<Address> address = addressRepository.getByCity(city);

        if(address.isEmpty()){
            throw new NoAddressByCityException(city);
        }
        return address;
    }

    public List<Address> getByDistrict(AddressDistrict district) throws NoAddressByDistrictException {
        List<Address> address = addressRepository.getByDistrict(district);

        if(address.isEmpty()){
            throw new NoAddressByDistrictException(district);
        }
        return address;
    }
}
