package com.div.ecommerce.ecommerce.repository;

import com.div.ecommerce.ecommerce.model.Image;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImageRepository extends JpaRepository<Image,Long> {
    @Modifying
    @Query(value = "UPDATE Image i SET i.data = :data WHERE i.id = :id",nativeQuery = true)
    void updateImageData(@Param("data") byte[] data, @Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO image (name, data) VALUES (:name, :data)",nativeQuery = true)
    void insertImage(@Param("name") String name, @Param("data") byte[] data);

    @Query("SELECT i FROM Image i WHERE i.id = :id")
    Image findImageById(@Param("id") Long id);
}
