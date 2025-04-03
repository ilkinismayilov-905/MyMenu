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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    void addTest(){
        UserEntity user = new UserEntity(1L,"Ilkin","ilkin@gmail.com","il1234");

        when(userEntityRepository.save(any(UserEntity.class))).thenReturn(user);

        UserEntity createdUser =userEntityService.save(user);

        assertNotNull(createdUser);
        assertEquals("Ilkin",createdUser.getUsername());
        assertEquals(1L,createdUser.getId());
        assertEquals("ilkin@gmail.com",createdUser.getEmail());
        assertEquals("il1234",createdUser.getPassword());
        verify(userEntityRepository,times(1)).save(user);
    }

    @Test
    void getByIdTest(){
        Long userId = 1L;
        UserEntity user = new UserEntity(1L,"Ilkin","ilkin@gmail.com","il1234");

        when(userEntityRepository.findById(userId)).thenReturn(Optional.of(user));

        Optional<UserEntity> findedUser = userEntityService.getById(userId);

        assertNotNull(findedUser);
        assertEquals("Ilkin",findedUser.get().getUsername());
        assertEquals(1L,findedUser.get().getId());
        assertEquals("ilkin@gmail.com",findedUser.get().getEmail());
        assertEquals("il1234",findedUser.get().getPassword());
        verify(userEntityRepository,times(1)).findById(userId);


    }
}
