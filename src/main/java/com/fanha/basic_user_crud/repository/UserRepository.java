package com.fanha.basic_user_crud.repository;

import com.fanha.basic_user_crud.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
