import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] precios = {10.5, 20.0, 5.75, 100.0};
        int[] cantidades = {2, 1, 5, 1};
        int[] tipos = {1, 2, 1, 2};

        double totalFinal = 0;
        for (int i = 0; i < precios.length; i++) {
            double subtotal = precios[i] * cantidades[i];
            double impuesto = 0;

            if (tipos[i] == 1) {
                impuesto = subtotal * 0.04;
            } else if (tipos[i] == 2) {
                impuesto = subtotal * 0.21;
            }
            double resultadoItem = subtotal + impuesto;

            if (cantidades[i] > 3) {
                resultadoItem = resultadoItem - (resultadoItem * 0.1);
            }
            System.out.println("Item " + i + ": " + resultadoItem);
            totalFinal += resultadoItem;
        }
        System.out.println("TOTAL FINAL: " + totalFinal);

        Scanner sc = new Scanner(System.in);
        System.out.println("¿Confirmar pedido? (s/n)");
        String respuesta = sc.nextLine();
        if (respuesta.equals("s")) {
            System.out.println("Guardando...");
        }
    }
}
