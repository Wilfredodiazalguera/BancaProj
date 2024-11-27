package com.bancaproj.bancaproj;

import java.util.Random;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;

public class Cuenta {

    private String nombreCliente;
    private int numeroDeIdentificacion;
    private TipoCuenta tipoDeCuenta;
    private double saldoInicial;
    private String fechaDeCierre;
    private boolean estaActiva;
    private String numeroCuenta;
    private static Cuenta[] cuentasRegistradas = new Cuenta[50];
    private static Random random = new Random();
    private static int contadorCuentas = 0;
    private LocalDateTime fechaApertura;

    public Cuenta() {
    }

    public Cuenta(String nombreCliente, int numeroDeIdentificacion, TipoCuenta tipoDeCuenta, double saldoInicial, String fechaDeApertura, String fechaDeCierre, boolean estaActiva, String numeroCuenta) {

        setNombreCliente(nombreCliente);
        setNumeroDeIdentificacion(numeroDeIdentificacion);
        setTipoDeCuenta(tipoDeCuenta);
        setSaldoInicial(saldoInicial);
        setFechaDeCierre(fechaDeCierre);
        setEstaActiva(estaActiva);
        crearNumeroCuenta();
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

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public static Cuenta[] getCuentasRegistradas() {
        return cuentasRegistradas;
    }

    public static void registrarCuenta(Cuenta cuenta) {
        if (contadorCuentas < cuentasRegistradas.length) {
            cuentasRegistradas[contadorCuentas++] = cuenta;
        } else {
            JOptionPane.showMessageDialog(null, "Se ha alcanzado el límite de cuentas");
        }
    }

    // Metodo
    public void crearNumeroCuenta() {
        int inicio = random.nextInt(1000);
        int fin = random.nextInt(1000, 10000);

        this.numeroCuenta = inicio + "-" + fin;

    }

    public LocalDateTime getFechaDeApertura() {
        return fechaApertura;
    }

    public void setFechaApertura() {
        this.fechaApertura = LocalDateTime.now();
    }

    public static void registrarCuenta() {
        String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente: ");
        int numeroIdentificacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de identificacion: "));
        for (Cuenta cuenta : cuentasRegistradas) {
            if (cuenta != null && cuenta.getNumeroDeIdentificacion() == numeroIdentificacion) {
                JOptionPane.showMessageDialog(null, "Ya existe una cuenta registrada con ese número de identificacion.");
                return;
            }
        }
        double saldoInicial = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo inicial: "));
        Cuenta nuevaCuenta = new Cuenta();
        nuevaCuenta.setNombreCliente(nombreCliente);
        nuevaCuenta.setNumeroDeIdentificacion(numeroIdentificacion);
        nuevaCuenta.setSaldoInicial(saldoInicial);
        nuevaCuenta.setFechaApertura();
        nuevaCuenta.crearNumeroCuenta();
        JOptionPane.showMessageDialog(null, "Fecha de apertura: " + nuevaCuenta.getFechaDeApertura());
        JOptionPane.showMessageDialog(null, "Numero cuenta: " + nuevaCuenta.getNumeroCuenta());

        registrarCuenta(nuevaCuenta);
    }

}
