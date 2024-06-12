package com.java.binary;

public class Main {
	 Node root;
     public Main(int key) {
    	 root = new Node(key);
	 }
     public Main() {

     }

	public static void main(String[] args) {
        Main tree = new Main();

        // Create root
        tree.root = new Node(5);
        /* Following is the tree after above statement
           1
          / \
        null null 
        */

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        /* 2 and 3 become left and right children of 1
              1
             / \
            2   3
           / \ / \
       null null null null */
        tree.root.left.left = new Node(4);
        /* 4 becomes left child of 2
               1
              / \
             2   3
            / \ / \
           4 null null null
          / \
        null null
        */
        System.err.println("MAIN TREE: " + tree.root.left.left.key);
        tree.printTree(tree.root);
        
        // Search for a value
        int targetValue = 4;
        if (tree.search(tree.root, targetValue)) {
            System.out.println("\nValue " + targetValue + " found in the tree.");
        } else {
            System.out.println("\nValue " + targetValue + " not found in the tree.");
        }
	}
	
	public void printTree(Node node) {
        if (node != null) {
            // Traverse the left subtree
            printTree(node.left);

            // Print the current node's key
            System.err.print(node.key + " ");

            // Traverse the right subtree
            printTree(node.right);
        }
	}
	
	 // Method to search for a value in the binary tree
    public boolean search(Node node, int target) {
        if (node == null) {
            return false;
        }

        // Check if the current node's key matches the target value
        if (node.key == target) {
            return true;
        }

        // Recursively search in the left and right subtrees
        boolean leftSearch = search(node.left, target);
        boolean rightSearch = search(node.right, target);

        // Return true if the value is found in either subtree
        return leftSearch || rightSearch;
    }
}

