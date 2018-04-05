package de.michlb.sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.michlb.sample.domain.ApparelSku;

public interface ApparelSkuRepository extends JpaRepository<ApparelSku, Long> {
}
