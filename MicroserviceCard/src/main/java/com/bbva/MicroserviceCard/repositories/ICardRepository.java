package com.bbva.MicroserviceCard.repositories;

import com.bbva.MicroserviceCard.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardRepository extends JpaRepository<Card, Integer> {
}
