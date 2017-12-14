package pa.edu.uip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int anio;
        BufferedReader x1 = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese el año: ");
        anio = Integer.parseInt(x1.readLine());
        if(anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0){
            System.out.println("El año "+anio+" Si es bisiesto ");
        }else{
            System.out.println("El año "+ anio +" No es bisiesto ");
        }
    }
}
