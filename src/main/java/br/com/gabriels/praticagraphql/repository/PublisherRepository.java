package br.com.gabriels.praticagraphql.repository;

import br.com.gabriels.praticagraphql.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
