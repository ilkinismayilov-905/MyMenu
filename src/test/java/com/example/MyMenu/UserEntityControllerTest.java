//package com.example.MyMenu;
//
//import com.example.MyMenu.controller.UserEntityController;
//import com.example.MyMenu.entity.UserEntity;
//import com.example.MyMenu.service.impl.UserEntityServiceImpl;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.swagger.v3.oas.annotations.Operation;
//import org.apache.catalina.User;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.MediaType;
//import org.mockito.ArgumentCaptor;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@AutoConfigureMockMvc
//@WebMvcTest(UserEntityController.class)
//public class UserEntityControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private UserEntityServiceImpl userEntityServiceImpl;
//
//    @InjectMocks
//    private UserEntityController userEntityController;
//
//    @BeforeEach
//    void setup(){
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void getAllUserEntities() throws Exception{
//        List<UserEntity> userEntities = Arrays.asList(
//                new UserEntity(1L,"Ilkin","ilkin@gmail.com","il1234"),
//                new UserEntity(2L,"Atabay","Atabay123@gmail.com","a1234")
//        );
//
//        when(userEntityServiceImpl.getAll()).thenReturn(userEntities);
//
//        mockMvc.perform(get("/login/getAll")
//                .contentType(String.valueOf(MediaType.APPLICATION_JSON)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.size()").value(userEntities.size()))
//                .andExpect(jsonPath("$[0].id").value(1L))
//                .andExpect(jsonPath("$[0].username").value("Ilkin"))
//                .andExpect(jsonPath("$[0].email").value("ilkin@gmail.com"))
//                .andExpect(jsonPath("$[0].password").value("il1234"))
//                .andExpect(jsonPath("$[1].id").value(2L))
//                .andExpect(jsonPath("$[1].username").value("Atabay"))
//                .andExpect(jsonPath("$[1].email").value("Atabay123@gmail.com"))
//                .andExpect(jsonPath("$[1].password").value("a1234"));
//
//    }
//
//    @Test
//    void addNewUserTest() throws Exception{
//        UserEntity user = new UserEntity(1L,"Ilkin","ilkin@gmail.com","il1234");
//
//        String userJson = objectMapper.writeValueAsString(user);
//
//        mockMvc.perform(post("/login/add")
//                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
//                        .accept(String.valueOf(MediaType.APPLICATION_JSON))
//                        .content(userJson))
//                .andExpect(status().isOk());
//
//
//        verify(userEntityServiceImpl, times(1)).save(any(UserEntity.class));
//    }
//
//    @Test
//    void getByUsername() throws Exception{
//        String username = "Ilkin";
//        UserEntity user = new UserEntity(1L,"Ilkin","ilkin@gmail.com","il1234");
//
//        when(userEntityServiceImpl.getByUsername(username)).thenReturn(Optional.of(user));
//
//        mockMvc.perform(get("/login/username/{username}",username)
//                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
//                .accept(String.valueOf(MediaType.APPLICATION_JSON)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1L))
//                .andExpect(jsonPath("$.username").value(username))
//                .andExpect(jsonPath("$.email").value("ilkin@gmail.com"))
//                .andExpect(jsonPath("$.password").value("il1234"));
//
//        verify(userEntityServiceImpl,times(1)).getByUsername(username);
//    }
//
//    @Test
//    void getById() throws Exception{
//        Long id = 1L;
//        UserEntity user = new UserEntity(1L,"Ilkin","ilkin@gmail.com","il1234");
//
//        when(userEntityServiceImpl.getById(id)).thenReturn(Optional.of(user));
//
//        mockMvc.perform(get("/login/id/{id}",id)
//                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
//                .accept(String.valueOf(MediaType.APPLICATION_JSON)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(id))
//                .andExpect(jsonPath("$.username").value("Ilkin"))
//                .andExpect(jsonPath("$.email").value("ilkin@gmail.com"))
//                .andExpect(jsonPath("$.password").value("il1234"));
//
//        verify(userEntityServiceImpl,times(1)).getById(id);
//    }
//}
