package com.div.ecommerce.ecommerce.repository;

import com.div.ecommerce.ecommerce.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
}
