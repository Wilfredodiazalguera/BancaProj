package com.bancaproj.bancaproj;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class Transaccion {

    public static Transaccion[] totalTransacciones = new Transaccion[100];
    private static int totalTransaccionesRegistradas = 0;

    private Cuenta cuenta;
    private Cuenta cuentaDestino;
    private Cuenta cuentaOrigen;
    private double monto;
    private String tipoTransaccion;
    private LocalDateTime fechaTransaccion;

    public Transaccion() {
    }

    public Transaccion(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto, String tipoTransaccion) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.tipoTransaccion = tipoTransaccion;
        this.fechaTransaccion = LocalDateTime.now();
    }

    public static void realizarTransacciones() {
        int opcion = 0;
        String menuTransacciones = "Seleccione el tipo de transaccion\n"
                + "1. Deposito\n"
                + "2. Retiro\n"
                + "3. Transferencia\n";

        int tipoTransaccion = Integer.parseInt(JOptionPane.showInputDialog(menuTransacciones));
        switch (tipoTransaccion) {
            case 1: //Deposito
                realizarDeposito();
                break;
            case 2: //Retiro
                realizarRetiro();
                break;
            case 3: //Transferencia
                realizarTransferencia();
                break;
        }
    }

    //Metodos
    public static void realizarDeposito() {
        String numeroCuenta = JOptionPane.showInputDialog("Ingrese el número de cuenta:");
        Cuenta cuenta = obtenerCuenta(numeroCuenta);

        if (cuenta == null) {
            JOptionPane.showMessageDialog(null, "Cuenta no encontrada.");
            return;
        }

        double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a depositar:"));
        if (monto <= 0) {
            JOptionPane.showMessageDialog(null, "Monto inválido.");
            return;
        }

        cuenta.setSaldoInicial(cuenta.getSaldoInicial() + monto);
        Transaccion transaccion = new Transaccion();
        transaccion.setCuenta(cuenta);
        transaccion.setMonto(monto);
        transaccion.setTipoTransaccion("Deposito");
        registrarTransaccion(transaccion);
        JOptionPane.showMessageDialog(null, "Deposito realizado");

    }

    public static void realizarRetiro() {
        double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a depositar:"));
        if (monto <= 0) {
            JOptionPane.showMessageDialog(null, "Monto inválido.");
            return;
        }
    }

    public static void realizarTransferencia() {
    }

    public static Cuenta obtenerCuenta(String numeroCuenta) {
        for (Cuenta cuenta : Cuenta.getCuentasRegistradas()) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;  // Si no se encuentra la cuenta, devuelve null
    }

    public static void registrarTransaccion(Transaccion transaccion) {
        if (totalTransaccionesRegistradas < totalTransacciones.length) {
            totalTransacciones[totalTransaccionesRegistradas++] = transaccion;
        } else {
            JOptionPane.showMessageDialog(null, "Se ha alcanzado el máximo de transacciones.");
        }
    }

    //Getter
    public Cuenta getCuenta() {
        return cuenta;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public double getMonto() {
        return monto;
    }

    //Setter
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

}
