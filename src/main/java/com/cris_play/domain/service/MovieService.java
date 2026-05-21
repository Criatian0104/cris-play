package com.cris_play.domain.service;

import com.cris_play.domain.dto.Movie.MovieDto;
import com.cris_play.domain.dto.Movie.UpdateMovieDto;
import com.cris_play.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAll() {
        return this.movieRepository.getAll();
    }

    public MovieDto getById(long id) {
        return this.movieRepository.getById(id);
    }

    public MovieDto add(MovieDto movieDto) {
        return this.movieRepository.save(movieDto);
    }

    public MovieDto update(long id, UpdateMovieDto updateMovieDto) {
        return this.movieRepository.update(id, updateMovieDto);
    }

    public void delete(long id) {
        // Implementar lógica de eliminación si es necesaria
        // Por ahora solo es un placeholder
    }
}