import java.util.*;

public class DoomedDice {

    public static void main(String[] args) {
        // Part A
        // 1
        int totalCombinations = 6 * 6;
        System.out.println("Total combinations possible: " + totalCombinations);

        // 2
        int[][] distribution = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                distribution[i][j] = (i + 1) + (j + 1);
            }
        }
        System.out.println("Distribution of all possible combinations:");
        for (int[] row : distribution) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        //3
        Map<Integer, Double> probabilities = new HashMap<>();
        for (int i = 2; i <= 12; i++) {
            int count = 0;
            for (int[] row : distribution) {
                for (int val : row) {
                    if (val == i) {
                        count++;
                    }
                }
            }
            double probability = (double) count / totalCombinations;
            probabilities.put(i, probability);
        }
        System.out.println("\nProbability of all possible sums:");
        for (Map.Entry<Integer, Double> entry : probabilities.entrySet()) {
            System.out.printf("P(Sum = %d) = %.4f%n", entry.getKey(), entry.getValue());
        }
    }
}
