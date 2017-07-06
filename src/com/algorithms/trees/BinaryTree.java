package com.algorithms.trees;

import com.algorithms.TreeNode;

public class BinaryTree {

    private TreeNode root;

    public void insert(Integer data) {

        TreeNode n = new TreeNode(data);

        if (this.root == null) {
            this.root = n;
            return;
        }

        TreeNode current = this.root;

        while (current.left != null) {
            current = current.left;
        }

        current.left = n;
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
        node.left = new TreeNode(12);

        node.right = new TreeNode(13);
        node.right.right = new TreeNode(14);
        node.right.right.right = new TreeNode(15);
        node.right.right.right.right = new TreeNode(19);

        node.right.left = new TreeNode(16);
        node.right.left.left = new TreeNode(17);
        node.right.left.left.left = new TreeNode(18);

        return bt;
    }

    public static BinaryTree createBalancedBT() {
        BinaryTree bt = new BinaryTree();
        bt.insert(10);

        TreeNode node = bt.getRootNode();
        node.left = new TreeNode(12);
        node.right = new TreeNode(13);
        
        node.right.right = new TreeNode(14);
        node.right.left = new TreeNode(15);
        
        node.left.right = new TreeNode(14);
        node.left.left = new TreeNode(11);

        return bt;
    }

    public int diameter() {
        return diameterUtil(this.root);
    }

    private int diameterUtil(TreeNode t) {

        if (t == null) {
            return 0;
        }

        int lHeight = heightUtil(t.left);
        int rHeight = heightUtil(t.right);

        int lDiameter = diameterUtil(t.left);
        int rDiameter = diameterUtil(t.right);

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

        if (t == null) { return true; }
        int rheight = heightUtil(t.right);
        int lheight = heightUtil(t.left);

        return (Math.abs(lheight - rheight) <= 1 && isBalancedUtil(t.left) && isBalancedUtil(t.right));
    }

    private int heightUtil(TreeNode t) {

        if (t == null) {
            return 0;
        }

        int lHeight = heightUtil(t.left);
        int rHeight = heightUtil(t.right);
        int maxHeight = Integer.max(rHeight, lHeight);
        return maxHeight + 1;
    }

    TreeNode getRootNode() {
        return this.root;
    }
}
