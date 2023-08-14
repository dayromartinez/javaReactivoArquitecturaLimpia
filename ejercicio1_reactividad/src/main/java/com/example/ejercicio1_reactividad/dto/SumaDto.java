package com.example.ejercicio1_reactividad.dto;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

public class SumaDto {

    private String id;
    private int numeroUno;
    private int numeroDos;
    private int resultado;
    private String fecha;

    public SumaDto(String id, int numeroUno, int numeroDos, int resultado, String fecha) {
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

    public int getNumeroUno() {
        return numeroUno;
    }

    public void setNumeroUno(int numeroUno) {
        this.numeroUno = numeroUno;
    }

    public int getNumeroDos() {
        return numeroDos;
    }

    public void setNumeroDos(int numeroDos) {
        this.numeroDos = numeroDos;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
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
