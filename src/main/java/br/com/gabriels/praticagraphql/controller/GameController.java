package br.com.gabriels.praticagraphql.controller;

import br.com.gabriels.praticagraphql.domain.Game;
import br.com.gabriels.praticagraphql.domain.Publisher;
import br.com.gabriels.praticagraphql.repository.GameRepository;
import br.com.gabriels.praticagraphql.repository.PublisherRepository;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
public class GameController {
    private final GameRepository gameRepository;
    private final PublisherRepository publisherRepository;

    public GameController(GameRepository gameRepository, PublisherRepository publisherRepository) {
        this.gameRepository = gameRepository;
        this.publisherRepository = publisherRepository;
    }

    @MutationMapping
    public Game createGame(@Argument String title, @Argument String description, @Argument LocalDate releaseDate, @Argument Long publisher_id) {
        Publisher publisher = publisherRepository.findById(publisher_id).orElseThrow(() -> new RuntimeException("Publisher not found!"));

        Game game = new Game(title, description, releaseDate, publisher);

        return gameRepository.save(game);
    }

    @QueryMapping
    public Game gameById(@Argument Long id) {
        return gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Game not found!"));
    }
}
