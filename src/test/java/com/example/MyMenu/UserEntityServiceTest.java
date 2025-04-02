package com.example.MyMenu;

import com.example.MyMenu.entity.UserEntity;
import com.example.MyMenu.repository.UserEntityRepository;
import com.example.MyMenu.service.impl.UserEntityServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserEntityServiceTest {

    @Mock
    private UserEntityRepository userEntityRepository;

    @InjectMocks
    private UserEntityServiceImpl userEntityService;

    @Test
    void getAll(){
        List<UserEntity> userEntities = Arrays.asList(
                new UserEntity(1L,"ILkin","ilkin@gmail.com","il1234")
        );

        when(userEntityRepository.findAll()).thenReturn(userEntities);

        List<UserEntity> list = userEntityService.getAll();

        assertFalse(list.isEmpty());
        assertEquals(1,list.size());
        verify(userEntityRepository,times(1)).findAll();
    }
}
