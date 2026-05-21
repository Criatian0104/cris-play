package com.cris_play.domain.service;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.V;

@AiService
public interface CrisPlayAIService {

    @UserMessage("""
            Genera un saludo de bienvenida creativo plataforma de Gestión de Peliculas {{plataform}}. Máximo 120 caracteres Estilo: Platzi, moderno y entusiasta Ahora: """)

    String generateGreeting(@V("plataform") String plataform);


    @SystemMessage("""
            Eres un experto en cine que recomienda películas personalizadas según los gustos del ususario.         Debes recomendar máximo 3 películas.        No incluyas películas que estén por fuera de la plataforma CrisPlay""")
    String generateMoviesSuggestion(@UserMessage String userMessage);


}
