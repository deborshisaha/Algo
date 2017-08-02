package com.algorithms.dp;

public class DistinctSubsequences {

    public static void driver() {
        System.out.println();
        System.out.println();
        DistinctSubsequences obj = new DistinctSubsequences();
        System.out.println(obj.getNumberOfDistinctSubsequences("rabbbit", "rabbit"));
    }

    public int getNumberOfDistinctSubsequences(String source, String target) {

        int m = source.length() - 1;
        int n = target.length() - 1;

        int[][] T = new int[m+1][n+2];

        for (int r = 0; r <= m; r++) {
            T[r][0] = 1;
        }
        
        for (int r = 0; r <= m; r++) {
            for (int c = 1; c <= n+1; c++) {
                
                if (source.charAt(r) == target.charAt(c)) {
                    T[r]
                }
            }
        }
        
        return T[m][n];
    }
}
