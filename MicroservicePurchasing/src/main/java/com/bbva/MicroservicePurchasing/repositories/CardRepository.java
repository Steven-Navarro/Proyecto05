package com.bbva.MicroservicePurchasing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasingRepository extends JpaRepository<Card, Long> {
}
