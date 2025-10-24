

package org.yourcompany.calculadora;
import java.util.Random;



/**
 *
 * @author Joan del Tio
 */


public class Calculadora {

    public static void main(String[] args) {

        // Exemples de crida per al mètode nombreDigits
        System.out.println("Nombre de dígits de 1234: " + nombreDigits(1234));
        System.out.println("Nombre de dígits de 56789: " + nombreDigits(56789));
        System.out.println("Nombre de dígits de -101010: " + nombreDigits(-101010));
        System.out.println("Nombre de dígits de 0: " + nombreDigits(0));

        // Exemples de crida per al mètode sumaPrimersNumeros
        System.out.println("Suma dels primers 5 números: " + sumaPrimersNumeros(5));
        System.out.println("Suma dels primers 10 números: " + sumaPrimersNumeros(10));
        System.out.println("Suma dels primers 15 números: " + sumaPrimersNumeros(15));

        // Exemples de crida per al mètode calcularFactorial
        System.out.println("Factorial de 5: " + calcularFactorial(5));
        System.out.println("Factorial de 7: " + calcularFactorial(7));
        System.out.println("Factorial de 10: " + calcularFactorial(10));

        // Exemples de crida per al mètode sumaQuadrats
        System.out.println("Suma dels quadrats dels primers 3 números: " + sumaQuadrats(3));
        System.out.println("Suma dels quadrats dels primers 5 números: " + sumaQuadrats(5));
        System.out.println("Suma dels quadrats dels primers 7 números: " + sumaQuadrats(7));

        // Exemples de crida per al mètode calcularPotencia
        System.out.println("2 elevat a la potència 3: " + calcularPotencia(2, 3));
        System.out.println("5 elevat a la potència 4: " + calcularPotencia(5, 4));
        System.out.println("3 elevat a la potència 5: " + calcularPotencia(3, 5));

        // Exemple de crida per al mètode llançamentMoneda
        System.out.println("Llançament d'una moneda 10 vegades:");
        System.err.println(llançamentMoneda(50));
        System.out.println("Llançament d'una moneda 20 vegades:");
        System.err.println(llançamentMoneda(50));
        System.out.println("Llançament d'una moneda 50 vegades:");
        System.err.println(llançamentMoneda(50));

        // Exemple de crida per al mètode PreuCinema
        System.out.println("Preu del cinema un dia laborable sense carnet jove: " + PreuCinema(0, false, false) + " euros");
        System.out.println("Preu del cinema un cap de setmana sense carnet jove: " + PreuCinema(0, true, false) + " euros");
        System.out.println("Preu del cinema un dia laborable amb carnet jove: " + PreuCinema(0, false, true) + " euros");
        System.out.println("Preu del cinema un cap de setmana amb carnet jove: " + PreuCinema(0, true, true) + " euros");



       
        
    }

    /**
     * Calcula el nombre de dígits d’un número enter.
     * Funciona tant per a nombres positius com negatius.
     * Si el nombre és 0, retorna 1.
     *
     * @param nombre Número del qual es vol saber el nombre de dígits
     * @return Quantitat de dígits que té {@code nombre}
     */
    public static int nombreDigits(int nombre) {
        if (nombre == 0) {
            return 1; // el 0 té un dígit
        }        
        int comptador = 0;
        while (nombre != 0) {
            nombre /= 10;
            comptador++;
        }
        return comptador;
    }
    public static int sumaPrimersNumeros(int n) {
        // Logica per calcular la suma dels primers n números enters
        return n * (n + 1) / 2;
        

    }
    public static int calcularFactorial(int n) {
        // Logica per calcular el factorial de n
        int factorial = 1;
    for (int i = 1; i <= n; i++) {
        factorial = factorial * i;
    }
    return factorial;
}
    public static int sumaQuadrats(int n) {
        // Logica per calcular la suma dels quadrats dels primers n números enters
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i * i;
        }
        return suma;
    }
    public static int calcularPotencia(int base, int exponent) {
        // Logica per calcular base elevat a exponent
        int resultat = 1;
        for (int i = 1; i <= exponent; i++) {
            resultat *= base;   
        }
        return resultat;

}
    //Funcio de llençament d'una moneda n vegades i comptar quantes vegades surt cara i creu
    public static String llançamentMoneda(int n) {
        Random rand = new Random();
        int cara = 0;
        int creu = 0;
        String resultat = "";
        while (n-- > 0) {
            if (rand.nextBoolean()) {
                cara++;
            } else {
                creu++;
            }
            resultat = "Cara: " + cara + ", Creu: " + creu;
        }
        return resultat;
    }

     public static String  PreuCinema(double preu, boolean capDeSetmana, boolean carnetJove) {
        double preuDiaLaborable = 5.0f;
        double preuCapDeSetmana = preuDiaLaborable * 1.4f; // 10% mes car
        double descompteCarnetJove = 0.15f; // 15% de descomte

        if (capDeSetmana) {
            preu = preuCapDeSetmana;
        } else {
            preu = preuDiaLaborable;
        }
        if (carnetJove) {
            preu = (preu - (preu * descompteCarnetJove));
        }
        return String.format("%.2f", preu);

    }
}





