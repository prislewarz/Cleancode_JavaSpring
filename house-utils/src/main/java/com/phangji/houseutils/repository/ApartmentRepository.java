package com.phangji.houseutils.repository;

import com.phangji.houseutils.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Happy
 */

//데이터의 값을 써주거나, 읽어오는 기능을 하는 Repository(인터페이스)-JPA
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}
