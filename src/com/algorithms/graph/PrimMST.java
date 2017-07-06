package com.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrimMST {
    
    public ArrayList<Edge> apply(Graph g, Vertex<Integer> distanceFrom) {

        ArrayList<Edge> result = new ArrayList<Edge>();
        
        // Initialize minHeap
        BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<Vertex<Integer>>();

        // Path map
        Map<Vertex<Integer>, Edge> parentMap = new HashMap<Vertex<Integer>, Edge>();

        for (Vertex<Integer> v : g.getVertices()) {

            if (distanceFrom == v) {
                minHeap.add(0, v);
            } else {
                minHeap.add( Integer.MAX_VALUE, v);
            }
        }

        while (!minHeap.empty()) {
            
            // 1. Extract minimum from the heap
            Vertex<Integer> current = minHeap.extractMin();
            
            // 2. Add edges of the tree
            Edge STE = parentMap.get(current);
            if (STE!=null) {
                result.add(STE);
            }
            
            // 3. Start exploring children of the vertex that was just added
            for (Edge e : current.getEdges()) {

                // 3.a get vertext for an edge
                Vertex v = getVertexForEdge(current, e);

                // 3.b If we find an edge into a vertex with weight less than what 
                //     was previously explored, update minheap and parentMap
                if (minHeap.contains(v) && e.getWeight() < minHeap.getWeight(v)) {
                    minHeap.decrease(v, e.getWeight());
                    parentMap.put(v, e);
                }
            }
        }
        
        return result;
    }
    
    private Vertex getVertexForEdge(Vertex v, Edge e){
        return e.getDestination().equals(v) ? e.getDestination() : e.getSource();
    }
}
