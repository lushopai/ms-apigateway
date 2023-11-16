package com.techserv.arrivingservice.repository;

import com.techserv.arrivingservice.entity.Arriving;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArrivingRepository extends JpaRepository<Arriving,Long> {
}
