/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author kkter
 */

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(Employee employee) {

        TreeNode newNode = new TreeNode(employee);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current.getLeft() == null) {
                current.setLeft(newNode);
                return;
            } else {
                queue.add(current.getLeft());
            }

            if (current.getRight() == null) {
                current.setRight(newNode);
                return;
            } else {
                queue.add(current.getRight());
            }
        }
    }

    public void displayLevelOrder() {

        if (root == null) {
            System.out.println("Binary tree is empty.");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int number = 1;

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            System.out.println(number + ". "
                    + current.getEmployee().getFullName()
                    + " | Manager: "
                    + current.getEmployee().getManagerType()
                    + " | Department: "
                    + current.getEmployee().getDepartmentType());

            number++;

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }

    public int getHeight() {
        return calculateHeight(root);
    }

    
    /*
     * Recursively calculates the height of the tree by comparing
     * the height of the left subtree and the right subtree.
     */
    private int calculateHeight(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.getLeft());
        int rightHeight = calculateHeight(node.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getNodeCount() {
        return countNodes(root);
    }

    /*
     * Recursively counts all nodes in the binary tree.
     */
    private int countNodes(TreeNode node) {

        if (node == null) {
            return 0;
        }

        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }
    
    public TreeNode getRoot() {
        return root;
    }
}