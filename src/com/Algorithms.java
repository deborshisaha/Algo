/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.algorithms.string.SmallestWindowContaingAllCharacters;
import com.algorithms.arrays.ThreeSum;
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
        System.out.println("Hello");
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
        
        SmallestWindowContaingAllCharacters swcac = new SmallestWindowContaingAllCharacters("ABCDEDABC","DDAC");
        System.out.println(swcac.getSubstring());
    }
    
}
