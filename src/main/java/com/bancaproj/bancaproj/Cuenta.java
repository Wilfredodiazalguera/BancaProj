package com.bancaproj.bancaproj;

public class Cuenta {

    private String nombreCliente;
    private int numeroDeIdentificacion;
    private TipoCuenta tipoDeCuenta;
    private double saldoInicial;
    private String fechaDeApertura;
    private String fechaDeCierre;
    private boolean estaActiva;
    private int numeroCuenta;
//    historialTrasacciones: Array[]

    public Cuenta() {
    }

    public Cuenta(String nombreCliente, int numeroDeIdentificacion, TipoCuenta tipoDeCuenta, double saldoInicial, String fechaDeApertura, String fechaDeCierre, boolean estaActiva, int numeroCuenta) {

        setNombreCliente(nombreCliente);
        setNumeroDeIdentificacion(numeroDeIdentificacion);
        setTipoDeCuenta(tipoDeCuenta);
        setSaldoInicial(saldoInicial);
        setFechaDeApertura(fechaDeApertura);
        setFechaDeCierre(fechaDeCierre);
        setEstaActiva(estaActiva);
        setNumeroCuenta(numeroCuenta);
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getNumeroDeIdentificacion() {
        return numeroDeIdentificacion;
    }

    public void setNumeroDeIdentificacion(int numeroDeIdentificacion) {
        this.numeroDeIdentificacion = numeroDeIdentificacion;
    }

    public TipoCuenta getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(TipoCuenta tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public String getFechaDeApertura() {
        return fechaDeApertura;
    }

    public void setFechaDeApertura(String fechaDeApertura) {
        this.fechaDeApertura = fechaDeApertura;
    }

    public String getFechaDeCierre() {
        return fechaDeCierre;
    }

    public void setFechaDeCierre(String fechaDeCierre) {
        this.fechaDeCierre = fechaDeCierre;
    }

    public boolean isEstaActiva() {
        return estaActiva;
    }

    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
 
    // Metodo
    public void crearNumeroCuenta() {
        
    }
    
    
}
