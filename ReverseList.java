public class ReverseList {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node root = initializeList();
        root = reverseIt(root);
        printIt(root);
    }

    private static Node reverseIt(Node root) {
        Node prev = null;
        Node curr = root;
        while (curr != null) {
            Node nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            if (curr != null && curr.next == null)
                root = curr;
        }
        return root;
    }

    private static void printIt(Node root) {
        Node curr = root;
        while (curr!=null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    private static Node initializeList() {
        Node root = new Node(1);

        Node temp = root;
        for (int i = 2; i < 6; i++) {
            Node node = new Node(i);
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
        return root;
    }
}
