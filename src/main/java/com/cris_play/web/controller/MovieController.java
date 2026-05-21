package com.cris_play.web.controller;

import com.cris_play.domain.dto.Movie.MovieDto;
import com.cris_play.domain.dto.Movie.SuggestRequestDto;
import com.cris_play.domain.dto.Movie.UpdateMovieDto;
import com.cris_play.domain.service.CrisPlayAIService;
import com.cris_play.domain.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final CrisPlayAIService crisPlayAIService;

    public MovieController(MovieService movieService, CrisPlayAIService crisPlayAIService) {
        this.movieService = movieService;
        this.crisPlayAIService = crisPlayAIService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        MovieDto movieDto = this.movieService.getById(id);
        if (movieDto == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No se encontró ninguna película con el id: " + id);
        }
        return ResponseEntity.ok(movieDto);
    }

    @PostMapping("/suggest")
    public ResponseEntity<String> generateMoviesSuggestion(@RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok(this.crisPlayAIService.generateMoviesSuggestion(suggestRequestDto.userPreferences()));
    }

    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto) {
        MovieDto movieDtoResponse = this.movieService.add(movieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieDtoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(
            @PathVariable long id,
            @Valid @RequestBody UpdateMovieDto updateMovieDto) {
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        this.movieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}