package com.mycomp.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeTree {
    Node root;

    class Node {
        int value;
        int hd;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    Node addToTree(int val, Node root) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val > root.value)
            root.right = addToTree(val, root.right);
        else
            root.left = addToTree(val, root.left);

        return root;
    }

    public void print(Node root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.value + " ");
            print(root.right);
        }
    }

    static List<Integer> list = new ArrayList<>();

    void serializeQueue() {
        list.clear();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node dummy = new Node(-1);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            list.add(curr.value);
            if (curr.value == -1)
                continue;

            if (curr.left != null) {
                q.add(curr.left);
            } else {
                q.add(dummy);
            }

            if (curr.right != null) {
                q.add(curr.right);
            } else {
                q.add(dummy);
            }
        }
    }

    Node deserializeQueue() {
        int val = list.remove(0);
        Node node = new Node(val);

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!list.isEmpty() && !q.isEmpty()) {
            Node curr = q.poll();

            int valleft = list.remove(0);
            int valright = list.remove(0);

            if (valleft != -1) {
                curr.left = new Node(valleft);
                q.add(curr.left);
            } else {
                curr.left = null;
            }

            if (valright != -1) {
                curr.right = new Node(valright);
                q.add(curr.right);
            } else {
                curr.right = null;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        SerializeDeserializeTree b = new SerializeDeserializeTree();
        b.root = b.addToTree(20, b.root);
        b.root.left = b.addToTree(8, b.root.left);
        b.root.right = b.addToTree(22, b.root.right);
        b.root.left.left = b.addToTree(5, b.root.left.left);
        b.root.left.right = b.addToTree(3, b.root.left.right);
        b.root.right.left = b.addToTree(4, b.root.right.left);
        b.root.right.right = b.addToTree(25, b.root.right.right);
        b.root.left.right.left = b.addToTree(10, b.root.left.right.left);
        b.root.left.right.right = b.addToTree(14, b.root.left.right.right);

        b.print(b.root);
        b.serializeQueue();

        System.out.println("\n After deserialization:");
        Node n = b.deserializeQueue();
        b.print(n);
    }
}
