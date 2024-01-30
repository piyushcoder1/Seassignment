import java.util.*;

public class Dice {
    public static int[] undoom_dice(int[] dieA, int[] dieB) {
        int totalCombinations = dieA.length * dieB.length;

        Map<Integer, Integer> distribution = new HashMap<>();
        for (int valA : dieA) {
            for (int valB : dieB) {
                int sum = valA + valB;
                distribution.put(sum, distribution.getOrDefault(sum, 0) + 1);
            }
        }

        Map<Integer, Double> probabilities = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : distribution.entrySet()) {
            probabilities.put(entry.getKey(), (double) entry.getValue() / totalCombinations);
        }

        Map<Integer, Integer> desiredDistribution = new HashMap<>();
        for (int sum : distribution.keySet()) {
            desiredDistribution.put(sum, (int) Math.round(probabilities.get(sum) * dieA.length));
        }

        int[] newDieA = new int[dieA.length];
        for (int i = 0; i < dieA.length; i++) {
            int count = desiredDistribution.getOrDefault(dieA[i], 0);
            if (count > 4) {
                newDieA[i] = dieA[i] - (count - 4);
            } else {
                newDieA[i] = dieA[i];
            }
        }

        return newDieA;
    }
    public static void main(String[] args) {
        int[] dieA = {1, 2, 3, 4, 5, 6};
        int[] dieB = {1, 2, 3, 4, 5, 6};

        int[] newDieA = undoom_dice(dieA, dieB);
        int[] newDieB = dieB;

        System.out.println("New Die A:");
        for (int val : newDieA) {
            System.out.print(val + " ");
        }
        System.out.println("\nNew Die B (unchanged):");
        for (int val : newDieB) {
            System.out.print(val + " ");
        }
    }
}
