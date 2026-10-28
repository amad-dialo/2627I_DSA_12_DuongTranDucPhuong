package HomeWork.Week_07;

import java.util.Scanner;

public class WordCountBST {

    static class Node {
        String word;
        int count;
        Node left, right;

        Node(String word) {
            this.word = word;
            this.count = 1;
            this.left = null;
            this.right = null;
        }
    }

    static class BinarySearchTree {
        Node root;

        public void insert(String word) {
            root = insertRec(root, word);
        }

        private Node insertRec(Node root, String word) {
            if (root == null) {
                return new Node(word);
            }

            int cmp = word.compareTo(root.word);
            if (cmp == 0) {
                root.count++;
            } else if (cmp < 0) {
                root.left = insertRec(root.left, word);
            } else {
                root.right = insertRec(root.right, word);
            }
            return root;
        }

        public void printInOrder(Node node) {
            if (node != null) {
                printInOrder(node.left);
                System.out.println(node.word + " " + node.count);
                printInOrder(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        while (scanner.hasNext()) {
            String token = scanner.next();
            String word = token.replaceAll("[^\\p{L}\\p{N}]", "").toLowerCase();
            if (!word.isEmpty()) {
                bst.insert(word);
            }
        }

        bst.printInOrder(bst.root);
        scanner.close();
    }
}