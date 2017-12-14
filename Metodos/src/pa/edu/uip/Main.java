package pa.edu.uip;

import java.util.Scanner;
import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;

public class Main {
    private double suma;
    public static void main(String[] args) {
        new Main().aplicacion(); }

        private void aplicacion() {

        //Inicio del Programa
        Scanner s = new Scanner(System.in);
        System.out.println("\nCálculo de la integral por el método del Trapecio");

        //Solicitud de valores necesarios: a, b y n
        System.out.print("Ingrese el valor de a: ");
        double a = s.nextDouble();
        System.out.print("Ingrese el valor de b: ");
        double b = s.nextDouble();
        System.out.print("Ingrese el valor de n: ");
        double n = s.nextDouble();
        //Buscar el valor de h
        double h = (b - a) / n;
        //Metodo de Trapecio
        for (int j = 1; j <= n-1 ; ++j) {
            suma = suma + f(a + j * h);
        }
        double I = (h / 2) * (f(a) + 2 * suma + f(b));

        System.out.println("El valor de la integral es: " + I + "\n");
    }
    private double f(double x) {
    // Función de prueba: sqrt(16-(pow(x,2)))
        return sqrt(16-(pow(x,2)));
    }
}