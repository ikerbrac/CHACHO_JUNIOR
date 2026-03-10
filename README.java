import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Datos de entrada: precio, cantidad, tipo de producto (1: Alimento, 2: Electronica)
        double[] p = {10.5, 20.0, 5.75, 100.0};
        int[] c = {2, 1, 5, 1};
        int[] t = {1, 2, 1, 2};
        double tt = 0;

        for (int i = 0; i < p.length; i++) {
            double sub = p[i] * c[i];
            double imp = 0;

            // Calcular impuesto segun tipo
            if (t[i] == 1) {
                imp = sub * 0.04; // IVA Superreducido
            } else if (t[i] == 2) {
                imp = sub * 0.21; // IVA General
            }

            double res = sub + imp;
            
            // Descuento si la cantidad es grande
            if (c[i] > 3) {
                res = res - (res * 0.1);
            }

            System.out.println("Item " + i + ": " + res);
            tt += res;
        }

        System.out.println("TOTAL FINAL: " + tt);
        
        // Parte interactiva innecesariamente mezclada
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Confirmar pedido? (s/n)");
        String s = sc.nextLine();
        if (s.equals("s")) {
            System.out.println("Guardando...");
        }
    }
}
