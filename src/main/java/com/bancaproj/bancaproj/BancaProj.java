package com.bancaproj.bancaproj;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class BancaProj {

    private static int contadorCuentas = 0;
    static Cuenta[] cuentasRegistradas = new Cuenta[50];

    public static void main(String[] args) {
        int opcion = 0;
        int opcionReporte = 0;
        String textoMenuPrincipal = "1. Registro de cuentas bancarias\n"
                + "2. Proceso de Transacciones\n"
                + "3. Registro de préstamos\n"
                + "4. Módulo de reportes.\n"
                + "5. Eliminar Cuenta\n"
                + "6. Salir.\n";
        while (opcion != 6) {
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
                    JOptionPane.showMessageDialog(null, " Fecha de apertura: " + nuevaCuenta.getFechaDeApertura());
                    break;
                case 2:
                    String menuTransacciones = "Seleccione el tipo de transaccion\n"
                            + "1. Deposito\n"
                            + "2. Retiro\n"
                            + "3. Transferencia\n";

                    int tipoTransaccion = Integer.parseInt(JOptionPane.showInputDialog(menuTransacciones));
                    switch (tipoTransaccion) {
                        case 1:
                            Transaccion.realizarDeposito();
                            break;
                        case 2: //Retiro
                            Transaccion.realizarRetiro();
                            break;
                        case 3: //Transferencia
                            Transaccion.realizarTransferencia();
                            break;
                    }
                    break;
                case 3:
                    String input = JOptionPane.showInputDialog("Ingrese el número de identificación: ");
                    numeroIdentificacion = Integer.parseInt(input);
                    agregarPrestamo(numeroIdentificacion);
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
                            imprimirCuentasActivasPorTipo();
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
                    eliminarCuenta();
                    break;
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intenta nuevamente.");
            }
        }

    }

    private static void registrarCuenta(Cuenta cuenta, Cuenta[] reporte) {
        if (contadorCuentas < reporte.length) {
            reporte[contadorCuentas++] = cuenta;
        } else {
            JOptionPane.showMessageDialog(null, "Se ha alcanzado el límite de cuentas");
        }
    }

    public static Cuenta[] getCuentasRegistradas() {
        return cuentasRegistradas;
    }

    public static void imprimirCuentasActivasPorTipo() {
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
                            .append("\nNúmero de identificacion: ").append(cuenta.getNumeroDeIdentificacion())
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
                            .append("\nNúmero de identificacion: ").append(cuenta.getNumeroDeIdentificacion())
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
                            .append("\nNúmero de identificacion: ").append(cuenta.getNumeroDeIdentificacion())
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
    } // Aca se termina el metodo imprimirCuentasActivasPorTipo()

    public static void reporteTransaccionesPorCuenta() {
        int numeroIdentificacion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de identificación del cliente"));
        Cuenta cuentaSeleccionada = Transaccion.obtenerCuentaPorIdentificacion(numeroIdentificacion);

        if (cuentaSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
            return;
        }

        StringBuilder reporte = new StringBuilder();
        reporte.append("Reporte de transacciones para la cuenta:\n")
                .append("Cuenta N°: ").append(cuentaSeleccionada.getNumeroCuenta()).append("\n")
                .append("Cliente: ").append(cuentaSeleccionada.getNombreCliente()).append("\n")
                .append("Tipo de Cuenta: ").append(cuentaSeleccionada.getTipoDeCuenta()).append("\n")
                .append("-------------------------\n");

        boolean hayTransacciones = false;

        for (Transaccion transaccion : Transaccion.totalTransacciones) {
            if (transaccion != null && transaccion.getCuentaOrigen() == cuentaSeleccionada) {
                reporte.append("Tipo: ").append(transaccion.tipoTransaccion.toString())
                        .append("\nMonto: ").append(transaccion.getMonto())
                        .append("\nFecha: ").append(transaccion.getFecha())
                        .append("\n-------------------------\n");
                hayTransacciones = true;
            }
        }

        if (!hayTransacciones) {
            reporte.append("No hay transacciones registradas para esta cuenta.");
        }

        JOptionPane.showMessageDialog(null, reporte.toString());
    }

    public static void agregarPrestamo(int numeroDeIdentificacion) {
        Cuenta cuentaCliente = null;
        for (Cuenta cuenta : BancaProj.cuentasRegistradas) {
            if (cuenta != null && cuenta.getNumeroDeIdentificacion() == numeroDeIdentificacion) {
                cuentaCliente = cuenta;
                break;
            }
        }

        if (cuentaCliente == null) {
            JOptionPane.showMessageDialog(null, "El cliente no tiene una cuenta registrada. No se puede solicitar un préstamo.");
            return;
        }

        int prestamosActivos = 0;
        for (Prestamo prestamo : Prestamo.listaPrestamos) {
            if (prestamo != null && prestamo.getNumeroDeIdentificacion() == numeroDeIdentificacion) {
                prestamosActivos++;
            }
        }

        if (prestamosActivos >= 2) {
            JOptionPane.showMessageDialog(null, "El cliente ya tiene el máximo de 2 préstamos activos.");
            return;
        }

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        double monto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto del préstamo:"));
        double tasa = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la tasa de interés anual (en porcentaje):")) / 100;
        int plazo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el plazo del préstamo en meses:"));

        Prestamo nuevoPrestamo = new Prestamo(nombre, numeroDeIdentificacion, monto, tasa, plazo);
        nuevoPrestamo.setNumeroOperacion();  // Generar el número de operación

        nuevoPrestamo.calcularCuotaMensual();
        JOptionPane.showMessageDialog(null, "Préstamo registrado con éxito.\nNúmero de operación: " + nuevoPrestamo.getNumeroOperacion() + "\nFecha: " + nuevoPrestamo.getFechaInicio());

        if (Prestamo.contadorPrestamos < Prestamo.listaPrestamos.length) {
            Prestamo.listaPrestamos[Prestamo.contadorPrestamos] = nuevoPrestamo;
            Prestamo.contadorPrestamos++;
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio para más préstamos.");
        }
    }

    public static void eliminarCuenta() {
        // Pedir al usuario el número de identificación de la cuenta a eliminar
        int numeroIdentificacion = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de identificación de la cuenta a eliminar"));

        // Variables para buscar la cuenta a eliminar
        Cuenta cuentaAEliminar = null;
        int posicion = -1;

        // Buscar la cuenta por el número de identificación
        for (int i = 0; i < cuentasRegistradas.length; i++) {
            if (cuentasRegistradas[i] != null && cuentasRegistradas[i].getNumeroDeIdentificacion() == numeroIdentificacion) {
                cuentaAEliminar = cuentasRegistradas[i];
                posicion = i;
                break;
            }
        }

        // Si la cuenta no existe
        if (cuentaAEliminar == null) {
            JOptionPane.showMessageDialog(null, "La cuenta no existe.");
        } // Si la cuenta tiene saldo positivo
        else if (cuentaAEliminar.getSaldoInicial() > 0) {
            JOptionPane.showMessageDialog(null, "La cuenta no puede eliminarse porque tiene saldo positivo.");
        } // Si la cuenta tiene préstamos activos
        else if (cuentaAEliminar.tienePrestamosActivos()) {
            JOptionPane.showMessageDialog(null, "La cuenta no puede eliminarse porque tiene préstamos activos.");
        } // Si la cuenta se puede eliminar
        else {
            cuentaAEliminar.setEstaActiva(false);
            cuentasRegistradas[posicion] = null;
            JOptionPane.showMessageDialog(null, "La cuenta ha sido eliminada exitosamente.");
        }

        // Regresamos al menú principal sin modificar la opción
    }
}
