package com.algorithms.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TripPlanner {

    ArrayList<Trip> trips = new ArrayList();
    ArrayList<String> result = new ArrayList();
    boolean[] used = null;
    
    public TripPlanner(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            String[] it = tickets[i];
            Trip t = new Trip(it[0], it[1]);
            trips.add(t);
        }
        
        used = new boolean[trips.size()];
        
        for (int i = 0; i < tickets.length; i++) {
            used[i] = false;
        }
                
        // System.out.println("flight hops" + trips.size());
         
        Collections.sort(trips);
    }

    public List<String> itinerary() {

        if(x("JFK")) {
            System.out.println("All processed");
        }

        for (String s: result) {
            System.out.print(s+" ");
        }
               
        return result;
    }

    private boolean x(String start) {

        int i=0;
        
        // iterate through the list and pick the first starting point
        for (Trip t : trips) {
            
            if (used[i]) {
                i++;
                continue;
            }
            
            if (t.s.equals(start) && used[i]== false) {
                // push the trip in the result
                result.add(t.s);

                used[i] = true;
                
                // JFK...corresponding destination becomes starting point
                return x(t.d);
            }
            
            i++;
        }
        
        if (i == used.length) {
            result.add(start);
            return true;
        }
        
        return false;
    }
    
    public static void driver() {
        
        String[][] trips = new String[][]{{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
        //{{"DEL","JFK"},{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"},{"JFK","DEL"},{"SJC","JFK"}};
        TripPlanner tp = new TripPlanner(trips);
        tp.itinerary();
        
//        List<String> result = tp.itinerary();
//        for (String s: result) {
//            //System.out.print(s+" ");
//        }
//        System.out.println();
    }
}

class Trip implements Comparable<Trip> {

    String d;
    String s;

    public Trip(String s, String d) {
        this.s = s;
        this.d = d;
    }

    @Override
    public int compareTo(Trip other) {

        // If the start is same order by destination
        if (this.s.equals(other.s)) {
            return this.d.compareTo(other.d);
        } else {
            // Otherwise order by start
            return this.s.compareTo(other.s);
        }

    }
}
