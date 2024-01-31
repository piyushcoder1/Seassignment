import java.util.*;

public class doomedDice {
    public static int[][] undoom_dice(int[] dieA, int[] dieB) {
        int[] newDieA = {1, 1, 2, 2, 3, 3, 4, 4};
        int[] newDieB = dieB.clone();
        int[][] matrix = new int[4][6];
        int[] sumCounts = new int[13];

        for (int i = 0; i < newDieA.length; i += 2) {
            for (int j = 0; j < newDieB.length; j++) {
                matrix[i / 2][j] = newDieA[i] + newDieB[j];
                sumCounts[matrix[i / 2][j]]++;
            }
        }

        for (int i = 0; i < newDieA.length; i += 2) {
            for (int j = 0; j < Math.min(newDieB.length, matrix[i / 2].length); j++) {
                matrix[i / 2][j] = newDieA[i] + newDieB[j];
                sumCounts[matrix[i / 2][j]]++;
            }
        }
        

        double total = 0;
        for (int i = 2; i < sumCounts.length; i++) {
            total += sumCounts[i];
        }

        for (int i = 2; i < sumCounts.length; i++) {
            sumCounts[i] = (int) Math.round(sumCounts[i] / total * 36);
        }

        System.out.println("\nProbabilities of sums with undoom:");
        for (int i = 2; i < sumCounts.length; i++) {
            System.out.printf("P(Sum = %d) = %d%n", i, sumCounts[i]);
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[] dieA = {1, 2, 3, 4, 5, 6};
        int[] dieB = {1, 2, 3, 4, 5, 6};
        int[][] matrix = undoom_dice(dieA, dieB);
    }
}
