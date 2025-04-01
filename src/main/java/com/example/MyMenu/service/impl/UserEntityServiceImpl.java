package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.UserEntity;
import com.example.MyMenu.exceptions.EmptyListException;
import com.example.MyMenu.exceptions.NoEntityByEmailException;
import com.example.MyMenu.exceptions.NoEntityByIdException;
import com.example.MyMenu.exceptions.NoEntityByNameException;
import com.example.MyMenu.repository.UserEntityRepository;
import com.example.MyMenu.service.UserEntityService;
import jakarta.transaction.Transactional;
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
    public void deleteById(Long id) throws NoEntityByIdException{
        if(userEntityRepository.existsById(id)){
            userEntityRepository.deleteById(id);
        }else {
            throw new NoEntityByIdException(id);
        }

    }

    @Override
    public UserEntity save(UserEntity entity) {
        return userEntityRepository.save(entity);
    }

    @Override
    public Optional<UserEntity> getById(Long id) throws NoEntityByIdException {
        Optional<UserEntity> user = userEntityRepository.findById(id);

        if(user.isEmpty()){
            throw new NoEntityByIdException(id);
        }
        return user;
    }

    @Override
    public List<UserEntity> getAll() throws EmptyListException {
        List<UserEntity> list = userEntityRepository.findAll();

        if(list.isEmpty()){
            throw new EmptyListException();
        }
        return list;
    }

    public Optional<UserEntity> getByUsername(String username) throws NoEntityByNameException{
        Optional<UserEntity> user = userEntityRepository.getByUsername(username);

        if(user.isEmpty()){
            throw new NoEntityByNameException(username);
        }
        return user;
    }

    public Optional<UserEntity> getByEmail(String email) throws NoEntityByEmailException{
        Optional<UserEntity> user = userEntityRepository.getByEmail(email);

        if(user.isEmpty()){
            throw new NoEntityByEmailException(email);
        }
        return user;
    }
}
