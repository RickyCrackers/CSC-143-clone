package programs;

import construction.Temperature;
import java.util.Scanner;

public class TemperatureProgram {
    @SuppressWarnings("unused")
    static void main(String[] args) {
        Temperature temperature = new Temperature();
        Scanner scan = new Scanner(System.in);

        System.out.println("Type the temperature unit to convert:");
        System.out.println("1. Fahrenheit");
        System.out.println("2. Celsius");
        System.out.println("3. Kelvin");

        if (!scan.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number (1-3).");
            return;
        }
        int unitInput = scan.nextInt();

        if (unitInput < 1 || unitInput > 3) {
            System.out.println("Not a valid unit");
            return;
        }

        System.out.println("Type in the temperature value to convert");
        
        if (!scan.hasNextDouble()) {
            System.out.println("Invalid temperature value.");
            return;
        }
        double tempValue = scan.nextDouble();

        switch (unitInput) {
            case 1:
                temperature.setFahrenheit(tempValue);
                break;
            case 2:
                temperature.setCelsius(tempValue);
                break;
            case 3:
                temperature.setKelvin(tempValue);
                break;
        }

        // Output results (Accessors)
        System.out.println("--- Results ---");
        System.out.printf("Fahrenheit: %.2f%n", temperature.getFahrenheit());
        System.out.printf("Celsius:    %.2f%n", temperature.getCelsius());
        System.out.printf("Kelvin:     %.2f%n", temperature.getKelvin());
    }
}