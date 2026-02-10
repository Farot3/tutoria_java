
package practica1;

import java.util.Random;
import java.util.Scanner;

public class Practica1 {


    public static String[][] tablero = new String[8][8];
    public static String[][] penalizaciones = new String[8][8];
    
    public static boolean continuarJuego = true;
    public static boolean juegoEnPausa = false;
    public static Scanner inputData = new Scanner(System.in);

    public static Scanner inputString = new Scanner(System.in);

    public static String simbolo = " @";
   
    public static int position = 1;


    public static int nivelPenalizacion = -99;
    private static int[][] suma1;

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("==============Menu Principal============");
            System.out.println("1. Iniciar nuevo Juego");
            System.out.println("2. Volver al Juego");
            System.out.println("3. Información del estudiante");
            System.out.println("4. Salir");
            System.out.println("=======================================");
            System.out.print("Elige una opcion: ");
            opcion = inputData.nextInt();
            menu_opciones(opcion);
        } while (opcion != 4);

    }
    
  

    public static void menu_opciones(int opcion) {
        switch (opcion) {
            case 1:
                if (juegoEnPausa){
                    System.out.println("Ya hay juego en pausa. Por favor debe de retomar el juego salir del juego");
                }else{
                  System.out.println(" Partida Iniciada");
                llenarMatriz();
                
                llenarPenalizaciones();

                elegirOpcion();
                }

                break;
            case 2:
                if (juegoEnPausa){
                    System.out.println("Retomando el juego que ya ha comenzado...");
                    elegirOpcion();
                }else{
                    System.out.println("No hay ningun juego en pausa que tiene que retomar");
                }
                
                System.out.println("Volver al juego");
                break;
            case 3:
            System.out.println("Nombre: Ottoniel Fabricio Vásquez Pineda");
            System.out.println("Carné: 202307820");
            System.out.println("Sección: D");
                         
            break;
            case 4:
                System.out.println("se cerro el juego");
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public static void llenarMatriz() {
        int contador = 1;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = String.valueOf(contador);
                contador++; 
            }
        }

        
        for (int i = 0; i < penalizaciones.length; i++) {
            for (int j = 0; j < penalizaciones[i].length; j++) {
                penalizaciones[i][j] = " ";
            }
        }

    }
 
    public static void llenarPenalizaciones() {
        
      double[][] opciones = {{15, 20, 25}, {25, 10, 30}, {18, 25, 30}};

        Random random = new Random();

        int cantidadPenalizaciones;
        int posicionAleatoria;
        
/* while (continuarJuego){*/
        for (int i = 0; i < penalizaciones.length; i++) {


            cantidadPenalizaciones = random.nextInt(3) + 2;

            while (cantidadPenalizaciones != 0) {

                while (true) {
                    posicionAleatoria = random.nextInt(penalizaciones[i].length);

                    if (!penalizaciones[i][posicionAleatoria].contains("#")) {
                        break;
                    }
                    }
                    
                penalizaciones[i][posicionAleatoria] = "#" + penalizaciones[i][posicionAleatoria];
                             
                cantidadPenalizaciones--;
                
        }
    }
    }


    public static void imprimirInferiorDerecha() {
        System.out.println("=================================================");
        boolean bandera = false;
        String casilla;
        for (int i = tablero.length - 1; i >= 0; i--) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print("+------");
            }

            System.out.println("+");


            for (int j = tablero.length - 1; j >= 0; j--) {

                if (bandera == true) {
                    casilla = penalizaciones[i][j] + tablero[i][j];
                    

                    System.out.printf("| %4s ", casilla);
                } else {
                    casilla = penalizaciones[i][(tablero.length - 1) - j] + tablero[i][(tablero.length - 1) - j];
                   
                    System.out.printf("| %4s ", casilla);
                }

            }
            System.out.println("|");

            for (int j = tablero.length - 1; j >= 0; j--) {
                if (bandera == true) {
                    if (position == Integer.parseInt(tablero[i][j])) {
                        System.out.printf("| %4s ", simbolo);

                        if (penalizaciones[i][j].contains("#")) {
                            nivelPenalizacion = i + 1;
                        }

                    } else {
                        System.out.printf("| %4s ", " ");
                    }
                } else {

                    if (position == Integer.parseInt(tablero[i][(tablero.length - 1) - j])) {
                        System.out.printf("| %4s ", simbolo);
                        if (penalizaciones[i][(tablero.length - 1) - j].contains("#")) {
                            nivelPenalizacion = i + 1;
                        }
                    } else {
                        System.out.printf("| %4s ", " ");
                    }

                }
            }

            System.out.println("|");
            bandera = !bandera;

        }

        for (int j = 0; j < 8; j++) {

            System.out.print("+------");
        }
        System.out.println("+");

    }

    public static void elegirOpcion() {
        String elegir;
        Random random = new Random();
        int dado;
        do {

            if (position > 64) {
                System.out.println(" Ganaste el juego");
                break;
            }
            
            imprimirInferiorDerecha();

            niveles_Penalizacion();
            System.out.println(" Lanzar dado (d)");
            System.out.println(" Pausar Juego (p)");
            elegir = inputString.nextLine();

            if (elegir.equals("d")) {
                dado = random.nextInt(6) + 1;
                System.out.println("El dado cayo en: " + dado);
                position += dado;

            } else if (elegir.equals("p")) {
                System.out.println("Menu");
                juegoEnPausa = true;
              break;
            
            } else {
                System.out.println("Opcion no valida");
                
            }  
        } while (!elegir.equals("p"));
        
}
    
    
    public static boolean Penalizacion1() {
        Random random = new Random();
        int pregunta = random.nextInt(3) + 1;       
        double ladoA;
        double ladoB;
        double anguloA;
        
        switch (pregunta) {
            case 1:
                
              ladoA = 15;
              ladoB = 20;
              anguloA = 25;

                break;
            case 2:
                
              ladoA = 10;
              ladoB = 25;
              anguloA = 30;
        
                break;
            default:
                
             ladoA = 18;
             ladoB = 25;
             anguloA = 30;
        
                break;
        }
               
        double ladoC = Math.sqrt(ladoA * ladoA + ladoB * ladoB - 2 * ladoA * ladoB * Math.cos(Math.toRadians(anguloA)));
        
        double anguloB = Math.acos((ladoB * ladoB - ladoA * ladoA - ladoC * ladoC) / (-2 * ladoA * ladoC)) * 180 / Math.PI;
        double anguloC = 180 - anguloA - anguloB;
        
        ladoC = Math.round(ladoC * 1000.0) / 1000.0;
        anguloB = Math.round(anguloB * 1000.0) / 1000.0;
        anguloC = Math.round(anguloC * 1000.0) / 1000.0;

        System.out.println("\nIngrese datos con solo 3 decimales aproximados");
        System.out.println("El lado A es: " + ladoA);
        System.out.println("El lado B es: " + ladoB);
        System.out.println("El ángulo A es: " + anguloA);

        System.out.println("Ingrese el lado C:");
        double ladoCUsuario = inputData.nextDouble();

        System.out.println("Ingrese el ángulo B:");
        double anguloBUsuario = inputData.nextDouble();

        System.out.println("Ingrese el ángulo C:");
        double anguloCUsuario = inputData.nextDouble();

        if (ladoC == ladoCUsuario && anguloB == anguloBUsuario && anguloC == anguloCUsuario) {
            System.out.println("Bien guerrero, has pasado la prueba");
            return true;
        } else {
            System.out.println("\nEstudie más por favor");
            System.out.println("\nla respuesta correcta es:");
            System.out.println("El lado C es: " + ladoC);
            System.out.println("El ángulo B es: " + anguloB);
            System.out.println("El ángulo C es: " + anguloC);
            return false;
        }
    }
    
    public static boolean Penalizacion2() {
    Random random = new Random();
    int pregunta = random.nextInt(3) + 1; 
    double[][] suma1;

    switch (pregunta) {
        case 1:
            System.out.println("Para continuar resuelva la sumatoria de las siguientes 2 matrices");
            System.out.println("Matriz A");
            int[][] matrizA = {
                    {7, 48, 5, 0, 1},
                    {57, 8, 4, 6, 14},
                    {0, 5, 6, 78, 15},
                    {21, 14, 8, 19, 54},
                    {32, 20, 26, 47, 12}
            };
            imprimirMatriz(matrizA);

            System.out.println("\nMatriz B");
            int[][] matrizB = {
                    {9, 5, 2, 1, 8},
                    {4, 2, 3, 47, 8},
                    {48, 55, 32, 19, 6},
                    {7, 56, 32, 14, 8},
                    {32, 87, 0, 1, 7}
            };
            imprimirMatriz(matrizB);

            suma1 = new double[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    suma1[i][j] = matrizA[i][j] + matrizB[i][j];
                }
            }
            break;

        case 2:
            System.out.println("Para continuar resuelva la sumatoria de las siguientes 2 matrices");
            System.out.println("Matriz A");
            int[][] matrizA1 = {
                    {4, 9, 7, 45, 18},
                    {57, 8, 4, 6, 14},
                    {0, 5, 6, 78, 15},
                    {21, 14, 8, 19, 54},
                    {32, 20, 26, 47, 12}
            };
            imprimirMatriz(matrizA1);

            System.out.println("\nMatriz B");
            int[][] matrizB1 = {
                    {9, 5, 2, 1, 8},
                    {4, 2, 3, 47, 8},
                    {48, 55, 32, 19, 6},
                    {7, 56, 32, 14, 8},
                    {32, 87, 0, 1, 7}
            };
            imprimirMatriz(matrizB1);

            suma1 = new double[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    suma1[i][j] = matrizA1[i][j] + matrizB1[i][j];
                }
            }
            break;

        default:
            System.out.println("Para continuar resuelva la sumatoria de las siguientes 2 matrices");
            System.out.println("Matriz A");
            int[][] matrizA2 = {
                    {7, 48, 5, 0, 1},
                    {57, 8, 4, 6, 14},
                    {0, 5, 6, 78, 15},
                    {21, 14, 8, 19, 54},
                    {32, 20, 26, 47, 12}
            };
            imprimirMatriz(matrizA2);

            System.out.println("\nMatriz B");
            int[][] matrizB2 = {
                    {9, 5, 2, 1, 8},
                    {4, 2, 3, 47, 8},
                    {48, 55, 32, 19, 6},
                    {7, 56, 32, 14, 8},
                    {32, 87, 0, 1, 7}
            };
            imprimirMatriz(matrizB2);

            suma1 = new double[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    suma1[i][j] = matrizA2[i][j] + matrizB2[i][j];
                }
            }
            break;
    }

    double[][] respuestaUsuario1 = new double[5][5];
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            System.out.println("Por favor, ingresa el valor para la celda [" + i + "][" + j + "] de la matriz resultante:");
            respuestaUsuario1[i][j] = inputData.nextDouble();
        }
    }

    // Verificar si la respuesta del usuario es correcta
    boolean esCorrecto = true;
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            if (respuestaUsuario1[i][j] != suma1[i][j]) {
                esCorrecto = false;
                break;
            }
        }
        if (!esCorrecto) {
            break;
        }
    }

    if (esCorrecto) {
        System.out.println("Vamos así se hace, cada vez más cerca de ganar");
        return true;
    } else {
        System.out.println("Lo siento, la matriz que ingresaste no es correcta, haz perdido tu oportunidad de seguir");
        System.out.println("\nla respuesta correcta de la suma de matriz: ");
        imprimirMatriz(suma1);
    }
    return false;
}


      public static boolean trespenalizacion() {
        Random random = new Random();
        int pregunta = random.nextInt(3) + 1; // Genera un número aleatorio entre 1 y 3.       
        int determinante;
        int[][] adjunta;
        double[][] inversa;
        double [][] resultado;
        int filas1;
        int columnas1;
        int columnas2;
                
        switch (pregunta) {
            case 1:
                System.out.println("Para continuar resuelva division de las 2 matrices");
                System.out.println("Matriz A");
                  int [][] matriz1 = {
                  {5, 10, 1, 3},
                  {9, 14, 2, 6},
                  {7, 8, 15, 3},
                  {6, 8, 9, 2}
     };
             imprimirMatriz(matriz1);
     
                System.out.println("\nMatriz B");
                int [][] matrizB = {
                  {5, 13, 9, 4},
                  {1, 9, 6, 3},
                  {8, 11, 69, 33},
                  {25, 6, 7, 4}
     };           
             imprimirMatriz(matrizB);
             determinante = calcularDeterminante(matrizB);
             
             adjunta = calcularAdjunta(matrizB); 
             inversa = calcularInversa(matrizB, determinante, adjunta);
             
             filas1 = matriz1.length;
             columnas1 = matriz1[0].length;
             columnas2 = matrizB[0].length;
               resultado = new double[filas1][columnas2];

            for (int i = 0; i < filas1; i++) {
                for (int j = 0; j < columnas2; j++) {
                     for (int k = 0; k < columnas1; k++) {
                  resultado[i][j] += matriz1[i][k] * inversa[k][j];   
            }
        }
    }    
                break;

            default:
                 System.out.println("Para continuar resuelva la división de las 2 matrices");
                System.out.println("Matriz A");
                int [][] matrizA2 = {
                  {1, 12, 9, 8},
                  {7, 6, 3, 2},
                  {0, 5, 6, 14},
                  {6, 9, 6, 10}
     };

                imprimirMatriz(matrizA2);
     
                System.out.println("\nMatriz B");
                int [][] matrizB2 = {
                  {8, 19, 20, 4},
                  {12, 33, 6, 8},
                  {4, 5, 9, 7},
                  {8, 22, 14, 6}                           
     };           
             imprimirMatriz(matrizB2);
             determinante = calcularDeterminante(matrizB2);
             
             adjunta = calcularAdjunta(matrizB2); 
             inversa = calcularInversa(matrizB2, determinante, adjunta);
             
             filas1 = matrizA2.length;
             columnas1 = matrizA2[0].length;
             columnas2 = matrizB2[0].length;
               resultado = new double[filas1][columnas2];

            for (int i = 0; i < filas1; i++) {
                for (int j = 0; j < columnas2; j++) {
                     for (int k = 0; k < columnas1; k++) {
                  resultado[i][j] += matrizA2[i][k] * inversa[k][j];
              }
           }
       }
                break;              
        }

         double[][] respuestaUsuario1 = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("\nSolo con 3 decimales escribe");
                System.out.println("Por favor, ingresa el valor para la celda [" + i + "][" + j + "] de la matriz resultante:");
                respuestaUsuario1[i][j] = inputData.nextInt();
            }
        }

        // Verificar si la respuesta del usuario es correcta
        boolean esCorrecto = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (respuestaUsuario1[i][j] != resultado[i][j]) {
                    esCorrecto = false;
                    break;
                }
                 
            }
            if (!esCorrecto) {
                break;
            }
        }
         
  if (esCorrecto) {
            System.out.println("Ya casi terminas, ya solo faltan pocas casiilas");
            return true;
        } else {
            System.out.println("Lo siento, la matriz que ingresaste no es correcta, esfuerzate mas para la proxima");
            System.out.println("La respuesta correcta de la división de matrices es: ");
            imprimirMatriz(resultado);
        }
        return false;
     }
            
        
      
     
    public static void niveles_Penalizacion() {

        if (nivelPenalizacion == 1 || nivelPenalizacion == 2) {

            System.out.println("Estoy en nivel facil de penalizacion");
            
             if(position <= 16){
                if(!Penalizacion1()) {
                    System.out.println("Juego terminado");
                    juegoEnPausa = false;
                    System.exit(0); 
                }
            }
        } else if (nivelPenalizacion == 3 || nivelPenalizacion == 4 || nivelPenalizacion == 5) {
            
            System.out.println("Estoy en nivel intermedio de penalizacion");
            
            if(position > 16 && position <= 40){
                if(!Penalizacion2()) {
                    System.out.println("Juego terminado");
                    juegoEnPausa = false;
                    System.exit(0);
                }
            }
        } else if (nivelPenalizacion == 6 || nivelPenalizacion == 7 || nivelPenalizacion == 8) {
            System.out.println("Estoy en nivel dificil de penalizacion");
            if(position > 40 && position <= 64){
                if(!trespenalizacion()) {
                    System.out.println("Juego terminado");
                    juegoEnPausa = false;
                    System.exit(0);
                }
            }
        }

        nivelPenalizacion = -99;
    }
    
    public static void imprimirMatriz(int[][] matriz) {
    for (int[] fila : matriz) {
        for (int valor : fila) {
            System.out.printf(" | %2d | ", valor);
        }
        System.out.println("\n" + "------------------------------------");
    }
}

public static void imprimirMatriz(double[][] matriz) {
    for (double[] fila : matriz) {
        for (double valor : fila) {
            System.out.printf(" | %.3f | ", valor);
        }
        System.out.println("\n" + "------------------------------------");
    }
}
public static int calcularDeterminante(int[][] matriz) {
        int determinante = 0;
        
        if (matriz.length == 2) {
            determinante = matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        } else { 
            for (int i = 0; i < matriz.length; i++) {
                determinante += matriz[0][i] * cofactor(matriz, 0, i);
            }
        }
        
        return determinante;
    } 
    
    public static int[][] calcularAdjunta(int[][] matriz) {
        int[][] adjunta = new int[matriz.length][matriz.length];
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                adjunta[j][i] = cofactor(matriz, i, j);
            }
        }
        
        return adjunta;
    }

    // Método para calcular el cofactor
    public static int cofactor(int[][] matriz, int fila, int columna) {
        int[][] submatriz = new int[matriz.length - 1][matriz.length - 1];
        int submatrizFila = 0, submatrizColumna = 0;
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i != fila && j != columna) {
                    submatriz[submatrizFila][submatrizColumna++] = matriz[i][j];
                    if (submatrizColumna == matriz.length - 1) {
                        submatrizColumna = 0;
                        submatrizFila++;
                    }
                }
            }
        }
        
        return (int) Math.pow(-1, fila + columna) * calcularDeterminante(submatriz);
    }
    
     
    public static double[][] calcularInversa(int[][] matriz, int determinante, int[][] adjunta) {
        double[][] inversa = new double[matriz.length][matriz.length];
        double inversoDeterminante = 1.0 / determinante;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                inversa[i][j] = adjunta[i][j] * inversoDeterminante;
            }
        }

        return inversa;
    }
    
}
