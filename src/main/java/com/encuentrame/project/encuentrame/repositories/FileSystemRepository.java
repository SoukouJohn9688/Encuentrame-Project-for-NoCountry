package com.encuentrame.project.encuentrame.repositories;

import com.encuentrame.project.encuentrame.entities.FileSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileSystemRepository extends JpaRepository<FileSystem,Long> {
    Optional<FileSystem> findByName(String fileName);

}
