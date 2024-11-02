package com.bancaproj.bancaproj;

public class Prestamo {
    
    private String nombreCliente;
    private int numeroDeIdentificacion;
    private double montoPrestamo; 
    private double tasaInteres;
    private String fechaInicio; //Pendiente; la fecha de incio se debe generar automaticamnete al dia de hoy?
    private int plazoMeses;
    private int numeroOperacion;

    public Prestamo() {
    }

    public Prestamo(String nombreCliente, int numeroDeIdentificacion, double montoPrestamo, double tasaInteres, String fechaInicio, int plazoMeses) {
        setNombreCliente(nombreCliente);
        setNumeroDeIdentificacion(numeroDeIdentificacion);
        setMontoPrestamo(montoPrestamo);
        setTasaInteres(tasaInteres);
        setFechaInicio(fechaInicio); // Pending
        setPlazoMeses(plazoMeses);
        setNumeroOperacion(numeroOperacion);
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

    public String getFechaInicio() {
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

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setPlazoMeses(int plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    //Metodos
    
    //Calcular de forma automatica, ver doc para validar el formato
    public void crearNumeroOperacion(){
     
    }
    
    public void calcularCuotaMensual(){
        
    }
    
    //Agregar el prestamo activo al cliente
    public void agregarPrestamo(int numeroDeIdentificacion){
    }
};
