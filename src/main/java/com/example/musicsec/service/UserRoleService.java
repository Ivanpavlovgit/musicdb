package com.example.musicsec.service;

import com.example.musicsec.model.entity.UserRoleEntity;

public interface UserRoleService {
    void initRoles ();

    UserRoleEntity getRole (String role);
}
