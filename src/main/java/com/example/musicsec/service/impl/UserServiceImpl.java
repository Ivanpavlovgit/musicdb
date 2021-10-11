package com.example.musicsec.service.impl;

import com.example.musicsec.model.entity.UserEntity;
import com.example.musicsec.model.serviceModels.UserRegisterServiceModel;
import com.example.musicsec.repository.UserRepository;
import com.example.musicsec.service.MusicDbUserService;
import com.example.musicsec.service.UserRoleService;
import com.example.musicsec.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final MusicDbUserService musicDbUserService;

    public UserServiceImpl (UserRepository userRepository,UserRoleService userRoleService,PasswordEncoder passwordEncoder,ModelMapper modelMapper,MusicDbUserService musicDbUserService) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.musicDbUserService = musicDbUserService;
    }

    @Override
    public void initBasicUsers () {
        if(this.userRepository.count ()==0){
        var user = new UserEntity ()
                .setName ("Sam1")
                .setFullname ("Sam1Sam")
                .setPassword (this.passwordEncoder.encode ("2222"))
                .setRoles (List.of (this.userRoleService.getRole ("USER")));
        var admin = new UserEntity ()
                .setName ("Froddo1")
                .setFullname ("Froddo1Froddo")
                .setPassword (this.passwordEncoder.encode ("1111"))
                .setRoles (List.of (this.userRoleService.getRole ("USER"),
                        this.userRoleService.getRole ("ADMIN")));
        this.userRepository.save (user);
        this.userRepository.save (admin);}
    }

    @Override
    public void registerAndLoginUser (UserRegisterServiceModel userRegisterServiceModel) {
        var user     = this.modelMapper.map (userRegisterServiceModel,UserEntity.class);
        var userRole = this.userRoleService.getRole ("USER");
        user.addRole (userRole);
        user.setName (userRegisterServiceModel.getUsername ());
        user.setPassword (this.passwordEncoder.encode (userRegisterServiceModel.getPassword ()));
        user = this.userRepository.save (user);
        UserDetails principal= this.musicDbUserService.loadUserByUsername (user.getName ());
        Authentication auth = new UsernamePasswordAuthenticationToken (
                principal,
                user.getPassword (),
                principal.getAuthorities ()
        );

        SecurityContextHolder.getContext ().setAuthentication (auth);
    }

    @Override
    public boolean userNameExists (String username) {
     return    this.userRepository.findByName (username).isPresent ();
    }

}
