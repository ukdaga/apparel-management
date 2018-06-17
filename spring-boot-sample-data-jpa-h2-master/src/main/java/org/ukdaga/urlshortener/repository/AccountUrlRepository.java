package org.ukdaga.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ukdaga.urlshortener.domain.AccountUrl;

public interface AccountUrlRepository extends JpaRepository<AccountUrl , Long> {

}
