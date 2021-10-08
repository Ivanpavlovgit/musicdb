package com.example.musicsec.service.impl;

import com.example.musicsec.model.entity.UserRoleEntity;
import com.example.musicsec.model.enums.UserRole;
import com.example.musicsec.repository.UserRoleRepository;
import com.example.musicsec.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl (UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void initRoles () {
        var user=new UserRoleEntity ().setRole (UserRole.USER);
        this.userRoleRepository.save(user);
        var admin=new UserRoleEntity ().setRole (UserRole.ADMIN);
        this.userRoleRepository.save(admin);
    }

    @Override
    public UserRoleEntity getRole (String roleName) {
        return this.userRoleRepository.findByRole (UserRole.valueOf (roleName)).orElse (null);
    }
}
