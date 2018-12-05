import java.util.Arrays;

public class BString {

    public static void main(String[] args) {
        int n = 3;
        int arr[] = new int[n];
        bString(0, n, arr);
    }

    private static void bString(int i, int n, int[] arr) {
        if (i == n) {
            print(arr);
            return;
        }

        arr[i] = 0;
        bString(i+1, n, arr);

        arr[i] = 1;
        bString(i+1, n, arr);
    }

    private static void print(int[] arr) {
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();   //To print groups separately
    }
}
