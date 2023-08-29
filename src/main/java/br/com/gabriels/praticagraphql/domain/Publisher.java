package br.com.gabriels.praticagraphql.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private LocalDate creationDate;

    @Deprecated
    public Publisher() {
    }

    public Publisher(String name, String description, LocalDate creationDate) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
    }
}
