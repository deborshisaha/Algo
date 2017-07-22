package com.algorithms;

public class TreeNode {

    public Integer data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Integer data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void setLeft(TreeNode tn) {
        this.left = tn;
    }

    public void setPrevious(TreeNode tn) {
        this.left = tn;
    }

    public void setRight(TreeNode tn) {
        this.right = tn;
    }

    public void setNext(TreeNode tn) {
        this.right = tn;
    }
    
    public TreeNode getNext() {return this.right;}
    
    public TreeNode getPrevious() {return this.left;}
    
    public TreeNode getLeft() {return this.left;}
    
    public TreeNode getRight() {return this.right;}
}
