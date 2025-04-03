package com.example.MyMenu.config.database;


import com.example.MyMenu.entity.UserEntity;
import com.example.MyMenu.repository.UserEntityRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomAuthProvider(UserEntityRepository userEntityRepository, PasswordEncoder passwordEncoder) {
        this.userEntityRepository = userEntityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

//        Optional<UserEntity> optionalUser = Optional.of(userName);

        Optional<UserEntity> optionalUser = userEntityRepository.getByUsername(userName);

        if(!passwordEncoder.matches(password,optionalUser.get().getPassword())){
            try {
                throw new AuthenticationException("Invalid credentials") {};
            }catch (AuthenticationException e) {
                throw new RuntimeException(e);
            }
        }
        UserEntity user = optionalUser.get();
        return new UsernamePasswordAuthenticationToken(user,password, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
