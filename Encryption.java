import java.util.ArrayList;
import java.util.List;

public class Encryption {

    public static void main(String[] args) {
        String input = "feedthedog";
//        String input = "chillout";
//        String input = "if man was meant to stay on the ground god would have given us roots";

        String inputs[] = input.split("\\s");
        String spaceRemoved = String.join("", inputs);

        int len = spaceRemoved.length();
        double sqrt = Math.sqrt(len);
        int row = new Double(Math.floor(sqrt)).intValue();
        int cols = new Double(Math.ceil(sqrt)).intValue();

        if (row * cols < len)
            row = cols;

        int start = 0;
        char[][] parts = new char[row][cols];
        int count = 0;
        while (spaceRemoved.length() > cols) {
            if (start + cols > spaceRemoved.length()) {
                break;
            }
            String part = spaceRemoved.substring(start, start + cols);
            start = start + cols;
            char[] chars = part.toCharArray();
            parts[count++] = chars;
        }
        if (start < spaceRemoved.length())
            parts[count] = spaceRemoved.substring(start).toCharArray();

        List<String> result = new ArrayList<>();
        for (int n = 0; n < cols; n++) {
            char[] line = new char[parts.length];
            for (int i = 0; i < parts.length; i++) {
                char[] part = parts[i];
                if (n > part.length - 1) {
                    break;
                }
                line[i] = part[n];
            }
            result.add(new String(line).trim());
        }
        String f = String.join(" ", result);
        System.out.println(f);
    }
}
