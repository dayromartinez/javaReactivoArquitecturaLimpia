package com.example.ejercicio1_reactividad.repositories;

import com.example.ejercicio1_reactividad.models.Suma;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.Date;

public interface SumaRepository extends ReactiveCrudRepository<Suma, Date> {

    Flux<Suma> findAllByFechaBetween(String fechaInicio, String fechaFin);

}
