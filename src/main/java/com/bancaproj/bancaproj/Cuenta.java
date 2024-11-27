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

    // Metodos
    
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

    public void setTipoCuenta(int opcionTipoCuenta) {
        switch (opcionTipoCuenta) {
            case 1:
                this.tipoDeCuenta = TipoCuenta.Corriente;
                break;
            case 2:
                this.tipoDeCuenta = TipoCuenta.Ahorros;
                break;
            case 3:
                this.tipoDeCuenta = TipoCuenta.Empresarial;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida. Intenta nuevamente.");
        }
    }

    public static void CrearCuenta() {
        
        //Solicitar nombre
        String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente: ");
        
        //Solicitar identificacion y validar que no exista
        int numeroIdentificacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de identificacion: "));
        for (Cuenta cuenta : cuentasRegistradas) {
            if (cuenta != null && cuenta.getNumeroDeIdentificacion() == numeroIdentificacion) {
                JOptionPane.showMessageDialog(null, "Ya existe una cuenta registrada con ese número de identificacion.");
                return;
            }
        }
        
        //Solcitar tipo de cuenta
        String tipoCuentaStr = JOptionPane.showInputDialog("Seleccione el tipo de cuenta:\n1. Corriente\n2. Ahorros\n3. Empresarial");
        int opcionTipoCuenta = Integer.parseInt(tipoCuentaStr);

        //Solicitar saldo inicial
        double saldoInicial = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo inicial: "));
        
        //Crear cuenta
        Cuenta nuevaCuenta = new Cuenta();
        nuevaCuenta.setTipoCuenta(opcionTipoCuenta);
        nuevaCuenta.setNombreCliente(nombreCliente);
        nuevaCuenta.setNumeroDeIdentificacion(numeroIdentificacion);
        nuevaCuenta.setSaldoInicial(saldoInicial);
        nuevaCuenta.setFechaApertura();
        nuevaCuenta.crearNumeroCuenta();
        nuevaCuenta.setEstaActiva(true);
        JOptionPane.showMessageDialog(null, "Fecha de apertura: " + nuevaCuenta.getFechaDeApertura());
        JOptionPane.showMessageDialog(null, "Numero cuenta: " + nuevaCuenta.getNumeroCuenta());

        //Se registra la cuenta 
        registrarCuenta(nuevaCuenta);
    }

    public static void ImprimirCuentasActivasPorTipo() {
        StringBuilder reporte = new StringBuilder();

        //Estas varibales nos ayudan a imprimir solo una unica vez cada encabezado
        //por eso luego de imprimirlo se cambia el valor de cada una
        boolean tieneCuentasCorrientes = false;
        boolean tieneCuentasAhorros = false;
        boolean tieneCuentasEmpresariales = false;

        // Logica para agregar las cuentas activas por tipo usando if
        for (Cuenta cuenta : cuentasRegistradas) {
            if (cuenta != null && cuenta.isEstaActiva()) {
                
                if (cuenta.getTipoDeCuenta() == TipoCuenta.Corriente) {
                    if (!tieneCuentasCorrientes) {
                        reporte.append("\nCuentas de tipo CORRIENTE:\n");
                        tieneCuentasCorrientes = true;
                    }
                    reporte.append("\nCliente: ").append(cuenta.getNombreCliente())
                            .append("\nNúmero de cuenta: ").append(cuenta.getNumeroCuenta())
                            .append("\nSaldo Inicial: ").append(cuenta.getSaldoInicial())
                            .append("\nFecha de Apertura: ").append(cuenta.getFechaDeApertura())
                            .append("\n*************************\n");
                    
                } else if (cuenta.getTipoDeCuenta() == TipoCuenta.Ahorros) {
                    if (!tieneCuentasAhorros) {
                        reporte.append("\nCuentas de tipo AHORROS:\n");
                        tieneCuentasAhorros = true;
                    }
                    reporte.append("\nCliente: ").append(cuenta.getNombreCliente())
                            .append("\nNúmero de cuenta: ").append(cuenta.getNumeroCuenta())
                            .append("\nSaldo Inicial: ").append(cuenta.getSaldoInicial())
                            .append("\nFecha de Apertura: ").append(cuenta.getFechaDeApertura())
                            .append("\n*************************\n");
                    
                } else if (cuenta.getTipoDeCuenta() == TipoCuenta.Empresarial) {
                    if (!tieneCuentasEmpresariales) {
                        reporte.append("\nCuentas de tipo EMPRESARIAL:\n");
                        tieneCuentasEmpresariales = true;
                    }
                    reporte.append("\nCliente: ").append(cuenta.getNombreCliente())
                            .append("\nNúmero de cuenta: ").append(cuenta.getNumeroCuenta())
                            .append("\nSaldo Inicial: ").append(cuenta.getSaldoInicial())
                            .append("\nFecha de Apertura: ").append(cuenta.getFechaDeApertura())
                            .append("\n*************************\n");
                }
            }
        } // Aca se finaliza el for

        // Si no hay cuentas activas de ningún tipo
        if (reporte.length() == 0) {
            JOptionPane.showMessageDialog(null, "No hay cuentas activas en este momento.");
        } else {
            // Mostrar el reporte de las cuentas activas agrupadas por tipo
            JOptionPane.showMessageDialog(null, reporte.toString());
        }
    } // Aca se termina el metodo ImprimirCuentasActivasPorTipo()

}
