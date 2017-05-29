/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algorithms.string;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dsaha
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class SmallestWindowContaingAllCharacters {
    
    private String source = null;
    private String target = null;
    private String result = null;

    public SmallestWindowContaingAllCharacters(String source, String target) {
        this.source = source;
        this.target = target;
    }
    
    public String getSubstring() {
        
        if (this.result == null) {
            this.result = computeSubstring();
        }
        
        return this.result;
    } 
   
    public int getSubstringWindowLength () {
        return this.result.length();
    }
    
    private String computeSubstring() {
        
        String res = null;
        int count = 0;
        int minLength = Integer.MAX_VALUE;
    
        // target hash map 
        Map<Character, Integer> targetHashMap = new HashMap<Character, Integer>();
        
        int targetIterator = 0;

        // Create target hash map
        while(targetIterator < this.target.length()) { 
            targetIterator++;
            char c = this.target.charAt(targetIterator);
            
            if (targetHashMap.containsKey(c)) { 
                targetHashMap.put(c, targetHashMap.get(c)+1);
            } else {
                targetHashMap.put(c, 1);
            }
        }
        
        Map<Character, Integer> substringHashMap = new HashMap<Character, Integer>();
        
        for (int i=0; i < this.source.length(); i++) {
            
            Character sc = this.source.charAt(i);
            
            if (targetHashMap.containsKey(sc)) {
                if (substringHashMap.containsKey(sc)) {
                    // update the map count, do not update the count
                     
                    if (substringHashMap.get(sc) < targetHashMap.get(sc)) {
                        count++;
                    }
                    
                    substringHashMap.put(sc, substringHashMap.get(sc)+1);
                } else {
                    substringHashMap.put(sc, 1); 
                    count++;
                }
            } else {
                continue;
            }
            
            int left = 0;
            if (count == this.target.length()) {
                
                Character lc = this.source.charAt(left);
                while (!substringHashMap.containsKey(lc) || substringHashMap.get(lc) > targetHashMap.get(lc)) {
                    if (substringHashMap.containsKey(lc)) {
                        substringHashMap.put(lc, substringHashMap.get(lc)-1);
                    }
                    
                    left++;
                }
                
                if (i-left < minLength) {
                    minLength = i-left;
                    res = this.source.substring(left, i);
                }
            }
        }

        return res;
    }
}
