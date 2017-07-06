package com.algorithms.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BridgeFinder {

    private Graph graph = null;
    private int time = 0;
    
    private final Map<Vertex<String>, Integer> discovery = new HashMap<>();
    private final Map<Vertex<String>, Integer> low = new HashMap<>();
    private final Map<Vertex<String>, Vertex<String>> parentMap = new HashMap<>();
    private final Map<Vertex<String>, Boolean> visited = new HashMap<>();

    public BridgeFinder(Graph graph) {
        this.graph = graph;
    }
    
    public BridgeFinder() {}
    
    public Set<Edge> getBridges() {
        
        Set<Edge> bridges = new HashSet<Edge>();
        
        for (Vertex<String> vertex : this.graph.getVertices()) {
            if(!visited.containsKey(vertex) ){
                BridgeUtil(vertex, bridges);
            }
        }
                
        return bridges;
    }
    
    private void BridgeUtil(Vertex<String> parent, Set<Edge> result) {
        
        this.visited.put(parent, true);
        this.discovery.put(parent, time);
        this.low.put(parent, time);
        time++;
        
        System.out.println("Parent: "+ parent.getIdentifier());
        
        for (Vertex<String> child : parent.getChildren()) {
            
            System.out.println("Inspecting: "+ child.getIdentifier()+" Parent: "+ parent.getIdentifier());
            
            if (!visited.containsKey(child)) {
                
                parentMap.put(child, parent);
                
                BridgeUtil(child, result);

                System.out.println("child: "+ child.getIdentifier()+" parent: "+ parent.getIdentifier());
                System.out.println("discovery.get(parent): "+ discovery.get(parent)+" low.get(child): "+ low.get(child));
                
                if (discovery.get(parent) < low.get(child)) {
                    result.add(new Edge(parent, child));
                }
                System.out.println("Putting: "+Math.min(discovery.get(parent), low.get(child))+" for "+parent.getIdentifier());
                low.put(parent, Math.min(discovery.get(parent), low.get(child)));
                System.out.println();
            } else {
                System.out.println(child.getIdentifier() + " Visited already ");
                Vertex grandFather = parentMap.get(parent);
                
                if (grandFather!= null && !child.equals(grandFather)) {
                    
                    System.out.println(child.getIdentifier() + " not same as grandFather:" + grandFather.getIdentifier()+" Father:"+parent.getIdentifier());
                    System.out.println(parent.getIdentifier() + " gets low point:min("+discovery.get(parent)+","+low.get(child)+")=" + Math.min(discovery.get(parent), low.get(child)));
                    low.put(parent, Math.min(discovery.get(parent), low.get(child)));
                }
            }
        }
    }

    public static void driver() {
        GraphSetting setting = new GraphSetting();
        setting.setDirected(false);

        Graph graph = new Graph(setting);

        graph.addEdge("B", "A", 0);
        graph.addEdge("A", "C", 0);
        graph.addEdge("C", "B", 0);
        graph.addEdge("A", "D", 0);
        graph.addEdge("D", "E", 0);
        
        BridgeFinder bridgeFinder = new BridgeFinder(graph);
        bridgeFinder.getBridges();
    }
}
