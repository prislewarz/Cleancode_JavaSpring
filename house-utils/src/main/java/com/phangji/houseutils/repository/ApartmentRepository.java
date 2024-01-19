package com.phangji.houseutils.repository;

import com.phangji.houseutils.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Happy
 */
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}
