package org.ukdaga.apparelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ukdaga.apparelmanagement.domain.Account;

public interface AccountRepository extends JpaRepository<Account , Long> {

	public Account findByName(String name);

}
