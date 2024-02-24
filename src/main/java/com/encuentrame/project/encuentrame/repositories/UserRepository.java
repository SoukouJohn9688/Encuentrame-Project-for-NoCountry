package com.encuentrame.project.encuentrame.repositories;

import com.encuentrame.project.encuentrame.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    public User findByName(String name);
}
