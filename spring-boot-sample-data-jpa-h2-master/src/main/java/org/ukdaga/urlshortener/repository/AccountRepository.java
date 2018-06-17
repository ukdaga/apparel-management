package org.ukdaga.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ukdaga.urlshortener.domain.Account;

public interface AccountRepository extends JpaRepository<Account , Long> {

	public Account findByName(String name);

}
