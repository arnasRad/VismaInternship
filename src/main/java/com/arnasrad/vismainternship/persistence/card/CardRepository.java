package com.arnasrad.vismainternship.persistence.card;

import com.arnasrad.vismainternship.model.card.Card;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cards", path = "cards")
public interface CardRepository extends PagingAndSortingRepository<Card, String> {
}
