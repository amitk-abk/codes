import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumFromCandidates {

    public static void main(String[] args) {
        int candidates[] = {2, 3, 6, 7};
        int target = 7;

        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        ArrayList<Integer> combination = new ArrayList<>();
        combinations = combinationsFrom(candidates, target, 0, 0, combinations, combination);
        System.out.println(combinations);
    }

    private static ArrayList<ArrayList<Integer>> combinationsFrom(int[] candidates, int target, int sum, int start,
                                                                  ArrayList<ArrayList<Integer>> combinations, ArrayList<Integer> combination) {
        if (sum > target)
            return combinations;

        if (sum == target) {
            if (!combinations.contains(combination))
                combinations.add(new ArrayList<>(combination));
            return combinations;
        }

        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            combinationsFrom(candidates, target, sum + candidates[i], i, combinations, combination);
            combination.remove(combination.size() - 1);
        }
        return combinations;
    }
}
