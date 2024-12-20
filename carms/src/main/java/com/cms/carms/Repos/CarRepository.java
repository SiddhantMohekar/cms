package com.cms.carms.Repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.carms.Entity.Car;

public interface CarRepository extends JpaRepository<Car,Long> {
    Optional<Car> findById(Long id);

}
