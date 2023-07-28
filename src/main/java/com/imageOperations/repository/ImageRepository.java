package com.imageOperations.repository;

import com.imageOperations.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    void save(ImageEntity imageEntity);

    Optional<Object> findById(Long id);
}
