package org.ukdaga.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ukdaga.urlshortener.domain.Apparel;

public interface ApparelRepository extends JpaRepository<Apparel, Long> {
}
