public class MaximalString {

    public static void main(String[] args) {
        String input = "12534";
        int maxSwaps = 2;

        String answer = maximalFrom(input.split(""), maxSwaps, input);
        System.out.println(answer);
    }

    private static String maximalFrom(String[] input, int maxSwaps, String largest) {
        if (maxSwaps <= 0)
            return largest;

        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                String swapped = swapAndGet(input, i, j);
                largest = largerOf(largest, swapped);
                largest = maximalFrom(input, maxSwaps - 1, largest);
                swapAndGet(input, i, j);
            }
        }
        return largest;
    }

    private static String largerOf(String largest, String swapped) {
        return String.valueOf(Math.max(Integer.valueOf(largest), Integer.valueOf(swapped)));
    }

    private static String swapAndGet(String[] input, int i, int j) {
        String number = input[i];
        input[i] = input[j];
        input[j] = number;
        return String.join("", input);
    }
}
