package com.encuentrame.project.encuentrame.repositories;

import com.encuentrame.project.encuentrame.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, UUID> {

    public MyUser findByName(String name);

    public MyUser findByEmail(String email);
}
