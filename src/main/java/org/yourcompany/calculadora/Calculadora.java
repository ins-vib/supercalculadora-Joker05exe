package org.yourcompany.calculadora;

import java.util.Random;
import java.util.Scanner;

/**
 * Calculadora amb diverses funcions matemàtiques i simulacions.
 * Permet calcular dígits, suma, factorial, potències, llançaments de moneda i preu del cinema.
 * Autor: Joan del Tio
 */
public class Calculadora {

    /**
     * Mètode principal. Inicia el programa mostrant el menú.
     * @param args arguments de línia de comandes (no s'utilitzen)
     */
    public static void main(String[] args) {
        mostrarMenu();  // Crida al menú principal
    }

    /**
     * Mostra el menú de l'aplicació i processa les opcions de l'usuari.
     * Permet triar entre diverses funcions matemàtiques i simulacions.
     */
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

    /**
     * Calcula el nombre de dígits d'un nombre enter.
     * @param nombre El nombre del qual volem comptar els dígits
     * @return Nombre de dígits
     */
    public static int nombreDigits(int nombre) {
        if (nombre == 0) return 1;
        int comptador = 0;
        while (nombre != 0) {
            nombre /= 10;
            comptador++;
        }
        return comptador;
    }

    /**
     * Calcula la suma dels primers n números naturals.
     * @param n Nombre fins al qual volem sumar
     * @return Suma dels primers n números
     */
    public static int sumaPrimersNumeros(int n) {
        return n * (n + 1) / 2;
    }

    /**
     * Calcula el factorial d'un número.
     * @param n Nombre del qual volem calcular el factorial
     * @return Factorial de n
     */
    public static int calcularFactorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    /**
     * Calcula la suma dels quadrats dels primers n números naturals.
     * @param n Nombre fins al qual volem sumar els quadrats
     * @return Suma dels quadrats dels primers n números
     */
    public static int sumaQuadrats(int n) {
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i * i;
        }
        return suma;
    }

    /**
     * Calcula la potència d'una base elevada a un exponent.
     * @param base Base
     * @param exponent Exponent
     * @return Base elevada a l'exponent
     */
    public static int calcularPotencia(int base, int exponent) {
        int resultat = 1;
        for (int i = 1; i <= exponent; i++) {
            resultat *= base;
        }
        return resultat;
    }

    /**
     * Simula llançaments de moneda.
     * @param n Nombre de llançaments
     * @return String amb el recompte de cares i creus
     */
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

    /**
     * Calcula el preu del cinema segons si és cap de setmana i si té carnet jove.
     * @param preu Preu inicial (no s'utilitza directament)
     * @param capDeSetmana True si és cap de setmana
     * @param carnetJove True si té carnet jove
     * @return Preu final amb descompte aplicat, formatat a 2 decimals
     */
    public static String PreuCinema(double preu, boolean capDeSetmana, boolean carnetJove) {
        double preuDiaLaborable = 5.0;
        double preuCapDeSetmana = preuDiaLaborable * 1.4; // augment del 40% el cap de setmana
        double descompteCarnetJove = 0.15;                // descompte 15%

        if (capDeSetmana) preu = preuCapDeSetmana;
        else preu = preuDiaLaborable;

        if (carnetJove) preu -= preu * descompteCarnetJove;

        return String.format("%.2f", preu);
    }
}
