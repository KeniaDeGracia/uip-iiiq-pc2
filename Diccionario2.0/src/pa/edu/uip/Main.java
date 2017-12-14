package pa.edu.uip;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Diccionario> palabras = new ArrayList<>();
    static Scanner s = new Scanner(System.in);

    public static void main (String[] args) {
        cargaDatos(); // carga el contenido inicial de lapalabra
        System.out.println("==================BIENVENIDO AL PROGRAMA EMKHARTA.==================\nPara su comodidad se han precargado dos diccionarios con sus correspondientes términos.");
        System.out.println("Pulse [INTRO] para continuar.\n");
        s.nextLine();
        int opcion;
        // Menú
        do {
            System.out.println("\n\nDiccionario General Emkharta\n=================");
            System.out.println("1. Crear diccionario");
            System.out.println("2. Utilizar diccionario");
            System.out.println("3. Listado de diccionarios");
            System.out.println("4. Borrar diccionario");
            System.out.println("5. Buscar palabra exacta");
            System.out.println("6. Buscar palabra por inclusión");
            System.out.println("7. Salir");
            System.out.print("Introduzca una opción: ");
            opcion = Integer.parseInt(s.nextLine());
            switch (opcion) {
                case 1:
                    creaDiccionario();
                    break;
                case 2:
                    utilizaDiccionario();
                    break;
                case 3:
                    listaDiccionarios("\n\nLISTADO DE DICCIONARIOS\n=======================");
                    break;
                case 4:
                    borraDiccionario();
                case 5:
                    buscaPalabraExacta();
                case 6:
                    buscaPalabraPorInclusion();
                    break;
                default:
            } // termina el switch
        } while (opcion != 7);
    } // termina el main

    //Carga las palabras con el diccionarios con los términos.
    public static void cargaDatos() {
        // Diccionario de español
        Diccionario d1 = new Diccionario("Diccionario de español");
        d1.agregaTermino(new Termino("perros", "perro", "animal de compañía que protege la casa"));
        d1.agregaTermino(new Termino("perruno", "perro", "relativo al perro"));
        d1.agregaTermino(new Termino("solar", "sol", "astro rey"));
        d1.agregaTermino(new Termino("comeré", "comer", "en el futuro ingeriré alimentos"));
        d1.agregaTermino(new Termino("caras", "cara", "es el espejo del alma"));
        palabras.add(d1);

        // Diccionario de inglés
        Diccionario d2 = new Diccionario("Diccionario de inglés");
        d2.agregaTermino(new Termino("to come", "come", "venir"));
        d2.agregaTermino(new Termino("cars", "car", "carro"));
        palabras.add(d2);
    }
    //Crea un nuevo diccionario. El identificador lo establece en la lista

    public static void creaDiccionario() {
        System.out.println("\n\nCREAR DICCIONARIO\n=============");
        System.out.print("Descripción: ");
        String descripcion = s.nextLine();
        palabras.add(new Diccionario(descripcion));
    }

    //Utiliza un diccionario cuyo código se pide por teclado.
    public static void utilizaDiccionario() {
        System.out.println("\n\nUTILIZAR DICCIONARIOS\n======================");

        listaDiccionarios(); // Se listan primero los diccionarios existentes

        System.out.print("\nPor favor, introduzca el numero del diccionario que quiere utilizar: ");
        int identificador = Integer.parseInt(s.nextLine());

        Diccionario diccionarioGestionado = (Diccionario) null;

        boolean existeDiccionario = false;

        for (Diccionario d : palabras) {
            if (d.getIdentificador() == identificador) {
                diccionarioGestionado = d;
                existeDiccionario = true;
            }
        }

        if (!existeDiccionario) {
            System.out.println("No se ha encontrado ningún diccionario con ese identificador.");
        } else {
            (new UtilizarDiccionario(diccionarioGestionado)).iniciaGestionDiccionario();
        }
    }

    ///Muestra un listado con todos los diccionarios que hay en el programa.
    public static void listaDiccionarios() {
        for (Diccionario d : palabras) {
            System.out.println(d);
        }
    }
    //Muestra un listado de diccionarios con un título.
    public static void listaDiccionarios(String titulo) {
        System.out.println(titulo);
        listaDiccionarios();
    }
    //Borra un diccionario pidiendo su identificador.
    //Si el usuario introduce un identificado que no existe, muestra un mensaje de error.
     public static void borraDiccionario() {
        System.out.println("\n\nBORRAR DICCIONARIO\n===========================");

        System.out.print("\nPor favor, introduzca el identificador del diccionario: ");
        int identificador = Integer.parseInt(s.nextLine());

        int posicion = -1;

        for (int i = 0; i < palabras.size(); i++) {
            if (palabras.get(i).getIdentificador() == identificador) {
                posicion = i;
            }
        }

        if (posicion == -1) {
            System.out.println("No se ha encontrado ningún diccionario con ese identificador.");
        } else {
            palabras.remove(posicion);
            System.out.println("Diccionario borrado correctamente.");
        }
    }
    //Busca en todos los diccionarios una palabra que coincide exactamente con la que introduce el usuario.
    public static void buscaPalabraExacta() {
        System.out.println("\n\nBUSCAR PALABRA EXACTA\n=====================");
        System.out.print("\nPor favor, introduzca una palabra (se buscará en todos los diccionarios): ");
        String palabra = s.nextLine();

        int cuentaPalabras = 0;

        for (Diccionario d : palabras ) {
            for (Termino t : d.getTerminos()) {
                if (t.getPalabra().equalsIgnoreCase(palabra)) {
                    System.out.println(t);
                    cuentaPalabras++;
                }
            }
        }

        System.out.println("Encontradas " + cuentaPalabras + " palabras.");
    }

    //Busca en todos los diccionarios una palabra que coincide parcialmente con la que introduce el usuario
    //Por ejemplo, la búsqueda de "car" encaja con "caras" y "cars".
    public static void buscaPalabraPorInclusion() {
        System.out.println("\n\nBUSCAR PALABRA POR INCLUSIÓN\n============================");
        System.out.print("\nPor favor, introduzca una palabra (se buscará en todos los diccionarios): ");
        String palabra = s.nextLine();

        int cuentaPalabras = 0;

        for (Diccionario d : palabras ) {
            for (Termino t : d.getTerminos()) {
                if (t.getPalabra().toLowerCase().contains(palabra.toLowerCase())) {
                    System.out.println(t);
                    cuentaPalabras++;
                }
            }
        }

        System.out.println("Encontradas " + cuentaPalabras + " palabras.");
    }
}