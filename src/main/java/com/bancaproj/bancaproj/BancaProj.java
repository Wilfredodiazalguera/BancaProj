package com.bancaproj.bancaproj;

import javax.swing.JOptionPane;

public class BancaProj {

    public static void main(String[] args) {
        int opcion = 0;
        String textoMenu = "1. Registro de cuentas bancarias\n"
                + "2. Proceso de Transacciones\n"
                + "3. Registro de préstamos\n"
                + "4. Módulo de reportes.\n";
        while (opcion != 4) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(textoMenu));

            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "");
            }
        };
    }
}
