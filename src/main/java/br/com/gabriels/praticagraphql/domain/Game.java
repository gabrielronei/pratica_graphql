package br.com.gabriels.praticagraphql.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Deprecated
    public Game() {}

    public Game(String title, String description, LocalDate releaseDate, Publisher publisher) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.publisher = publisher;
    }
}
