package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.UserEntity;
import com.example.MyMenu.repository.UserEntityRepository;
import com.example.MyMenu.service.UserEntityService;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserEntityServiceImpl implements UserEntityService {

    private final UserEntityRepository userEntityRepository;

    @Autowired
    public UserEntityServiceImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }



    @Override
    public void deleteById(Long id) {
        if(userEntityRepository.existsById(id)){
            userEntityRepository.deleteById(id);
        }

    }

    @Override
    public UserEntity save(UserEntity entity) {
        return userEntityRepository.save(entity);
    }

    @Override
    public Optional<UserEntity> getById(Long id) {
        Optional<UserEntity> user = userEntityRepository.findById(id);

        if(user.isEmpty()){
            throw new RuntimeException("There is no user");
        }
        return user;
    }

    @Override
    public List<UserEntity> getAll() {
        return userEntityRepository.findAll();
    }

    public Optional<UserEntity> getByUsername(String username){
        Optional<UserEntity> user = userEntityRepository.getByUsername(username);

        if(user.isEmpty()){
            throw new RuntimeException("Error");
        }
        return user;
    }

    public Optional<UserEntity> getByEmail(String email){
        Optional<UserEntity> user = userEntityRepository.getByEmail(email);

        if(user.isEmpty()){
            throw new RuntimeException("Error");
        }
        return user;
    }
}
