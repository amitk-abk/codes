import java.util.LinkedList;

public class ReverseStack {

    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("Before:"+stack);
        reverseIt(stack);
        System.out.println("After:"+stack);
    }

    private static void reverseIt(LinkedList<Integer> stack) {
        if (stack.isEmpty())
            return;

        Integer item = stack.pop();
        reverseIt(stack);
        reverseThisStack(stack, item);
    }

    private static void reverseThisStack(LinkedList<Integer> stack, Integer item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }

        int temp = stack.pop();
        reverseThisStack(stack, item);
        stack.push(temp);
    }
}
