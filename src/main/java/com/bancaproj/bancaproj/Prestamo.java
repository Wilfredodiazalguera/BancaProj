package com.bancaproj.bancaproj;

import java.time.LocalDateTime;

public class Prestamo {

    private String nombreCliente;
    private int numeroDeIdentificacion;
    private double montoPrestamo;
    private double tasaInteres;
    private LocalDateTime fechaInicio; 
    private int plazoMeses;
    private int numeroOperacion;

    public Prestamo() {
    }

    public Prestamo(String nombreCliente, int numeroDeIdentificacion, double montoPrestamo, double tasaInteres, int plazoMeses) {
        setNombreCliente(nombreCliente);
        setNumeroDeIdentificacion(numeroDeIdentificacion);
        setMontoPrestamo(montoPrestamo);
        setTasaInteres(tasaInteres);
        setPlazoMeses(plazoMeses);
        setNumeroOperacion();
    }

    //Getters
    public String getNombreCliente() {
        return nombreCliente;
    }

    public int getNumeroDeIdentificacion() {
        return numeroDeIdentificacion;
    }

    public double getMontoPrestamo() {
        return montoPrestamo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }

    public int getNumeroOperacion() {
        return numeroOperacion;
    }

    //Setters
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setNumeroDeIdentificacion(int numeroDeIdentificacion) {
        this.numeroDeIdentificacion = numeroDeIdentificacion;
    }

    public void setMontoPrestamo(double montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setPlazoMeses(int plazoMeses) {
        this.plazoMeses = plazoMeses;
    }
    
     //Calcular de forma automatica, ver doc para validar el formato
    public void setNumeroOperacion() {
      
    }

    //Metodos
    public void calcularCuotaMensual() {

    }

    //Agregar el prestamo activo al cliente
    public void agregarPrestamo(int numeroDeIdentificacion) {
        
    }
};
