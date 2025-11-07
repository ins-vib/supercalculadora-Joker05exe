package org.yourcompany.calculadora;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Joan del Tio
 */

public class Calculadora {

    public static void main(String[] args) {
        mostrarMenu();  // Cridem al menú principal
    }

    // Funció que mostra un menú i permet triar una opció
    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcio;

        do {
            System.out.println("\n===== MENÚ DE LA CALCULADORA =====");
            System.out.println("1. Nombre de dígits");
            System.out.println("2. Suma dels primers n números");
            System.out.println("3. Calcular factorial");
            System.out.println("4. Suma dels quadrats");
            System.out.println("5. Calcular potència");
            System.out.println("6. Llançament de moneda");
            System.out.println("7. Preu del cinema");
            System.out.println("0. Sortir");
            System.out.print("Tria una opció: ");
            opcio = sc.nextInt();

            switch (opcio) {
                case 1:
                    System.out.print("Introdueix un nombre: ");
                    int num = sc.nextInt();
                    System.out.println("Nombre de dígits: " + nombreDigits(num));
                    break;

                case 2:
                    System.out.print("Introdueix n: ");
                    int n1 = sc.nextInt();
                    System.out.println("Suma dels primers " + n1 + " números: " + sumaPrimersNumeros(n1));
                    break;

                case 3:
                    System.out.print("Introdueix n: ");
                    int n2 = sc.nextInt();
                    System.out.println("Factorial de " + n2 + ": " + calcularFactorial(n2));
                    break;

                case 4:
                    System.out.print("Introdueix n: ");
                    int n3 = sc.nextInt();
                    System.out.println("Suma dels quadrats dels primers " + n3 + " números: " + sumaQuadrats(n3));
                    break;

                case 5:
                    System.out.print("Introdueix la base: ");
                    int base = sc.nextInt();
                    System.out.print("Introdueix l’exponent: ");
                    int exp = sc.nextInt();
                    System.out.println(base + " elevat a " + exp + " = " + calcularPotencia(base, exp));
                    break;

                case 6:
                    System.out.print("Introdueix quants llançaments vols fer: ");
                    int llan = sc.nextInt();
                    System.out.println(llançamentMoneda(llan));
                    break;

                case 7:
                    System.out.print("És cap de setmana? (true/false): ");
                    boolean capDeSetmana = sc.nextBoolean();
                    System.out.print("Tens carnet jove? (true/false): ");
                    boolean carnet = sc.nextBoolean();
                    System.out.println("Preu: " + PreuCinema(0, capDeSetmana, carnet) + " euros");
                    break;

                case 0:
                    System.out.println("Sortint del programa...");
                    break;

                default:
                    System.out.println("Opció no vàlida.");
                    break;
            }

        } while (opcio != 0);

        sc.close();
    }

    public static int nombreDigits(int nombre) {
        if (nombre == 0) return 1;
        int comptador = 0;
        while (nombre != 0) {
            nombre /= 10;
            comptador++;
        }
        return comptador;
    }

    public static int sumaPrimersNumeros(int n) {
        return n * (n + 1) / 2;
    }

    public static int calcularFactorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int sumaQuadrats(int n) {
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i * i;
        }
        return suma;
    }

    public static int calcularPotencia(int base, int exponent) {
        int resultat = 1;
        for (int i = 1; i <= exponent; i++) {
            resultat *= base;
        }
        return resultat;
    }

    public static String llançamentMoneda(int n) {
        Random rand = new Random();
        int cara = 0;
        int creu = 0;
        while (n-- > 0) {
            if (rand.nextBoolean()) cara++;
            else creu++;
        }
        return "Cara: " + cara + ", Creu: " + creu;
    }

    public static String PreuCinema(double preu, boolean capDeSetmana, boolean carnetJove) {
        double preuDiaLaborable = 5.0;
        double preuCapDeSetmana = preuDiaLaborable * 1.4;
        double descompteCarnetJove = 0.15;

        if (capDeSetmana) preu = preuCapDeSetmana;
        else preu = preuDiaLaborable;

        if (carnetJove) preu -= preu * descompteCarnetJove;

        return String.format("%.2f", preu);
    }
}
