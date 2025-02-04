package com.fanha.basic_user_crud.service;

import com.fanha.basic_user_crud.domain.dto.UserRequest;
import com.fanha.basic_user_crud.domain.entity.User;
import com.fanha.basic_user_crud.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void createUser(UserRequest userRequest) {
        User newUser = new User();
        BeanUtils.copyProperties(userRequest, newUser);
        repository.save(newUser);
    }
}
