package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author dsaha
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 *  For example,
 *  Given [1,3],[2,6],[8,10],[15,18],
 *  return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
    
    public List<Interval> mergedIntervals(List<Interval> intervals) {
        
        List<Interval> mergedIntervals = new ArrayList();
        
        Collections.sort(intervals, new IntervalComparator());
        
        Interval ongoingInterval = new Interval(0,0);
        
        for (int i = 0; i<intervals.size()-1; i++) {
            Interval currentInterval = intervals.get(i);
            Interval nextInterval = intervals.get(i+1);
            
            if (currentInterval.getEndTime() > nextInterval.getStartTime()) {
                // Overlap detected
                ongoingInterval.startTime = (currentInterval.getStartTime() > ongoingInterval.getStartTime())?currentInterval.getStartTime():ongoingInterval.getStartTime();
                ongoingInterval.endTime = Math.max(currentInterval.getStartTime(), nextInterval.getEndTime());
            } else {
                // No overlap, add
                
            }
            
        }
        return mergedIntervals;
    }
}

class Interval {
    public Integer startTime;
    public Integer endTime;
    
    public Integer getStartTime () {
        return startTime;
    }
    
    public Integer getEndTime () {
        return endTime;
    }
    
    public Interval(Integer startTime, Integer endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
 
}

class IntervalComparator implements Comparator<Interval> {
    
    @Override
    public int compare (Interval interval1, Interval interval2) {
        if ( interval1.getStartTime() > interval2.getEndTime()) {
            return 1;
        } else {
            return -1;
        }
    }
    
}
