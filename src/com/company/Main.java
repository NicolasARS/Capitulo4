package com.company;
import java.util.Scanner;

/**
 * Clase Fecha: 28/02/2023
 * Genera todos los numeros primos de 1 hasta un numero maximo especificado por el usuario
 * @author Nicolas Alejandro Rivera Sotomonte
 * @version 1
 * @see <a href ="https://es.wikipedia.org/wiki/Criba_de_Erat%C3%B3stenes">Criba de Eratóstenes</a>
 */
public class Main {
    /**
     * Método principal que recibe la entrada del usuario y llama a los métodos para generar los números primos y imprimir los resultados.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número para la criba de Eratóstenes: ");
        int numero = scanner.nextInt();

        int[] primos = generarPrimos(numero);

        System.out.println("\nVector inicial hasta " + numero + ":");
        imprimirNumerosHasta(numero);

        System.out.println("\nVector de primos hasta " + numero + ":");
        imprimirNumeros(primos);
        System.out.println();
    }

    /**
     * Genera un array de números primos utilizando la Criba de Eratóstenes.
     * @param maximo el número máximo hasta el cual se generarán los números primos.
     * @return un array de enteros que contiene los números primos encontrados.
     */
    public static int[] generarPrimos(int maximo) {
        if (maximo < 2) {
            return new int[0]; // Vector vacío
        }

        boolean[] esPrimo = new boolean[maximo + 1];
        for (int i = 2; i <= maximo; i++) {
            esPrimo[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(maximo); i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= maximo; j += i) {
                    esPrimo[j] = false;
                }
            }
        }

        int cantidad = 0;
        for (int i = 2; i <= maximo; i++) {
            if (esPrimo[i]) {
                cantidad++;
            }
        }

        int[] primos = new int[cantidad];
        for (int i = 2, j = 0; i <= maximo; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }

        return primos;
    }

    /**
     * Imprime los números enteros de 1 hasta el número máximo especificado, 10 por línea.
     * @param maximo el número máximo a imprimir.
     */
    public static void imprimirNumerosHasta(int maximo) {
        for (int i = 1; i <= maximo; i++) {
            if (i > 1 && i % 10 == 1) {
                System.out.println();
            }
            System.out.print(i + "\t");
        }
    }

    /**
     * Imprime los números enteros contenidos en el array especificado, 10 por línea.
     * @param numeros el array de enteros a imprimir.
     */
    public static void imprimirNumeros(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            if (i > 0 && i % 10 == 0) {
                System.out.println();
            }
            System.out.print(numeros[i] + "\t");
        }
    }
}