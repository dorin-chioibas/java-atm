package src.main.java;

import java.util.Scanner;
import java.util.function.Supplier;

public class ScannerUtils {
    Scanner scanner = new Scanner(System.in);
    
    public String getStringInput() {
        clearScanner();
        return scanner.nextLine();
    }

    public <T> T getValidInput(Supplier<T> supplier, String errorMessage) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception exception) {
                clearScanner();
                System.out.println(errorMessage);
            }
        }
    }

    public int getValidIntegerInput() {
        return getValidInput(scanner::nextInt, Display.Errors.invalidValidIntegerInput());
    }

    public double getValidDoubleInput() {
        return getValidInput(scanner::nextDouble, Display.Errors.invalidValidDoubleInput());
    }

    public void clearScanner() {
        scanner.nextLine();
    }
}
