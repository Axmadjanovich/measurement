package com.gcSpring.repository;

import com.gcSpring.domain.Water;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterRepository extends JpaRepository<Water, Long> {
}
