package com.algorithms.trees;

import com.algorithms.TreeNode;
import com.algorithms.linkedlist.LinkedList;

public class BTtoLinkedList {

    private final BinaryTree t;
    
    public BTtoLinkedList(BinaryTree t) {
        this.t = t;
    }

    public LinkedList toCLL() {
        
        TreeNode startNode = convert(this.t.getRootNode()).getRight();
        TreeNode it = startNode;
        int i = 6;
        while (i != 0 ) {
            System.out.print(it.data+" ");
            it = it.getRight();
            i--;
        }
        
        return null;
    }
    
    private TreeNode convert(TreeNode n) {
        
        // If this has passed the leaf node
        if (n == null) {return null;}
        
        // This is the leaf node, point both pointers to self and pass it on
        if (n.getLeft() == null && n.getRight()==null) {
            n.setLeft(n);
            n.setRight(n);
            return n;
        }
        
        TreeNode left = convert(n.getLeft());
 
        TreeNode right = convert(n.getRight());
        
        TreeNode tail = right.getLeft();

        TreeNode start = left.getRight();

        tail.setRight(start);
      
        start.setLeft(tail);
       
        left.setRight(n);
        
        right.setLeft(n);

        return tail;
    }
    
    public static void driver() {
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.getRootNode().setLeft( new TreeNode(2));
        tree.getRootNode().setRight(new TreeNode(3));
//        tree.getRootNode().getLeft().setLeft( new TreeNode(4));
//        tree.getRootNode().getLeft().setRight( new TreeNode(5));
//
//        tree.getRootNode().getRight().setLeft(new TreeNode(6));
//        tree.getRootNode().getRight().setRight(new TreeNode(7));

        BTtoLinkedList obj = new BTtoLinkedList(tree);
        obj.toCLL();
    }
}
