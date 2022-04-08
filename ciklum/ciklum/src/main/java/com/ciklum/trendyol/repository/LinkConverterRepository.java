package com.ciklum.trendyol.repository;

import com.ciklum.trendyol.domain.LinkConverterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository required to perform CRUD operation on the database with links of different types
 */
@Repository
public interface LinkConverterRepository extends JpaRepository<LinkConverterEntity, UUID> {
}
