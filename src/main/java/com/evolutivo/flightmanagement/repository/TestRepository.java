package com.evolutivo.flightmanagement.repository;

import com.evolutivo.flightmanagement.domain.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Long> {}