package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("emkharta.fxml"));
        primaryStage.setTitle("DICCIONARIO ENCICLOPEDICO EMKHARTA");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        int opcion = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> diccionario = new HashMap<>();
        diccionario.put("diccionario", "Repertorio en forma de libro o en soporte electrónico en el que se recogen las palabras de una o más lenguas.");
        diccionario.put("universidad", "Institución de enseñanza superior que comprende diversas facultades");
        diccionario.put("java", "Lenguaje de programación de propósito general, concurrente, orientado a objetos");
        diccionario.put("reprobar", "Declarar a una persona no apta en un examen, una prueba o una asignatura.");

        while (opcion != 4) {
            System.out.println("\n\nDICCIONARIO ENCICLOPEDICO EMKHARTA");
            System.out.println("1. Ver palabras\n2. Definicion\n3. Agregar\n4. Salir");
            System.out.print("OPCION: ");
            try {
                opcion = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Incorrecto");
            } catch (Exception e) {
                System.out.println("ERROR");
            }

            switch (opcion) {
                case 1:
                    for (HashMap.Entry<String, String> palabra : diccionario.entrySet()) {
                        System.out.print(palabra.getKey() + ", ");
                    }
                    break;
                case 2:
                    String p = "";
                    boolean encontrado = false;
                    while (p.equals("") || p.equals(" ") || p.equals("-")) {
                        System.out.print("Palabra: ");
                        try {
                            p = br.readLine();
                        } catch (Exception e) {
                            System.out.println("Error");
                        }
                    }
                    for (HashMap.Entry<String, String> palabra : diccionario.entrySet()) {
                        if (p.toLowerCase().equals(palabra.getKey())) {
                            encontrado = true;
                            System.out.println("Definición: " + palabra.getValue());
                        }
                    }
                    if (encontrado == false) {
                        System.out.println("Esa palabra no está en el diccionario.");
                    }
                    break;
                case 3:
                    String pal = "", tra = "";
                    while (pal.equals("") || pal.equals(" ") || pal.equals("-")) {
                        System.out.print("Palabra: ");
                        try {
                            pal = br.readLine();
                        } catch (Exception e) {
                            System.out.println("Error");
                        }
                    }
                    while (tra.equals("") || tra.equals(" ") || tra.equals("-")) {
                        System.out.print("Definición: ");
                        try {
                            tra = br.readLine();
                        } catch (Exception e) {
                            System.out.println("Error");
                        }
                    }
                    diccionario.put(pal, tra);
                    break;
                case 4:
                    System.out.print("¡BYE!");
                    break;
                default:
                    System.out.println("ERROR :: Opción inválida.");
                    break;
            }
        }

        System.out.println("\nFELICES FIESTAS!");
    }
}
