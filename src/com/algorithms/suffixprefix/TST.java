/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithms.suffixprefix;

public class TST {

    private class TSTNode {

        TSTNode left;
        TSTNode right;
        TSTNode middle;
        Character ch;

        TSTNode() {
        }

        TSTNode(Character ch) {
            this.left = null;
            this.middle = null;
            this.right = null;
            this.ch = ch;
        }
    }

    private TSTNode head;

    public TST() {
        this.head = null;
    }

    // Get head
    public TSTNode getRoot() {
        return head;
    }

    // insert
    public boolean insert(String word) {

        if (word == null || word.length() == 0) {
            return false;
        }

        // convert it to array
        char[] array = word.toCharArray();

        TSTNode node = getRoot();

        if (node == null) {
            node = new TSTNode(array[0]);
            this.head = node;
        }

        TSTNode nextNode = node;
        
        for (int i = 0; i < array.length;) {

            if (nextNode == null) {
                System.out.println("null");
                nextNode = new TSTNode(array[i]);

                if (node.ch <= array[i]) {
                    System.out.println("null right");
                    node.right = nextNode;
                } else {
                    System.out.println("null left");
                    node.left = nextNode;
                }
            }

            System.out.println(">>>"+array[i]);

            if (node.ch == array[i]) {
                System.out.println("1");
                nextNode = node.middle;
                i++;
            } else if (node.ch <= array[i]) {
                System.out.println("2");
                nextNode = node.right;
            } else if (node.ch > array[i]) {
                System.out.println("3");
                nextNode = node.left;
            }

            node = nextNode;
        }

        return true;
    }

    // search
    public boolean isPresent(String searchString) {

        if (searchString == null || searchString.length() == 0) {
            return false;
        }

        // convert it to array
        char[] array = searchString.toCharArray();

        TSTNode node = getRoot();

        if (node == null) {
            return false;
        }
        
        int i = 0;
        
        for (; i < array.length;) {

            if (node == null || i == array.length) {
                break;
            }

            if (node.ch == array[i]) {
                // move straight
                node = node.middle;
                i++;
            } else if (node.ch <= array[i]) {
                node = node.right;
            } else if (node.ch > array[i]) {
                node = node.left;
            }
        }

        return i == array.length;
    }

    // delete
    public boolean delete(String word) {

        if (word == null || word.length() == 0) {
            return false;
        }

        char[] arr = word.toCharArray();

        return deleteUtil(getRoot(), arr, 0);
    }

    public boolean deleteUtil(TSTNode node, char[] arr, int index) {

        if (node == null) {
            return true;
        }

        TSTNode nextNode = null;

        if (node.ch == arr[index]) {
            // move straight
            nextNode = node.middle;
        } else if (node.ch <= arr[index]) {
            nextNode = node.right;
        } else if (node.ch > arr[index]) {
            nextNode = node.left;
        }

        if (deleteUtil(nextNode, arr, index + 1)) {
            // If deleting the node below succeeded then delete this one
            if (node.right == null && node.middle == null && node.right == null) {
                node = null;
                return true;
            }
        }

        return false;
    }
    
    public static void driver() {
        TST tst = new TST();
        tst.insert("sea");
        
        System.out.println("TST "+tst.isPresent("sea"));
    }
}
