package com.testing.spring.repositories;

import base.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Cafe, Long> {
}
