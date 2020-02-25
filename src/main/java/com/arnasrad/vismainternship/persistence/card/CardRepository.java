package com.arnasrad.vismainternship.persistence.card;

import com.arnasrad.vismainternship.model.entity.card.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
