package org.ezone.pae;

public class Caja {
    private int ventas = 0;
    private int total = 0;

    /**
     * Registra una venta y actualiza los valores compartidos.
     * synchronized permite que solamente un hilo ejecute el método a la vez.
     *
     * @param vendedor Nombre del vendedor que realiza la venta
     * @param monto Monto de la venta realizada
     */
    public synchronized void registrarVenta(String vendedor, int monto) {
        ventas++;
        total += monto;

        System.out.println(vendedor + " registró la venta " + ventas
                + " de C$" + monto + " | Total acumulado: C$" + total);
    }

    // Consultar la cantidad de ventas registradas
    public int getVentas() {
        return ventas;
    }

    // Consultar el dinero recaudado
    public int getTotal() {
        return total;
    }
}
