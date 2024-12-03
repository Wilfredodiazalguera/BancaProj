package com.bancaproj.bancaproj;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class Transaccion {

    public static Transaccion[] totalTransacciones = new Transaccion[100];
    private static int totalTransaccionesRegistradas = 0;
    private double monto;
    private TipoTransaccion tipoTransaccion;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private LocalDateTime fechaTransaccion;

    public Transaccion() {
    }

    public Transaccion(double monto, TipoTransaccion tipoTransaccion, Cuenta cuentaOrigen, Cuenta cuentaDestino) {
        this.monto = monto;
        this.tipoTransaccion = tipoTransaccion;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.fechaTransaccion = LocalDateTime.now();
    }

    //Metodos
    public static void realizarDeposito() {
        int numeroIdentificacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de identificación del cliente:"));
        Cuenta cuenta = obtenerCuentaPorIdentificacion(numeroIdentificacion);

        if (cuenta != null) {
            double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a depositar:"));
            if (monto <= 0) {
                JOptionPane.showMessageDialog(null, "Monto inválido.");
                return;
            }

            cuenta.setSaldoInicial(cuenta.getSaldoInicial() + monto);
            registrarTransaccion(new Transaccion(monto, TipoTransaccion.Deposito, cuenta, null));
            JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Cuenta no encontrada.");
        }
    }

    public static void realizarRetiro() {
        int numeroIdentificacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de identificación del cliente:"));
        Cuenta cuenta = obtenerCuentaPorIdentificacion(numeroIdentificacion);

        if (cuenta != null) {
            double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a retirar:"));
            if (monto <= 0) {
                JOptionPane.showMessageDialog(null, "Monto inválido.");
                return;
            }
            if (cuenta.getSaldoInicial() >= monto) {
                cuenta.setSaldoInicial(cuenta.getSaldoInicial() - monto);
                registrarTransaccion(new Transaccion(monto, TipoTransaccion.Retiro, cuenta, null));
                JOptionPane.showMessageDialog(null, "Retiro realizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cuenta no encontrada.");
        }
    }

    public static void realizarTransferencia() {
        int numeroIdentificacionOrigen = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de identificación de la cuenta origen:"));
        Cuenta cuentaOrigen = obtenerCuentaPorIdentificacion(numeroIdentificacionOrigen);

        if (cuentaOrigen != null) {
            int numeroIdentificacionDestino = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de identificación de la cuenta destino:"));
            Cuenta cuentaDestino = obtenerCuentaPorIdentificacion(numeroIdentificacionDestino);
            if (cuentaDestino != null) {

                if (cuentaOrigen.getTipoDeCuenta() != cuentaDestino.getTipoDeCuenta()) {
                    JOptionPane.showMessageDialog(null, "Las cuentas deben ser del mismo tipo (Corriente a Corriente o Ahorros a Ahorros).");
                    return;
                }
                double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a transferir:"));
                if (monto <= 0) {
                    JOptionPane.showMessageDialog(null, "Monto inválido.");
                    return;
                }
                if (cuentaOrigen.getSaldoInicial() >= monto) {
                    cuentaOrigen.setSaldoInicial(cuentaOrigen.getSaldoInicial() - monto);
                    cuentaDestino.setSaldoInicial(cuentaDestino.getSaldoInicial() + monto);

                    registrarTransaccion(new Transaccion(monto, TipoTransaccion.Transferencia, cuentaOrigen, cuentaDestino));
                    JOptionPane.showMessageDialog(null, "Transferencia realizada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente en la cuenta origen.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cuenta destino no encontrada.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cuenta origen no encontrada.");
        }
    }


    public static Cuenta obtenerCuentaPorIdentificacion(int numeroIdentificacion) {
        for (Cuenta cuenta : BancaProj.getCuentasRegistradas()) {
            if (cuenta != null && cuenta.getNumeroDeIdentificacion() == numeroIdentificacion) {
                return cuenta;
            }
        }
        return null;
    }

    public static void registrarTransaccion(Transaccion transaccion) {
        if (totalTransaccionesRegistradas < totalTransacciones.length) {
            totalTransacciones[totalTransaccionesRegistradas++] = transaccion;
        } else {
            JOptionPane.showMessageDialog(null, "Se ha alcanzado el máximo de transacciones.");
        }
    }

    //Getter
    public double getMonto() {
        return monto;
    }

    public LocalDateTime getFecha() {
        return fechaTransaccion;
    }

    //Setter
    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

}
