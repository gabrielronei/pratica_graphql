package br.com.gabriels.praticagraphql.controller;

import br.com.gabriels.praticagraphql.domain.Publisher;
import br.com.gabriels.praticagraphql.repository.PublisherRepository;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
public class PublisherController {

    private PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @MutationMapping
    public Publisher createPublisher(@Argument String name, @Argument String description, @Argument String creationDate) {
        Publisher publisher = new Publisher(name, description, LocalDate.parse(creationDate));

        return publisherRepository.save(publisher);
    }

    @QueryMapping
    public Publisher publisherById(@Argument Long id) {
        return publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found!"));
    }
}
