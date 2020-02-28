package com.arnasrad.vismainternship.persistence.token;

import com.arnasrad.vismainternship.model.entity.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, String> {
}
