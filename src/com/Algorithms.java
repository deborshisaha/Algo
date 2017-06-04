package com;

import com.algorithms.arrays.*;
import com.algorithms.string.*;
import java.util.List;

/**
 *
 * @author dsaha
 */
public class Algorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ThreeSum threeSum = new ThreeSum();
        int[] array = new int[]{-1,0,2,1,1,4,3};
        List<List<Integer>> result = threeSum.getListOfListOfIntegers(5, array);
        
        if (result.size() > 0) {

            result.forEach((list) -> {
                list.forEach((lis) -> {
                    System.out.print(lis+",");
                });
                
                System.out.print("\n");
            });
        }
        
        SmallestWindowContaingAllCharacters.driver();
        KMPSubstringSearch.driver();
        AbbreviationChecker.driver();
        LongestPalindromeSubstring.driver();
        
        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| LongestSubstringWithKDistinctCharacters                 |");
        System.out.println("+---------------------------------------------------------+");
        LongestSubstringWithKDistinctCharacters.driver();
        
        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Palindrome Pair                                         |");
        System.out.println("+---------------------------------------------------------+");
        PalindromePair.driver();
        
        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| BestTimeToBuyAndSellAStock                              |");
        System.out.println("+---------------------------------------------------------+");
        BestTimeToBuyAndSellAStock.driver();
        
        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| SelfCrossing                                            |");
        System.out.println("+---------------------------------------------------------+");
        SelfCrossing.driver();
        
        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Merge Intervals                                            |");
        System.out.println("+---------------------------------------------------------+");
        MergeIntervals.driver();
    }
    
}
