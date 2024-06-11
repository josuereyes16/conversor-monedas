package com.aluracursos.conversor.main;

import com.aluracursos.conversor.consult.ConsultAPI;
import com.aluracursos.conversor.model.Money;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConsultAPI consult = new ConsultAPI();
        DecimalFormat df = new DecimalFormat("#.##");

        String bCurrency = "";
        String tCurrency = "";
        Double amount = 0.0;

        while (true) {
            int opcion = 0;
            System.out.println("""
                Escoja la operación que desea realizar:       
                1. Dolares a Euros.               2. Euros a Dolares.
                3. Dolares a Pesos Mexicanos.     4. Pesos Mexicanos a Dolares.
                5. Dolares a Real Brasileño.      6. Real Brasileño a Dolares.
                7. Dolares a Pesos Argentinos.    8. Pesos Argentinos a Dolares.
                9. SALIR.              
                Digite su opción (del 1 al 9):
                """);
            try {
                opcion = Integer.parseInt(sc.nextLine());
                if (opcion >= 1 && opcion <= 9) {
                    switch (opcion) {
                        case 1:
                            bCurrency = "USD";
                            tCurrency = "EUR";
                            break;
                        case 2:
                            bCurrency = "EUR";
                            tCurrency = "USD";
                            break;
                        case 3:
                            bCurrency = "USD";
                            tCurrency = "MXN";
                            break;
                        case 4:
                            bCurrency = "MXN";
                            tCurrency = "USD";
                            break;
                        case 5:
                            bCurrency = "USD";
                            tCurrency = "BRL";
                            break;
                        case 6:
                            bCurrency = "BRL";
                            tCurrency = "USD";
                            break;
                        case 7:
                            bCurrency = "USD";
                            tCurrency = "ARS";
                            break;
                        case 8:
                            bCurrency = "ARS";
                            tCurrency = "USD";
                            break;
                        case 9:
                            System.out.println("Programa finalizado.");
                            return;
                    }
                    System.out.println("Digite el monto que desea convertir:");
                    amount = Double.parseDouble(sc.nextLine());

                    Money money = consult.convert(bCurrency, tCurrency, amount);
                    System.out.println("El valor de " + amount + " [" + bCurrency + "] corresponde a " +
                            df.format(money.getConversionResult()) + " [" + tCurrency + "].");
                } else {
                    System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida, ingrese un número entero.");
                System.out.println(e.getMessage());
            }
        }
    }
}
