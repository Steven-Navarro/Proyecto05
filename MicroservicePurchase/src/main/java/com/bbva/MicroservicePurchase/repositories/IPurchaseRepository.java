package com.bbva.MicroservicePurchase.repositories;

import com.bbva.MicroservicePurchase.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseRepository extends JpaRepository<Purchase, Integer> {
}
