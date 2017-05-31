package com;

import com.algorithm.string.AbbreviationChecker;
import com.algorithms.arrays.BestTimeToBuyAndSellAStock;
import com.algorithms.arrays.SelfCrossing;
import com.algorithms.arrays.ThreeSum;
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
        LongestSubstringWithKDistinctCharacters.driver();
        
        System.out.println("+----------------------------------+");
        System.out.println("| Palindrome Pair                  |");
        System.out.println("+----------------------------------+");
        PalindromePair.driver();
        
        System.out.println("+----------------------------------+");
        System.out.println("| BestTimeToBuyAndSellAStock       |");
        System.out.println("+----------------------------------+");
        BestTimeToBuyAndSellAStock.driver();
        
        SelfCrossing.driver();
    }
    
}
