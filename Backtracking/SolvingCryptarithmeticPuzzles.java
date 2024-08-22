// Problem link: https://www.geeksforgeeks.org/solving-cryptarithmetic-puzzles/

package Backtracking;

import java.util.*;

public class SolvingCryptarithmeticPuzzles {

    public static void main(String[] args) {
        String[] words = {"BLACK", "GREEN"};
        String result = "ORANGE";

        if (!solveCryptArithmetic(words, result)) {
            System.out.println("No solution exists.");
        }
    }
    public static boolean solveCryptArithmetic(String[] words, String result) {
        Set<Character> set = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                set.add(c);
            }
        }
        for (char c : result.toCharArray()) {
            set.add(c);
        }

        if (set.size() > 10) {
            System.out.println("Too many characters, No solution exists.");
            return false;
        }

        Character[] uniqueCharArray = set.toArray(new Character[0]);

        return solve(words, result, new HashMap<>(), new boolean[10], 0, uniqueCharArray);
    }

    // Backtracking function
    private static boolean solve(String[] words, String result, Map<Character, Integer> map, boolean[] vis, int i, Character[] letters) {
        if (i == letters.length) {
            if (isValidSolution(words, result, map)) {
                printSolution(map);
                return true;
            }
            return false;
        }

        char currentChar = letters[i];
        for (int digit = 0; digit <= 9; digit++) {
            if (!vis[digit]) {
                vis[digit] = true;
                map.put(currentChar, digit);

                if (solve(words, result, map, vis, i + 1, letters)) {
                    return true;
                }

                vis[digit] = false; // backtracking
                map.remove(currentChar); // backtracking
            }
        }
        return false;
    }

    private static boolean isValidSolution(String[] words, String result, Map<Character, Integer> map) {
        int sum = 0;
        for (String word : words) {
            sum += wordToNumber(word, map);
        }
        return sum == wordToNumber(result, map);
    }

    private static int wordToNumber(String word, Map<Character, Integer> map) {
        int number = 0;
        for (char c : word.toCharArray()) {
            number = number * 10 + map.get(c);
        }
        return number;
    }

    private static void printSolution(Map<Character, Integer> map) {
        System.out.println("Solution found:");
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.print("[" + entry.getKey() + " -> " + entry.getValue() + "], ");
        }
    }
}
