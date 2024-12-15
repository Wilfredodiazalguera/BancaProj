package com.bancaproj.bancaproj;

import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cuenta {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm MM/dd/yyyy");
    private String nombreCliente;
    private int numeroDeIdentificacion;
    private TipoCuenta tipoDeCuenta;
    private double saldoInicial;
    private LocalDateTime fechaDeCierre;
    private boolean estaActiva;
    private String numeroCuenta;
    private static Random random = new Random();
    private LocalDateTime fechaApertura;

    public Cuenta() {
    }

    public Cuenta(String nombreCliente, int numeroDeIdentificacion, TipoCuenta tipoDeCuenta, double saldoInicial, Cuenta[] cuentasRegistradasReporte) {

        setNombreCliente(nombreCliente);
        setNumeroDeIdentificacion(numeroDeIdentificacion);
        setTipoDeCuenta(tipoDeCuenta);
        setSaldoInicial(saldoInicial);
        setFechaApertura();
        setFechaDeCierre();
        setEstaActiva(true);
        setNumeroCuenta(cuentasRegistradasReporte);

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

    public LocalDateTime getFechaDeCierre() {
        return fechaDeCierre;
    }

    public void setFechaDeCierre() {
        this.fechaDeCierre = LocalDateTime.now();
    }

    public boolean isEstaActiva() {
        return estaActiva;
    }

    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getFechaDeApertura() {
        return fechaApertura.format(formatter);
    }

    public void setFechaApertura() {
        this.fechaApertura = LocalDateTime.now();
    }

    // Metodos ******************************************
    public void setNumeroCuenta(Cuenta[] cuentasRegistradasReporte) {
        String nuevoNumero;

        do {
            int inicio = random.nextInt(1000);
            int fin = random.nextInt(1000, 10000);
            nuevoNumero = inicio + "-" + fin;
        } while (validarUnicoNumeroDeCuenta(nuevoNumero, cuentasRegistradasReporte));

        this.numeroCuenta = nuevoNumero;
    }

    private boolean validarUnicoNumeroDeCuenta(String numero, Cuenta[] cuentasRegistradasReporte) {
        for (Cuenta cuenta : cuentasRegistradasReporte) {
            if (cuenta != null && numero.equals(cuenta.getNumeroCuenta())) {
                return true;
            }
        }
        return false;
    }

    public static boolean validarIdentificacionUnica(int numeroIdentificacionParam, Cuenta[] cuentasRegistradasParam) {
        boolean existeIdentificacion = false;
        for (Cuenta cuenta : cuentasRegistradasParam) {
            if (cuenta != null && cuenta.getNumeroDeIdentificacion() == numeroIdentificacionParam) {
                existeIdentificacion = true;
            }
        }
        return existeIdentificacion;
    }

    public static TipoCuenta mappearTipoCuenta(int opcionTipoCuenta) {
        TipoCuenta tipoCuentaSeleccionado = null;

        if (opcionTipoCuenta == 1) {
            tipoCuentaSeleccionado = TipoCuenta.Corriente;
        } else if (opcionTipoCuenta == 2) {
            tipoCuentaSeleccionado = TipoCuenta.Ahorros;
        } else if (opcionTipoCuenta == 3) {
            tipoCuentaSeleccionado = TipoCuenta.Empresarial;
        } else {
            return null;
        }

        return tipoCuentaSeleccionado;
    }

    public boolean tienePrestamosActivos() {
        for (Prestamo prestamo : Prestamo.listaPrestamos) {
            if (prestamo != null && prestamo.getNumeroDeIdentificacion() == this.numeroDeIdentificacion) {
                return true;
            }
        }
        return false;
    }

}
