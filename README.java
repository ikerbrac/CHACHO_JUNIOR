import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Datos de entrada [cite: 14, 15, 16]
        double[] precios = {10.5, 20.0, 5.75, 100.0};
        int[] cantidades = {2, 1, 5, 1};
        int[] tipos = {1, 2, 1, 2}; 

        // Ejecutar lógica de procesamiento
        procesarPedido(precios, cantidades, tipos);

        // Ejecutar interfaz de usuario separada 
        gestionarConfirmacion();
    }

    public static void procesarPedido(double[] precios, int[] cantidades, int[] tipos) {
        double totalFinal = 0;
        for (int i = 0; i < precios.length; i++) {
            double subtotal = precios[i] * cantidades[i];
            double precioConIVA = subtotal + calcularIVA(subtotal, tipos[i]);
            double resultadoItem = aplicarDescuento(precioConIVA, cantidades[i]);
            
            System.out.println("Item " + (i + 1) + ": " + resultadoItem);
            totalFinal += resultadoItem;
        }
        System.out.println("TOTAL FINAL: " + totalFinal);
    }

    public static void gestionarConfirmacion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Confirmar pedido? (s/n)");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Guardando...");
        }
        sc.close();
    }

    public static double calcularIVA(double importe, int tipo) {
        return (tipo == 1) ? importe * 0.04 : importe * 0.21;
    }

    public static double aplicarDescuento(double total, int cantidad) {
        return (cantidad > 3) ? total * 0.9 : total;
    }
}
