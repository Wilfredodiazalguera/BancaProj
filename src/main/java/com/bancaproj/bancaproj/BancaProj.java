package com.bancaproj.bancaproj;

import javax.swing.JOptionPane;

public class BancaProj {

    private static int contadorCuentas = 0;
    private static Cuenta[] cuentasRegistradas = new Cuenta[50];

    public static void main(String[] args) {
        int opcion = 0;
        int opcionReporte = 0;
        String textoMenuPrincipal = "1. Registro de cuentas bancarias\n"
                + "2. Proceso de Transacciones\n"
                + "3. Registro de préstamos\n"
                + "4. Módulo de reportes.\n"
                + "5. Salir.\n";
        while (opcion != 5) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(textoMenuPrincipal));

            switch (opcion) {
                case 1:
                    //Identifacion
                    int numeroIdentificacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de identificacion: "));
                    boolean validacionIdentificacion = Cuenta.validarIdentificacionUnica(numeroIdentificacion, cuentasRegistradas);
                    if (validacionIdentificacion) {
                        JOptionPane.showMessageDialog(null, "Ya existe una cuenta registrada con ese número de identificación.Ingrese uno distinto");
                        break;
                    }
                    //Nombre
                    String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente: ");
                    //Tipo de cuenta
                    TipoCuenta tipocuentaSeleccionado = Cuenta.mappearTipoCuenta(Integer.parseInt(JOptionPane.showInputDialog("Seleccione el tipo de cuenta:\n1. Corriente\n2. Ahorros\n3. Empresarial")));
                    //Saldo inicial
                    double saldoInicial = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo inicial: "));
                    //Crear cuenta con los datos
                    Cuenta nuevaCuenta = new Cuenta(nombreCliente, numeroIdentificacion, tipocuentaSeleccionado, saldoInicial, cuentasRegistradas);
                    //Registrar la cuenta en el reporte
                    registrarCuenta(nuevaCuenta, cuentasRegistradas);
                    //Imprimir 
                    JOptionPane.showMessageDialog(null, "Cuenta creada, numero cuenta: " + nuevaCuenta.getNumeroCuenta());
                    break;
                case 2:
                    String menuTransacciones = "Seleccione el tipo de transaccion\n"
                            + "1. Deposito\n"
                            + "2. Retiro\n"
                            + "3. Transferencia\n";

                    int tipoTransaccion = Integer.parseInt(JOptionPane.showInputDialog(menuTransacciones));
                    switch (tipoTransaccion) {
                        case 1: //Deposito
                            //Transaccion.realizarDeposito();
                            break;
                        case 2: //Retiro
                            //Transaccion.realizarRetiro();
                            break;
                        case 3: //Transferencia
                            //Transaccion.realizarTransferencia();
                            break;
                    }
                    break;
                case 3:
                    break;
                case 4:
                    opcion = 0;
                    String textoMenuReportes = "Cual reporte deseas imprimir?\n\n"
                            + "1. Reporte de cuentas activas por tipo\n"
                            + "2. Reporte de transacciones por cuenta\n"
                            + "3. Reporte de préstamos\n"
                            + "4. Volver al menu principal\n";

                    opcionReporte = Integer.parseInt(JOptionPane.showInputDialog(textoMenuReportes));

                    switch (opcionReporte) {
                        case 1:
                            ImprimirCuentasActivasPorTipo();
                            break;
                        case 2:
                            reporteTransaccionesPorCuenta();
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción inválida. Intenta nuevamente.");
                    }
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intenta nuevamente.");
            }
        }

    }

    public static void registrarCuenta(Cuenta cuenta, Cuenta[] reporte) {
        if (contadorCuentas < reporte.length) {
            reporte[contadorCuentas++] = cuenta;
        } else {
            JOptionPane.showMessageDialog(null, "Se ha alcanzado el límite de cuentas");
        }
    }

    public static Cuenta[] getCuentasRegistradas() {
        return cuentasRegistradas;
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

    public static void reporteTransaccionesPorCuenta() {
        StringBuilder reporte = new StringBuilder();

        for (Cuenta cuenta : cuentasRegistradas) {
            if (cuenta != null) {
                reporte.append("Cuenta N°: ").append(cuenta.getNumeroCuenta())
                        .append("\nCliente: ").append(cuenta.getNombreCliente())
                        .append("\nTipo de Cuenta: ").append(cuenta.getTipoDeCuenta())
                        .append("\nSaldo Inicial: ").append(cuenta.getSaldoInicial())
                        .append("\n-------------------------\n");
            }
        }
        JOptionPane.showMessageDialog(null, reporte.toString());
    }
}
