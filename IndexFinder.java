import java.util.Arrays;

public class IndexFinder {

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 5, 5, 5, 7, 123, 125};
        int target = 3;
        int startIndex = Arrays.binarySearch(arr, target);
        if (startIndex >= 0) {

            while ((startIndex > 0) && (arr[startIndex - 1] == arr[startIndex])) {
                startIndex--;
            }

            int endIndex = Arrays.binarySearch(arr, target + 1);
            if (endIndex >= 0) {
                while ((endIndex > 0) && (arr[endIndex - 1] == arr[endIndex])) {
                    endIndex--;
                }
            }
            System.out.println(startIndex + " and " + (endIndex < 0 ? (endIndex + 2) * -1 : endIndex - 1));
        }
    }
}
