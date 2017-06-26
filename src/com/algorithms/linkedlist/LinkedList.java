package com.algorithms.linkedlist;

import com.algorithms.Node;

public class LinkedList {

    private Node lastNode = null;
    private Node firstNode = null;

    // Add
    public boolean add(Node node) {

        if (firstNode == null) {
            firstNode = node;
        }

        if (lastNode == null) {
            lastNode = node;
        } else {
            lastNode.next = node;
            lastNode = node;
        }

        return true;
    }

    // Delete
    public void deleteLast() {

        if (firstNode == lastNode) {
            firstNode = null;
            lastNode = null;
        }
        
        Node prevNode = null;
        Node currentNode = null;
        while (currentNode != null) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        prevNode.next = null;
        lastNode = prevNode;
        
    }

    public void deleteNodeAtIndex(int index) {
        
    }
    
    public void deleteNode(Node node) {
        
    }
    
    // First Node
    public Node head() {
        return firstNode;
    }

    // Tail Node
    public Node tail() {
        return lastNode;
    }
}
