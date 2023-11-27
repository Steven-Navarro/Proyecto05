package com.bbva.MicroservicePurchasing.repositories;

import com.bbva.MicroservicePurchasing.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasingRepository extends JpaRepository<Purchase, Long> {
}
