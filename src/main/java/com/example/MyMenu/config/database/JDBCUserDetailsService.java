package com.example.MyMenu.config.database;

import com.example.MyMenu.entity.UserEntity;
import com.example.MyMenu.repository.UserEntityRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JDBCUserDetailsService implements UserDetailsService {

    private final UserEntityRepository userEntityRepository;

    public JDBCUserDetailsService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user =userEntityRepository.getByUsername(username);

        return org.springframework.security.core.userdetails.User
                .withUsername(user.get().getUsername())
                .password(user.get().getPassword())
                .roles("USER")
                .build();
    }
}
