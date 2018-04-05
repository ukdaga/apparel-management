package de.michlb.sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.michlb.sample.domain.Apparel;

public interface ApparelRepository extends JpaRepository<Apparel, Long> {
}
