package com.gcSpring.repository;

import com.gcSpring.domain.Gas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GasRepository extends JpaRepository<Gas, Long> {

}
