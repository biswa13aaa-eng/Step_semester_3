package week1.class_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    static int firstNonRepeatingChar(String text) {

        Map<Character, Integer> frequency = new HashMap<>();

        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        // Find the first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (frequency.get(ch) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        int result = firstNonRepeatingChar(text);

        if (result == -1) {
            System.out.println("No non-repeating character found.");
        } else {
            System.out.println("First non-repeating character: "
                    + text.charAt(result));
            System.out.println("Index: " + result);
        }

        scanner.close();
    }
}
