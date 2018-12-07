import java.util.stream.Stream;

public class PrintAllCombinations {

    public static void main(String[] args) {
        char basket[] = {'a', 'b', 'c'};
        char arr[] = new char[basket.length];
        kAryString(0, arr, basket.length, basket);
    }

    private static void kAryString(int i, char[] arr, int k, char[] basket) {
        if (i == k) {
            printArr(arr);
            return;
        }

        for (int j = 0; j<=k-1; j++) {
            arr[i] = basket[j];
            kAryString(i+1, arr, k, basket);
        }
    }

    private static void printArr(char[] arr) {
        Stream.of(new String(arr)).forEach(System.out::println);
    }
}
