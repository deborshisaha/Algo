package com.algorithms.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TripPlanner {

    ArrayList<Trip> trips = new ArrayList();
    ArrayList<String> result = new ArrayList();

    public TripPlanner(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            String[] it = tickets[i];
            Trip t = new Trip(it[0], it[1]);
            trips.add(t);
        }
        
        System.out.println("flight hops" + trips.size());
        
        for (Trip t : trips) {
            System.out.println(t.s + "->" + t.d);
        }
                
        Collections.sort(trips);
    }

    public List<String> itinerary() {


        x("JFK", trips.size());

        return result;
    }

    private void x(String start, int count) {

        if (count == 0) {
            return;
        }
        
        // iterate through the list and pick the first starting point
        for (Trip t : trips) {
            if (t.s.equals(start)) {
                // push the trip in the result
                result.add(t.s);
                //trips.remove(t);

                // JFK...corresponding destination becomes starting point
                x(t.d, count-1);
            }
        }
    }
    
    public static void driver() {
        String[][] trips = new String[][]{{"DEL","JFK"},{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"},{"JFK","DEL"},{"SJC","JFK"}};
        TripPlanner tp = new TripPlanner(trips);
        tp.itinerary();
        
        List<String> result = tp.itinerary();
        for (String s: result) {
            //System.out.print(s+" ");
        }
        System.out.println();
    }
}

class Trip implements Comparable<Trip> {

    String d;
    String s;

    public Trip(String s, String d) {
        this.s = s;
        this.d = d;
    }

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
