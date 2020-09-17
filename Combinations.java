import java.util.ArrayList;
import java.util.List;

public class Combinations {
    /*
    Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

    Make sure the combinations are sorted.

    To elaborate,

    Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
    Entries should be sorted within themselves.
     */

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> allCombinations = new ArrayList<>();
        allCombinations = combinationsFrom(1, n, k, combination, allCombinations);
        System.out.println(allCombinations);
    }

    private static List<List<Integer>> combinationsFrom(int start, int n, int k, List<Integer> combs, List<List<Integer>> allCombos) {
        if (combs.size() == k) {
            allCombos.add(new ArrayList<>(combs));
            return allCombos;
        }
        for (int i = start; i <= n; i++) {
            combs.add(i);
            combinationsFrom(i + 1, n, k, combs, allCombos);
            combs.remove(combs.size() - 1);
        }

        return allCombos;
    }
}
