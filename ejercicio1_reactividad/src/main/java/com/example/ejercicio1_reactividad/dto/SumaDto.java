package com.example.ejercicio1_reactividad.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

public class SumaDto {

    private String id;
    @NotNull
    private double numeroUno;
    @NotNull
    private double numeroDos;
    private double resultado;
    private String fecha;

    public SumaDto(String id, double numeroUno, double numeroDos, double resultado, String fecha) {
        this.id = id;
        this.numeroUno = numeroUno;
        this.numeroDos = numeroDos;
        this.resultado = resultado;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getNumeroUno() {
        return numeroUno;
    }

    public void setNumeroUno(double numeroUno) {
        this.numeroUno = numeroUno;
    }

    public double getNumeroDos() {
        return numeroDos;
    }

    public void setNumeroDos(double numeroDos) {
        this.numeroDos = numeroDos;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SumaDto sumaDto = (SumaDto) o;
        return numeroUno == sumaDto.numeroUno && numeroDos == sumaDto.numeroDos && resultado == sumaDto.resultado && id.equals(sumaDto.id) && fecha.equals(sumaDto.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroUno, numeroDos, resultado, fecha);
    }

    @Override
    public String toString() {
        return "SumaDto{" +
                "id='" + id + '\'' +
                ", numeroUno=" + numeroUno +
                ", numeroDos=" + numeroDos +
                ", resultado=" + resultado +
                ", fecha=" + fecha +
                '}';
    }
}
