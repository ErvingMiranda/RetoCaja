package org.ezone.pae;

public class RetoCaja {
    public static void main(String[] args) throws InterruptedException {

        // Objeto compartido por los tres vendedores
        Caja caja = new Caja();

        // Runnable representa la tarea que ejecutará cada vendedor
        Runnable vendedor1 = () -> procesarVentas("Vendedor 1", caja);
        Runnable vendedor2 = () -> procesarVentas("Vendedor 2", caja);
        Runnable vendedor3 = () -> procesarVentas("Vendedor 3", caja);

        // Crear los Threads asociados a cada vendedor
        Thread hilo1 = new Thread(vendedor1);
        Thread hilo2 = new Thread(vendedor2);
        Thread hilo3 = new Thread(vendedor3);

        System.out.println("---- Inicio del proceso de ventas ----");

        // Iniciar los tres hilos para procesar las ventas concurrentemente
        hilo1.start();
        hilo2.start();
        hilo3.start();

        // join() permite que main espere a que terminen los tres vendedores
        hilo1.join();
        hilo2.join();
        hilo3.join();

        System.out.println("---- Fin del proceso de ventas ----");
        System.out.println("Cantidad de ventas: " + caja.getVentas());
        System.out.println("Total recaudado: C$" + caja.getTotal());
    }

    /**
     * Simula las cinco ventas realizadas por cada vendedor.
     * Cada venta tiene un monto de C$100 y una pausa de 100 ms.
     *
     * @param vendedor Nombre del vendedor que realiza las ventas
     * @param caja Objeto compartido donde se registran las operaciones
     */
    private static void procesarVentas(String vendedor, Caja caja) {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(100);
                caja.registrarVenta(vendedor, 100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(vendedor + " fue interrumpido");
                return;
            }
        }
    }
}
