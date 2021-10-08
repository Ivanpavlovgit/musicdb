package com.example.musicsec.service;

import com.example.musicsec.model.serviceModels.UserRegisterServiceModel;

public interface UserService {
    void initBasicUsers ();
    void registerAndLoginUser(UserRegisterServiceModel userRegisterServiceModel);
}
