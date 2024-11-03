package com.bancaproj.bancaproj;

public class Transaccion {

    //Pending; Crear variable Array static totalTransacciones
    private Cuenta cuenta;
    private int cuentaDestino;

    public Transaccion() {
    }

    public Transaccion(Cuenta cuenta, int cuentaDestino) {
        setCuenta(cuenta);
        setCuentaDestino(cuentaDestino);
    }
    //Getter
    public Cuenta getCuenta() {
        return cuenta;
    }
    public int getCuentaDestino() {
        return cuentaDestino;
    }
    //Setter
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    public void setCuentaDestino(int cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
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
