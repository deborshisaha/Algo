package com.algorithms.trees;

import com.algorithms.TreeNode;

public class BinarySearchTree extends BinaryTree {

    private TreeNode root;

    @Override
    public void insert(Integer data) {

        if (this.root == null) {
            this.root = new TreeNode(data);
        }

        TreeNode node = null;

        if (data <= this.root.data) {
            node = this.root.left;
        } else {
            node = this.root.right;
        }

        while (node != null) {
            TreeNode nextNode = null;
            if (node.data > data) {
                nextNode = node.left;
                if (nextNode == null) {
                    node.left = new TreeNode(data);
                }
                node = node.left;
            } else {
                nextNode = node.right;
                if (nextNode == null) {
                    node.right = new TreeNode(data);
                }
                node = node.right;
            }
        }
    }

    public void preOrder() {

    }

    public void postOrder() {

    }

    public void inorder() {

    }
  
    // Constructors
    public static void driver () {
        BinarySearchTree bst = BinarySearchTree.create();
    }
    
    public static BinarySearchTree create() {
        
        BinarySearchTree bst = new BinarySearchTree();
        
        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(11);
        bst.insert(12);
        bst.insert(10);
        
        return bst;
    }

    public TreeNode getRootNode() {
        return root;
    }
}