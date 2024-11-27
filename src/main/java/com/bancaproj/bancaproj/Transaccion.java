package com.bancaproj.bancaproj;

import javax.swing.JOptionPane;

public class Transaccion {

    //Pending; Crear variable Array static totalTransacciones
    private Cuenta cuenta;
    private Cuenta cuentaDestino;
    private double monto;

    public Transaccion() {
    }

    public Transaccion(Cuenta cuenta, Cuenta cuentaDestino, double monto) {
        setCuenta(cuenta);
        setCuentaDestino(cuentaDestino);
        setMonto(monto);
    }
    
    public static void realizarTransacciones(){
        int opcion = 0;
        String menuTransacciones = "Seleccione el tipo de transaccion\n"
                + "1. Deposito\n"
                + "2. Retiro\n"
                + "3. Transferencia\n";
        
        int tipoTransaccion = Integer.parseInt(JOptionPane.showInputDialog(menuTransacciones));
        switch(tipoTransaccion){
            case 1: //Deposito
                int cuentaDestino = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cuenta destino;"));
                break;
            case 2: //Retiro
                break;
            case 3: //Transferencia
                break;
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

    //Metodos
    public void depositar() {
    }

    public void retirar() {
    }

    public void transferir(int cuentaDestino) {
    }

    public void registrarTransaccion() {
    }

}
