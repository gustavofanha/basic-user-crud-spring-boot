package com.fanha.basic_user_crud.service;

import com.fanha.basic_user_crud.domain.dto.UserRequest;
import com.fanha.basic_user_crud.domain.dto.UserResponse;
import com.fanha.basic_user_crud.domain.entity.User;
import com.fanha.basic_user_crud.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void createUser(UserRequest userRequest) {
        User newUser = new User();
        BeanUtils.copyProperties(userRequest, newUser);
        repository.save(newUser);
    }

    public List<UserResponse> findAllUsers() {
        List<User> userList = repository.findAll();
        return userList.stream().map(user -> new UserResponse(
                user.getId(),
                user.getName(),
                user.getDocument(),
                user.getEmail())).
                collect(Collectors.toList());
    }

    public UserResponse findUserById(Long id) {
        return repository.findById(id).map(user -> new UserResponse(
                user.getId(),
                user.getName(),
                user.getDocument(),
                user.getEmail()))
                .orElseThrow();
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public User updateUser(Long id, User dataUpdate) {
        var user = repository.getReferenceById(id);
        updateData(user, dataUpdate);
        return repository.save(user);
    }

    public void updateData(User oldData, User newData) {
        oldData.setName(newData.getName());
        oldData.setEmail(newData.getEmail());
        oldData.setDocument(newData.getDocument());
        oldData.setPassword(newData.getPassword());
    }
}
