package com.algorithms.suffixprefix;

import java.util.HashMap;

public class Trie {

    private class TrieNode {

        boolean endWord;
        HashMap<Character, TrieNode> children;

        TrieNode() {
            this.children = new HashMap<>();
            this.endWord = false;
        }
    }

    private TrieNode root = new TrieNode();

    // insert
    public boolean insert(String word) {

        if (word == null || word.length() == 0) {
            return false;
        }

        char[] charArr = word.toCharArray();

        TrieNode currentNode = root;

        for (int i = 0; i < charArr.length; i++) {

            // Get the character
            Character ch = charArr[i];

            // Look up the hash map to check if a node is present.
            TrieNode node = currentNode.children.get(ch);

            // Node is present for that character
            if (node != null) {
                currentNode = node;
            } else {
                // no node is present for the character
                // create a new node
                node = new TrieNode();

                // save it in the map at this node
                currentNode.children.put(ch, node);

                currentNode = node;
            }

        }

        currentNode.endWord = true;

        return true;

    }

    // search
    public boolean isPresent(String searchString) {
        if (searchString == null || searchString.length() == 0) {
            return false;
        }

        char[] charArr = searchString.toCharArray();

        TrieNode currentNode = root;

        for (int i = 0; i < charArr.length; i++) {

            // Get the character
            Character ch = charArr[i];

            // Look up the hash map to check if a node is present.
            TrieNode node = currentNode.children.get(ch);

            // Node is present for that character
            if (node == null) {
                return false;
            }

            currentNode = node;
        }

        return currentNode.endWord;
    }

    // delete
    public void delete(String word) {

    }

}
