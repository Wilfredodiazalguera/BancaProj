package com.bancaproj.bancaproj;

import javax.swing.JOptionPane;

public class Transaccion {

    //Pending; Crear variable Array static totalTransacciones
    private Cuenta cuenta;
    private Cuenta cuentaDestino;
    private Cuenta cuentaOrigen;
    private double monto;
    private String tipoTransaccion;

    public Transaccion() {
    }
    //j

    public Transaccion(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto, String tipoTransaccion) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.tipoTransaccion = tipoTransaccion;
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
        double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a depositar:"));
        if (monto <= 0) {
            JOptionPane.showMessageDialog(null, "Monto inválido.");
            return;
        }
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

    public void registrarTransaccion() {
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

}
