package com.example.ejercicio1_reactividad.routes;

import com.example.ejercicio1_reactividad.dto.SumaDto;
import com.example.ejercicio1_reactividad.useCases.sumaUseCases.CrearSumaUseCase;
import com.example.ejercicio1_reactividad.useCases.sumaUseCases.GetSumasUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SumaRouter {

    @Bean
    public RouterFunction<ServerResponse> getSumas(GetSumasUseCase getSumasUseCase) {
        return route(GET("/buscarSumas").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getSumasUseCase
                                .apply(request.queryParam("fechaInicio").get(), request.queryParam("fechaFin").get()), SumaDto.class
                        ))
                );
    }

    @Bean
    public RouterFunction<ServerResponse> crearSuma(CrearSumaUseCase crearSumaUseCase) {
        Function<SumaDto, Mono<ServerResponse>> executor = sumaDto -> crearSumaUseCase
                .apply(sumaDto).flatMap(respuesta -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON).bodyValue(respuesta));

        return route(POST("/crearSuma").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(SumaDto.class).flatMap(executor)
        );
    }
}
