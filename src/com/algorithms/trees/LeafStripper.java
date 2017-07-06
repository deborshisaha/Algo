package com.algorithms.trees;

import com.algorithms.TreeNode;
import java.util.ArrayList;

public class LeafStripper {
    
    private BinaryTree bt;

    public LeafStripper(BinaryTree t) {
        this.bt = t;
    }
    
    public ArrayList<TreeNode> strippedLeaves() {
        
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        
        strippedLeavesUtil(this.bt.getRootNode(),result);
        
        return result;
    }
    
    private void strippedLeavesUtil(TreeNode n, ArrayList<TreeNode> result) {
        
        if (n==null) {return;}
        
        if ( n.left == null && n.right == null) {
            result.add(n);
            return;
        }
        
        strippedLeavesUtil(n.left, result);
        strippedLeavesUtil(n.right, result);
    }
    
    public static void driver() {
        LeafStripper ls = new LeafStripper(BinaryTree.createNotBST());

        System.out.println("Leaf Stripper");
        for (TreeNode t: ls.strippedLeaves()) {
            System.out.print(t.data+" ");
        }
        System.out.println();
    }
}
