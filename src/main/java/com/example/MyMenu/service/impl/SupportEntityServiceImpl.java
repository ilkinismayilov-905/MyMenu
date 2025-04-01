package com.example.MyMenu.service.impl;

import com.example.MyMenu.entity.SupportEntity;
import com.example.MyMenu.exceptions.EmptyListException;
import com.example.MyMenu.exceptions.NoEntityByIdException;
import com.example.MyMenu.repository.SupportEntityRepository;
import com.example.MyMenu.service.SupportEntityService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SupportEntityServiceImpl implements SupportEntityService {

    private final SupportEntityRepository supportEntityRepository;

    @Autowired
    public SupportEntityServiceImpl(SupportEntityRepository supportEntityRepository) {
        this.supportEntityRepository = supportEntityRepository;
    }

    @Override
    public void deleteById(Long id) throws NoEntityByIdException {
        if(supportEntityRepository.existsById(id)){
            supportEntityRepository.deleteById(id);
        }else {
            throw new NoEntityByIdException(id);
        }

    }

    @Override
    public SupportEntity save(SupportEntity entity) {
        return supportEntityRepository.save(entity);
    }

    @Override
    public Optional<SupportEntity> getById(Long id) throws NoEntityByIdException {
        Optional<SupportEntity> supportEntity = supportEntityRepository.findById(id);

        if(supportEntity.isEmpty()){
            throw new NoEntityByIdException(id);
        }

        return supportEntity;
    }

    @Override
    public List<SupportEntity> getAll() throws EmptyListException  {
        List<SupportEntity> list = supportEntityRepository.findAll();

        if(list.isEmpty()){
            throw new EmptyListException();
        }
        return list;
    }
}
