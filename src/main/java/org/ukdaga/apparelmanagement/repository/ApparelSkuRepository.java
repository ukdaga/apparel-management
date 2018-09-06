package org.ukdaga.apparelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ukdaga.apparelmanagement.domain.ApparelSku;

public interface ApparelSkuRepository extends JpaRepository<ApparelSku, Long> {
}
