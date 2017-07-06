package com.algorithms.graph;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet<Generic> {
    
    private Map<Generic,DisjointSetNode> map = new HashMap<>();
    
    // Disjoint Set APIs
    class DisjointSetNode<Generic> {
        int rank;
        Generic data;
        DisjointSetNode parent;
        
        DisjointSetNode(){}
        
        DisjointSetNode(Generic data) {
            this.data = data;
        }
    }

    // makeSet
    public void makeSet(Generic data) {
        DisjointSetNode<Generic> node = new DisjointSetNode<>(data);
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }
    
    // Union
    // returns true if data are in same set or false if data are in different set
    public boolean union(Generic a, Generic b) {
        
        DisjointSetNode<Generic> one = map.get(a);
        DisjointSetNode<Generic> two = map.get(b);
        
        // Find the set to which they belong and then make union
        DisjointSetNode<Generic> parentOne = findSet(a);
        DisjointSetNode<Generic> parentTwo = findSet(b);
        
        if (parentOne.data == parentTwo.data) {
            return true;
        }
        
        if (parentTwo.rank > parentOne.rank) {
            parentOne.parent = parentTwo;
        } else {
            parentTwo.parent = parentOne;
            parentOne.rank = ((parentOne.rank == parentTwo.rank)?(parentOne.rank+1):parentOne.rank);
        }
        
        return false;
    }
    
    // findSet
    public DisjointSetNode<Generic> findSet(Generic a) {
        DisjointSetNode<Generic> one = map.get(a);
        DisjointSetNode<Generic> node = one.parent;
        while (node!= node.parent) {
            node = node.parent;
        }
        
        one.parent = node;
        return one.parent;
    }
    
    public static void driver() {
        DisjointSet<Integer> ds = new DisjointSet<Integer>();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1).data);
        System.out.println(ds.findSet(2).data);
        System.out.println(ds.findSet(3).data);
        System.out.println(ds.findSet(4).data);
        System.out.println(ds.findSet(5).data);
        System.out.println(ds.findSet(6).data);
        System.out.println(ds.findSet(7).data);
    }
}
