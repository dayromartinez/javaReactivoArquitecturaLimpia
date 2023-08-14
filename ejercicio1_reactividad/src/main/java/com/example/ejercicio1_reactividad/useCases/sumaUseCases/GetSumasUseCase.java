package com.example.ejercicio1_reactividad.useCases.sumaUseCases;

import com.example.ejercicio1_reactividad.dto.SumaDto;
import com.example.ejercicio1_reactividad.repositories.SumaRepository;
import com.example.ejercicio1_reactividad.useCases.MapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.BiFunction;

@Service
@Validated
public class GetSumasUseCase implements BiFunction<String, String, Flux<SumaDto>> {

    private final SumaRepository sumaRepository;
    private final MapperUtils mapperUtils;

    private static final Logger log = LoggerFactory.getLogger(GetSumasUseCase.class);

    public GetSumasUseCase(SumaRepository sumaRepository, MapperUtils mapperUtils) {
        this.sumaRepository = sumaRepository;
        this.mapperUtils = mapperUtils;
    }


    @Override
    public Flux<SumaDto> apply(String fechaInicio, String fechaFin) {

        /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaInicioDate = LocalDate.parse(fechaInicio, formatter);
        LocalDate fechaFinDate = LocalDate.parse(fechaFin, formatter);*/


        return sumaRepository.findAllByFechaBetween(fechaInicio, fechaFin)
                //.doOnNext(info -> log.info("Fecha inicio: " + fechaInicioDate.toString() + " Fecha fin: " + fechaFinDate.toString()))
                /*.filter(fechaSuma -> {
                    LocalDate fechaSumaDate = LocalDate.parse(fechaSuma.getFecha(), formatter);
                    log.info(fechaSumaDate.toString(), fechaFinDate.toString());
                    log.info(String.format("El resultado de esta evaluación arrojó: %b", fechaSumaDate.isAfter(fechaInicioDate) && fechaSumaDate.isBefore(fechaFinDate)));
                    return fechaSumaDate.isAfter(fechaInicioDate) && fechaSumaDate.isBefore(fechaFinDate);
                })*/
                .map(mapperUtils.mapperEntityToSuma())
                .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }
}
