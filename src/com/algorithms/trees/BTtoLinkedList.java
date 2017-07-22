package com.algorithms.trees;

import com.algorithms.TreeNode;
import com.algorithms.linkedlist.LinkedList;

public class BTtoLinkedList {

    public BTtoLinkedList(BinaryTree t) {

    }

    public LinkedList toCLL() {

    }

    public static void driver() {
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.getRootNode().left = new TreeNode(2);
        tree.getRootNode().right = new TreeNode(3);
        tree.getRootNode().left.left = new TreeNode(4);
        tree.getRootNode().left.right = new TreeNode(5);

        tree.getRootNode().right.left = new TreeNode(6);
        tree.getRootNode().right.right = new TreeNode(7);

        BTtoLinkedList obj = new BTtoLinkedList(tree);
    }
}
