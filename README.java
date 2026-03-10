import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Datos de entrada con nombres claros
        double[] precios = {10.5, 20.0, 5.75, 100.0};
        int[] cantidades = {2, 1, 5, 1};
        int[] tipos = {1, 2, 1, 2}; // 1: Alimento, 2: Electrónica
        
        double totalGeneral = 0;

        for (int i = 0; i < precios.length; i++) {
            double subtotal = precios[i] * cantidades[i];
            double porcentajeIVA = (tipos[i] == 1) ? 0.04 : 0.21;
            
            double precioConIVA = subtotal + (subtotal * porcentajeIVA);

            // Aplicar descuento del 10% si lleva más de 3 unidades
            if (cantidades[i] > 3) {
                precioConIVA *= 0.9;
            }

            System.out.println("Producto " + (i + 1) + ": " + precioConIVA + "€");
            totalGeneral += precioConIVA;
        }

        System.out.println("--------------------------");
        System.out.println("TOTAL A PAGAR: " + totalGeneral + "€");
        
        // Confirmación final
        Scanner teclado = new Scanner(System.in);
        System.out.print("\n¿Confirmar pedido? (s/n): ");
        String respuesta = teclado.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Guardando pedido...");
        } else {
            System.out.println("Pedido descartado.");
        }
    }
}
