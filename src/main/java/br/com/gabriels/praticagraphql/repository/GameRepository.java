package br.com.gabriels.praticagraphql.repository;

import br.com.gabriels.praticagraphql.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
