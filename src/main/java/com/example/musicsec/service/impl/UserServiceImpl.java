package com.example.musicsec.service.impl;

import com.example.musicsec.model.entity.UserEntity;
import com.example.musicsec.model.repository.UserRepository;
import com.example.musicsec.service.UserRoleService;
import com.example.musicsec.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl (UserRepository userRepository,UserRoleService userRoleService,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void initBasicUsers () {
        var user = new UserEntity ()
                .setName ("Sam1")
                .setPassword (this.passwordEncoder.encode ("2222"))
                .setRoles (List.of (this.userRoleService.getRole ("USER")));
        var admin = new UserEntity ()
                .setName ("Froddo1")
                .setPassword (this.passwordEncoder.encode ("1111"))
                .setRoles (List.of (this.userRoleService.getRole ("USER"),
                        this.userRoleService.getRole ("ADMIN")));
        this.userRepository.save (user);
        this.userRepository.save (admin);
    }
}
