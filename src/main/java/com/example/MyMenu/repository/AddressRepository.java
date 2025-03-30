package com.example.MyMenu.repository;

import com.example.MyMenu.entity.Address;
import com.example.MyMenu.enums.AddressCity;
import com.example.MyMenu.enums.AddressDistrict;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    public List<Address> getByCity(AddressCity city);
    public List<Address> getByDistrict(AddressDistrict district);
}
