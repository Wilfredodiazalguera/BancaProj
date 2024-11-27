package com.bancaproj.bancaproj;

import javax.swing.JOptionPane;

public class BancaProj {

    public static void main(String[] args) {
        int opcion = 0;
        int opcionReporte = 0;
        String textoMenuPrincipal = "1. Registro de cuentas bancarias\n"
                + "2. Proceso de Transacciones\n"
                + "3. Registro de préstamos\n"
                + "4. Módulo de reportes.\n";
        while (opcion != 4) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(textoMenuPrincipal));

            switch (opcion) {
                case 1:
                    Cuenta.CrearCuenta();
                    break;
                case 2:
                    Transaccion.realizarTransacciones();
                    break;
                case 3:
                    break;
                case 4:
                    String textoMenuReportes = "Cual reporte deseas imprimir?\n\n"
                            + "1. Reporte de cuentas activas por tipo\n"
                            + "2. Reporte de transacciones por cuenta\n"
                            + "3. Reporte de préstamos\n"
                            + "4. Volver al menu principal\n";
                    
                    opcionReporte = Integer.parseInt(JOptionPane.showInputDialog(textoMenuReportes));

                    switch (opcionReporte) {
                        case 1:
                            Cuenta.ImprimirCuentasActivasPorTipo();
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción inválida. Intenta nuevamente.");
                    }
                    break;
                default:
                     JOptionPane.showMessageDialog(null, "Opción inválida. Intenta nuevamente.");
            }
        }
    }
}
