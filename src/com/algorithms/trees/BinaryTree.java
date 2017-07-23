package com.algorithms.trees;

import com.algorithms.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private TreeNode root;

    public void insert(Integer data) {

        TreeNode n = new TreeNode(data);

        if (this.root == null) {
            this.root = n;
            return;
        }

        TreeNode current = this.root;

        while (current.getLeft() != null) {
            current = current.getLeft();
        }

        current.setLeft(n);
    }

    public static BinaryTree create() {
        BinaryTree bt = new BinaryTree();

        bt.insert(1);
        bt.insert(2);
        bt.insert(3);

        return bt;
    }

    public static BinaryTree createNotBST() {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);

        TreeNode node = bt.getRootNode();
        node.setLeft(new TreeNode(12));

        node.setRight(new TreeNode(13));
        node.getRight().setRight(new TreeNode(14));
        node.getRight().getRight().setRight(new TreeNode(15));
        node.getRight().getRight().getRight().setRight(new TreeNode(19));

        node.getRight().setLeft(new TreeNode(16));
        node.getRight().getLeft().setLeft(new TreeNode(17));
        node.getRight().getLeft().getLeft().setLeft(new TreeNode(18));

        return bt;
    }

    public static BinaryTree createBalancedBT() {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);

        TreeNode node = bt.getRootNode();
        node.setLeft(new TreeNode(12));
        node.setRight(new TreeNode(13));

        node.getRight().setRight(new TreeNode(14));
        node.getRight().setLeft(new TreeNode(15));

        node.getLeft().setRight(new TreeNode(14));
        node.getLeft().setLeft(new TreeNode(11));

        return bt;
    }

    public int diameter() {
        return diameterUtil(this.root);
    }

    private int diameterUtil(TreeNode t) {

        if (t == null) {
            return 0;
        }

        int lHeight = heightUtil(t.getLeft());
        int rHeight = heightUtil(t.getRight());

        int lDiameter = diameterUtil(t.getLeft());
        int rDiameter = diameterUtil(t.getRight());

        return Math.max(rHeight + 1 + lHeight, Math.max(lDiameter, rDiameter));
    }

    public int height() {
        int height = heightUtil(this.root);
        return height;
    }

    public boolean isBalanced() {
        return isBalancedUtil(this.root);
    }

    private boolean isBalancedUtil(TreeNode t) {

        if (t == null) {
            return true;
        }
        int rheight = heightUtil(t.getRight());
        int lheight = heightUtil(t.getLeft());

        return (Math.abs(lheight - rheight) <= 1 && isBalancedUtil(t.getLeft()) && isBalancedUtil(t.getRight()));
    }

    public void printEachLevelInEachLine() {
        Queue<TreeNode> oddQ = new LinkedList();
        Queue<TreeNode> evenQ = new LinkedList();

        int level = 0;

        evenQ.add(this.root);

        while (!oddQ.isEmpty() && !evenQ.isEmpty()) {

            while (!evenQ.isEmpty()) {
                TreeNode tn = evenQ.remove();
                System.out.print(tn.data+" ");
                oddQ.add(tn.getLeft());
                oddQ.add(tn.getRight());
            }
            System.out.println();
            while (!oddQ.isEmpty()) {
                TreeNode tn = oddQ.remove();
                System.out.print(tn.data+" ");
                evenQ.add(tn.getLeft());
                evenQ.add(tn.getRight());
            }
            System.out.println();
        }
    }

    private int heightUtil(TreeNode t) {

        if (t == null) {
            return 0;
        }

        int lHeight = heightUtil(t.getLeft());
        int rHeight = heightUtil(t.getRight());
        int maxHeight = Integer.max(rHeight, lHeight);
        return maxHeight + 1;
    }

    TreeNode getRootNode() {
        return this.root;
    }
}
