package com.example.ejercicio1_reactividad.useCases.sumaUseCases;

import com.example.ejercicio1_reactividad.dto.SumaDto;
import com.example.ejercicio1_reactividad.repositories.SumaRepository;
import com.example.ejercicio1_reactividad.useCases.MapperUtils;
import com.example.ejercicio1_reactividad.useCases.sumaUseCases.interfaces.SaveSuma;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


@Service
@Validated
public class CrearSumaUseCase implements SaveSuma {

    private final SumaRepository sumaRepository;
    private final MapperUtils mapperUtils;

    public CrearSumaUseCase(SumaRepository sumaRepository, MapperUtils mapperUtils) {
        this.sumaRepository = sumaRepository;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<Object> apply(SumaDto sumaDto) {

        LocalDateTime fechaYHora = LocalDateTime.now();
        DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
        String fechaConvertida = fechaYHora.format(isoFecha).toString();
        sumaDto.setFecha(fechaConvertida);

        var resultado = sumaDto.getNumeroUno() + sumaDto.getNumeroDos();
        sumaDto.setResultado(resultado);

        return sumaRepository.save(
                mapperUtils.mapperToSuma(null).apply(sumaDto))
                .thenReturn("Suma procesada y almacenada exitosamente");
    }
}
