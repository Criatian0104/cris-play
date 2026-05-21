package com.cris_play.domain.dto.Movie;

import com.cris_play.domain.Genre;

import java.time.LocalDate;

public record MovieDto(
        Long id,
    String title,
    Integer duration,
    Genre genre,
    LocalDate releaseDate,
    Double rating
) {

}
