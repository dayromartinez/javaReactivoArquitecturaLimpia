package com.example.ejercicio1_reactividad.useCases.sumaUseCases.interfaces;

import com.example.ejercicio1_reactividad.dto.SumaDto;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface SaveSuma {
    Mono<Object> apply(@Valid SumaDto sumaDto);
}
