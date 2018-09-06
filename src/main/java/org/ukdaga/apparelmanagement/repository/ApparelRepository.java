package org.ukdaga.apparelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ukdaga.apparelmanagement.domain.Apparel;

/*@Repository*/
public interface ApparelRepository extends JpaRepository<Apparel, Long> {
}
