package com.cris_play.domain.repository;

import com.cris_play.domain.dto.Movie.MovieDto;
import com.cris_play.domain.dto.Movie.UpdateMovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(long id);
    MovieDto save(MovieDto movieDto);
    MovieDto update(long id, UpdateMovieDto updateMovieDto);
    void delete(long id);
}