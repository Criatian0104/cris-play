package com.cris_play.persistence.mapper;

import com.cris_play.domain.Genre;
import org.mapstruct.Named;

public class GenerateMapper {
    @Named("stringToGenre")
    public static Genre stringToGenre(String genre) {
        if (genre == null) {
            return null;
        }

        return switch (genre.toUpperCase()) {
            case "ACCION" -> Genre.ACTION;
            case "COMEDIA" -> Genre.COMEDY;
            case "DRAMA" -> Genre.DRAMA;
            case "TERROR" -> Genre.HORROR;
            case "CIENCIA FICCION" -> Genre.SCI_FI;
            default -> null;
        };
    }

    @Named("genereToString")
    public static String generateToString(Genre genre) {
        if (genre == null) {
            return null;
        }

        return switch (genre) {
            case ACTION -> "ACCION";
            case COMEDY -> "COMEDIA";
            case DRAMA -> "DRAMA";
            case HORROR -> "TERROR";
            case SCI_FI -> "CIENCIA FICCION";
            case ANIMATED -> "ANIMADA";
        };
    }
}