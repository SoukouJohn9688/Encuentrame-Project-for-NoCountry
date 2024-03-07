package com.encuentrame.project.encuentrame.repositories;

import com.encuentrame.project.encuentrame.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StorageRepository extends JpaRepository<Image,Long> {

    Optional<Image> findByName(String fileName);
}
