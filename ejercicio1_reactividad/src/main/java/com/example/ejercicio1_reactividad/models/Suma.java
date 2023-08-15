package com.example.ejercicio1_reactividad.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Suma {

    @Id
    private String id;
    private double numeroUno;
    private double numeroDos;
    private double resultado;
    private String fecha;

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
}
