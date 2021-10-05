package com.example.musicsec;

import com.example.musicsec.service.UserRoleService;
import com.example.musicsec.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MusicDbAppInit implements CommandLineRunner {
private final UserService userService;
private final UserRoleService userRoleService;

    public MusicDbAppInit (UserService userService,UserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    @Override
    public void run (String... args) throws Exception {
this.userRoleService.initRoles();
this.userService.initBasicUsers();
    }
}
