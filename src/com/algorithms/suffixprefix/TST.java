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
        //TSTNode nextNode = null;

        for (int i = 0; i < array.length;) {

            char characterToBeInserted = array[i];
            System.out.println("characterToBeInserted:" + characterToBeInserted);
            if (node == null) {
                System.out.println("root is null");
                // can happen only when the root is null
                node = new TSTNode(characterToBeInserted);
                head = node;
                i++;
                continue;
            }

            // Get the node
            if (characterToBeInserted < node.ch) {
                System.out.println("less than:" + node.ch);
                if (node.left == null) {
                    System.out.println("insert to the left:" + node.ch);
                    node.left = new TSTNode(characterToBeInserted);
                    i++;
                }

                // go left
                node = node.left;

            } else if (characterToBeInserted == node.ch) {
                if (node.middle == null) {
                    System.out.println("insert in the middle:" + node.ch);
                    node.middle = new TSTNode(characterToBeInserted);
                    i++;
                }

                // go middle
                node = node.middle;

            } else if (characterToBeInserted > node.ch) {
                if (node.right == null) {
                    System.out.println("insert to the right:" + node.ch);
                    node.right = new TSTNode(characterToBeInserted);
                    i++;
                }

                // go right
                node = node.right;
            }
        }

        return true;
    }

    // search
    public boolean isPresent(String searchString) {

        System.out.println("Searching");
        if (searchString == null || searchString.length() == 0) {
            return false;
        }

        // convert it to array
        char[] array = searchString.toCharArray();

        TSTNode node = getRoot();

        if (node == null) {
            System.out.println("Root is null");
            return false;
        }

        int i = 0;

        if (node.ch != array[0]) {
            return false;
        }

        for (i = 1; i < array.length;) {

            char currentCharacter = array[i - 1];
            char nextCharacter = array[i];
            System.out.println("nextCharacter:" + nextCharacter);

            if (node == null) {
                System.out.println("node is null");
                break;
            }

            if (node.ch == currentCharacter) {
                System.out.println("found: " + nextCharacter);
                node = getNextNode(node,nextCharacter);
                i++;
            } else if (node.ch < nextCharacter) {
                System.out.println("move right:" + node.ch + " investigating: " + nextCharacter);
                node = getNextNode(node,nextCharacter);
            } else if (node.ch > nextCharacter) {
                System.out.println("move left:" + node.ch + " investigating: " + nextCharacter);
                node = getNextNode(node,nextCharacter);
            }
        }

        return i == array.length;
    }

    private TSTNode getNextNode(TSTNode node, char nextCharacter) {
        if (node.ch == nextCharacter) {
            return node.middle;
        } else if (node.ch < nextCharacter) {
            return node.right;
        } else if (node.ch > nextCharacter) {
            return node.left;
        }
        
        return null;
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
        tst.insert("seet");

        System.out.println("TST " + tst.isPresent("seet"));
    }
}
