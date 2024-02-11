package be.intecbrussel.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerTools {


    public static List<String> namesScanner(){
        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        System.out.println("First name: ");
        names.add(0,scanner.nextLine());
        System.out.println("Last name: ");
        names.add(1,scanner.nextLine());
        return names;
    }

    public static String typeBookScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type of book:\n" +
                "1: Children book\n" +
                "2: Fiction book\n" +
                "3: Non fiction book\n" +
                "4: Other book ");
        String input = scanner.nextLine();
        switch (input) {
            case "1" -> input = "children";
            case "2" -> input = "fiction";
            case "3" -> input = "nonFiction";
            default -> input = "other";
        }
        return input;
    }
}
