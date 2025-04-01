package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.UserDetails;
import com.example.MyMenu.exceptions.*;
import com.example.MyMenu.repository.UserDetailsRepository;
import com.example.MyMenu.service.UserDetailsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public void deleteById(Long id) throws NoEntityByIdException {
        if(userDetailsRepository.existsById(id)){
            userDetailsRepository.deleteById(id);
        }else {
            throw new NoEntityByIdException(id);
        }
    }

    @Override
    public UserDetails save(UserDetails entity) throws ConfirmPasswordException {
        if(!Objects.equals(entity.getConfirmPassword(), entity.getPassword())){
            throw new ConfirmPasswordException();
        }
        return userDetailsRepository.save(entity);
    }

    @Override
    public Optional<UserDetails> getById(Long id) throws NoEntityByIdException {
        Optional<UserDetails> user = userDetailsRepository.findById(id);

        if(user.isEmpty()){
            throw new NoEntityByIdException(id);
        }
        return user;
    }

    @Override
    public List<UserDetails> getAll( ) throws EmptyListException {
        List<UserDetails> list = userDetailsRepository.findAll();

        if(list.isEmpty()){
            throw new EmptyListException();
        }
        return list;
    }

    public Optional<UserDetails> getUserByName(String name) throws NoUserByNameException{
        Optional<UserDetails> userDetails = userDetailsRepository.findUserByName(name);

        if(userDetails.isEmpty()){
            throw new NoUserByNameException(name);
        }
        return userDetails;
    }

    public Optional<UserDetails> getUserBySurname(String surname) throws NoUserBySurnameException {
        Optional<UserDetails> userDetails = userDetailsRepository.findUserBySurname(surname);

        if(userDetails.isEmpty()){
            throw new NoUserByNameException(surname);
        }
        return userDetails;
    }

    public Optional<UserDetails> getUserByEmail(String email) throws NoEntityByEmailException {
        Optional<UserDetails> userDetails = userDetailsRepository.findUserBySurname(email);

        if(userDetails.isEmpty()){
            throw new NoEntityByEmailException(email);
        }
        return userDetails;
    }
}
