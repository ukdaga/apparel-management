package org.ukdaga.apparelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ukdaga.apparelmanagement.domain.Apparel;

public interface ApparelRepository extends JpaRepository<Apparel, Long> {
}
