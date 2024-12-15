package com.bancaproj.bancaproj;

import java.time.LocalDateTime;
import java.util.Random;
import javax.swing.JOptionPane;

public class Prestamo {

    private String nombreCliente;
    private int numeroDeIdentificacion;
    private double montoPrestamo;
    private double tasaInteres;
    private LocalDateTime fechaInicio;
    private int plazoMeses;
    private String numeroOperacion;

    public static Prestamo[] listaPrestamos = new Prestamo[100]; // Son 50 cuentas y solo dos prestamos por cuenta por el 100
    public static int contadorPrestamos = 0;

    public Prestamo() {
    }

    public Prestamo(String nombreCliente, int numeroDeIdentificacion, double montoPrestamo, double tasaInteres, int plazoMeses) {
        setNombreCliente(nombreCliente);
        setNumeroDeIdentificacion(numeroDeIdentificacion);
        setMontoPrestamo(montoPrestamo);
        setTasaInteres(tasaInteres);
        setPlazoMeses(plazoMeses);
        setFechaInicio(LocalDateTime.now());
    }

    // Getters
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

    public String getNumeroOperacion() {
        return numeroOperacion;
    }

    // Setters
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

    public void setNumeroOperacion() {
        String nuevoNumeroOperacion;
        Random random = new Random();

        do {
            int parteUno = random.nextInt(1000, 10000);
            int parteDos = random.nextInt(1000, 10000);
            String anno = String.valueOf(LocalDateTime.now().getYear());
            nuevoNumeroOperacion = String.format("%s-%s-%s", parteUno, parteDos, anno);

        } while (validarUnicoNumeroOperacion(nuevoNumeroOperacion));

        this.numeroOperacion = nuevoNumeroOperacion;
    }

    private boolean validarUnicoNumeroOperacion(String numero) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo != null && numero.equals(prestamo.getNumeroOperacion())) {
                return true;
            }
        }
        return false;
    }

    public void calcularCuotaMensual() {
        double tasaMensual = this.tasaInteres / 12;
        double factor = 1;
        for (int i = 0; i < plazoMeses; i++) {
            factor *= (1 + tasaMensual);
        }
        factor = 1 / factor;
        double cuotaMensual = (montoPrestamo * tasaMensual) / (1 - factor);

        JOptionPane.showMessageDialog(null, "La cuota mensual es: " + cuotaMensual);
    }

}
