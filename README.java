import java.util.Scanner;

/**
 * Clase principal del Grupo 1.
 * 
 * se aplicaron nombres descriptivos
 */
public class Main {
    
    public static void main(String[] args) {
        // Definición de los datos del pedido: precios, cantidades y tipos de producto
        double[] precios = {10.5, 20.0, 5.75, 100.0};
        int[] cantidades = {2, 1, 5, 1};
        int[] tipos = {1, 2, 1, 2}; // 1: Alimento (IVA 4%), 2: Electrónica (IVA 21%)

        // Llamada al motor de cálculo
        procesarPedido(precios, cantidades, tipos);

        // Llamada a la interacción con el usuario
        gestionarConfirmacion();
    }

    /**
     * Recorre los productos, calcula los importes individuales y muestra el total.
     */
    public static void procesarPedido(double[] precios, int[] cantidades, int[] tipos) {
        double totalFinal = 0;

        for (int i = 0; i < precios.length; i++) {
            // Cálculo del subtotal base
            double subtotal = precios[i] * cantidades[i];
            
            // Suma del impuesto correspondiente según el tipo de producto
            double precioConIVA = subtotal + calcularIVA(subtotal, tipos[i]);
            
            // Aplicación de descuentos por volumen de compra
            double resultadoItem = aplicarDescuento(precioConIVA, cantidades[i]);
            
            // Salida de información por consola
            System.out.println("Producto " + (i + 1) + " - Precio final: " + resultadoItem + "€");
            totalFinal += resultadoItem;
        }
        
        System.out.println("--------------------------");
        System.out.println("TOTAL DE LA OPERACIÓN: " + totalFinal + "€");
    }

    /**
     * Gestiona la entrada por teclado para confirmar la acción del usuario.
     */
    public static void gestionarConfirmacion() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n¿Desea confirmar el pedido? (s/n): ");
        String respuesta = sc.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Estado: Pedido guardado correctamente en la base de datos.");
        } else {
            System.out.println("Estado: Operación cancelada por el usuario.");
        }
        sc.close();
    }

    /**
     * Lógica modular para determinar el IVA.
     */
    public static double calcularIVA(double importe, int tipo) {
        // Tipo 1 es superreducido (4%), cualquier otro se trata como general (21%)
        return (tipo == 1) ? importe * 0.04 : importe * 0.21;
    }

    /**
     * Lógica modular para aplicar descuentos.
     */
    public static double aplicarDescuento(double total, int cantidad) {
        // Si el cliente compra más de 3 unidades de un mismo producto, recibe un 10% de descuento
        return (cantidad > 3) ? total * 0.9 : total;
    }
}
