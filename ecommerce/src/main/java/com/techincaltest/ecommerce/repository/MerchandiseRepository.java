package com.techincaltest.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techincaltest.ecommerce.model.MerchandiseModel;

@Repository
public interface MerchandiseRepository extends JpaRepository<MerchandiseModel, Long> {
	Optional<MerchandiseModel> findById(Long id);
	void deleteById(Long id);
}
