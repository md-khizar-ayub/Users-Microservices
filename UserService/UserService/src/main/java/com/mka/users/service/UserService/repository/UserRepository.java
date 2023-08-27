package com.mka.users.service.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mka.users.service.UserService.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
