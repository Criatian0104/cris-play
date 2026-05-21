package com.cris_play.persistence.mapper;

import com.cris_play.domain.dto.Movie.MovieDto;
import com.cris_play.domain.dto.Movie.UpdateMovieDto;
import com.cris_play.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenerateMapper.class})
public interface MovieMapper {

    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "genre", qualifiedByName = "stringToGenre")
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "clasificacion", target = "rating")
    MovieDto toDto(MovieEntity movieEntity);

    List<MovieDto> toDtos(Iterable<MovieEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "genre", target = "genero", qualifiedByName = "genereToString")
    @Mapping(target = "estado", constant = "D")
    MovieEntity toEntity(MovieDto dto);

    @Mapping(target = "titulo", source = "title")
    @Mapping(target = "duracion", source = "duration")
    @Mapping(target = "genero", source = "genre", qualifiedByName = "genereToString")
    @Mapping(target = "fechaEstreno", source = "releaseDate")
    @Mapping(target = "clasificacion", source = "rating")
    void updateEntityFromDto(UpdateMovieDto updateMovieDto, @MappingTarget MovieEntity movieEntity);
}