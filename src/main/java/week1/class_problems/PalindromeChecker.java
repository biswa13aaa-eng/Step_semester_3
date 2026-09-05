package week1.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromeChecker {

    // Approach 1: Iterative
    static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Approach 2: Recursive
    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // Approach 3: Array Reversal
    static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = text.toCharArray();

        int left = 0;
        int right = reversed.length - 1;

        while (left < right) {
            char temp = reversed[left];
            reversed[left] = reversed[right];
            reversed[right] = temp;

            left++;
            right--;
        }

        return Arrays.equals(original, reversed);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        System.out.println("\nIterative: "
                + isPalindromeIterative(text));

        System.out.println("Recursive: "
                + isPalindromeRecursive(text));

        System.out.println("Array Reversal: "
                + isPalindromeArrayReversal(text));

        scanner.close();
    }
}