import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutations {

    public static void main(String[] args) {
        //Print all permutations of numbers given in an array.
        int[] input = {1, 2, 3};
        boolean[] used = new boolean[3];
        List<Integer> partial = new ArrayList<>();

        permutation(input, partial, used);
    }

    private static void permutation(int[] input, List<Integer> partial, boolean[] used) {
        if (partial.size() == input.length) {
            System.out.println(Arrays.toString(partial.toArray()));
            return;
        }

        for (int i = 0 ; i < input.length; i++) {
            if (!used[i]) {
                used[i] = true;
                partial.add(input[i]);
                permutation(input, partial, used);
                used[i] = false;
                partial.remove(partial.size() - 1);
            }
        }
    }
}
