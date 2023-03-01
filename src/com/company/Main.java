package com.company;
import java.util.Scanner;

public class Main {
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

    // Generar números primos de 1 a maximo
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

    // Imprimir números de 1 a máximo, 10 por línea
    public static void imprimirNumerosHasta(int maximo) {
        for (int i = 1; i <= maximo; i++) {
            if (i > 1 && i % 10 == 1) {
                System.out.println();
            }
            System.out.print(i + "\t");
        }
    }

    // Imprimir números, 10 por línea
    public static void imprimirNumeros(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            if (i > 0 && i % 10 == 0) {
                System.out.println();
            }
            System.out.print(numeros[i] + "\t");
        }
    }
}