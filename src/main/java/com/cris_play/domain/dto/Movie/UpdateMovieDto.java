package com.cris_play.domain.dto.Movie;

import com.cris_play.domain.Genre;
import java.time.LocalDate;

import jakarta.validation.constraints.*;

public record UpdateMovieDto(

        @NotBlank(message = "El titulo es obligatorio")
        String title,

        @Min(value = 1, message = "La duracion minima es de un minuto")
        @Max(value = 600, message = "La duracion no puede superar los 600 minutos")
        Integer duration,

        @NotNull(message = "El genero es obligatorio")
        Genre genre,

        @PastOrPresent(message = "La fecha de estreno no puede ser futura")
        LocalDate releaseDate,

        @DecimalMin(value = "0.0", message = "El rating no puede ser menor que 0")
        @DecimalMax(value = "5.0", message = "El rating no puede ser mayor que 5")
        Double rating

) {}