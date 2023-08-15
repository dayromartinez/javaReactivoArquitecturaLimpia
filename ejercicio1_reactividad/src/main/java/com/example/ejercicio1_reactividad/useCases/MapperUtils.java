package com.example.ejercicio1_reactividad.useCases;

import com.example.ejercicio1_reactividad.dto.SumaDto;
import com.example.ejercicio1_reactividad.models.Suma;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUtils {

    public Function<SumaDto, Suma> mapperToSuma(String id) {
        return crearSuma -> {

            var suma = new Suma();
            suma.setId(id);
            suma.setNumeroUno(crearSuma.getNumeroUno());
            suma.setNumeroDos(crearSuma.getNumeroDos());
            suma.setResultado(crearSuma.getResultado());
            suma.setFecha(crearSuma.getFecha());

            return suma;
        };
    }

    public Function<Suma, SumaDto> mapperEntityToSuma() {
        return entity -> new SumaDto(
                entity.getId(),
                entity.getNumeroUno(),
                entity.getNumeroDos(),
                entity.getResultado(),
                entity.getFecha()
        );
    }
}
