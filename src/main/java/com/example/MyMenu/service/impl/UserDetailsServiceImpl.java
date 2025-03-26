package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.UserDetails;
import com.example.MyMenu.repository.UserDetailsRepository;
import com.example.MyMenu.service.UserDetailsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public void deleteById(Long id) {
        if(userDetailsRepository.existsById(id)){
            userDetailsRepository.deleteById(id);
        }
    }

    @Override
    public UserDetails save(UserDetails entity) {
        return userDetailsRepository.save(entity);
    }

    @Override
    public Optional<UserDetails> getById(Long id) {
        Optional<UserDetails> user = userDetailsRepository.findById(id);

        if(user.isEmpty()){
            throw new RuntimeException("Error");
        }
        return user;
    }

    @Override
    public List<UserDetails> getAll() {
        return userDetailsRepository.findAll();
    }
}
