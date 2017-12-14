package pa.edu.uip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        while (opcion != 3) {
            System.out.println("\n\n¡Bienvenido a la Tienda Virtual de Mascotas!");
            System.out.println("Que mascota desea escoger? - MENÚ");
            System.out.println("1. Perro\n2. Gato\n3.Salir");
            System.out.print("OPCION: ");
            try {
                opcion = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("DATA BASURA");
            } catch (Exception e) {
                System.out.println("ERROR DESCONOCIDO");
            }
        }
        switch (opcion) {
            case 1:
                System.out.println("Selecciona una opcion que desee hacer con su perro");
                System.out.println("0. Salirr\n1. Alimentar\n2. Bañar\n4. Jugar");
                System.out.print("Opcion: ");
                try {
                    opcion = Integer.parseInt(br.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("DATA BASURA");
                } catch (Exception e) {
                    System.out.println("ERROR DESCONOCIDO");
                }
                int opc = game.presentaMenu();
                switch(opc){
                    case 0:
                        continuar = false;
                        break;
                    case 1:
                        System.out.println("Alimentado..");
                        game.mascota.alimentar();
                        System.out.println("Nivel de hambre: " + game.mascota.getHambre());
                        break;
                    case 2:
                        System.out.println("Bañado..");
                        game.mascota.bañarse();
                        System.out.println("Nivel de limpieza: " + game.mascota.getLimpieza());
                        break;
                    case 3:
                        System.out.println("Jugando..");
                        game.mascota.jugar();
                        System.out.println("Nivel de limpieza: " + game.mascota.getLimpieza());
                        System.out.println("Nivel de hambre: " + game.mascota.getHambre());
                        System.out.println("Nivel de energia:" + game.mascota.getEnergia());
                        break;
                    default:
                        System.out.println("Opcion incorrecta. Intentalo de nuevo");
                }

                while (continuar) {
                    opc = game.presentaMenu();
                    switch (opc) {
                        case 0:
                            continuar = false;
                            break;
                        case 1:
                            System.out.println("Alimentado..");
                            game.mascota.alimentar();
                            System.out.println("Nivel de hambre: " + game.mascota.getHambre());
                            break;
                        case 2:
                            System.out.println("Bañado..");
                            game.mascota.bañarse();
                            System.out.println("Nivel de limpieza: " + game.mascota.getLimpieza());
                            break;
                        case 3:
                            System.out.println("Jugando..");
                            game.mascota.jugar();
                            System.out.println("Nivel de limpieza: " + game.mascota.getLimpieza());
                            System.out.println("Nivel de hambre: " + game.mascota.getHambre());
                            System.out.println("Nivel de energia:" + game.mascota.getEnergia());
                            break;
                        default:
                            System.out.println("Opcion incorrecta. Intentalo de nuevo");
                    }

                }

                break;
            case 2:

                break;
            case 3:

                break;
            default:
                System.out.println("ERROR :: Opción inválida.");
                break;
        }
    }
}
