import java.util.*;
//Given two strings, find the longest common subsequence (LCS).
//
//Your code should return the length of LCS.
//		Example
//		For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.
//
//		For "ABCD" and "EACB", the LCS is "AC", return 2.

//Use memoization to speed up the evaluation. Often one gets both an efficient recursive method and an efficient iterative method out of this. It helps to look at the dag of dependencies of subproblems. 
//Intuitively, larger subproblems depend on the smaller ones. The process can be viewed as filling a table.

// 状态转移方程！
public class LCS {
	public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A.length() == 0 || B.length() == 0) return 0;
        int[][] helper = new int[A.length()][B.length()];
        int a = A.indexOf(B.charAt(0));
        int b= B.indexOf(A.charAt(0));
        if(a >= 0){
            for(int i = a;i < A.length();i ++){
                helper[i][0] = 1;
            }
        }
        if(b >= 0){
            for(int i = b;i < B.length();i ++){
                helper[0][i] = 1;
            }
        }
        for(int i = 1;i < A.length();i ++){
            for(int j = 1;j < B.length();j ++){
                if(A.charAt(i) == B.charAt(j)){
                    helper[i][j] = helper[i - 1][j - 1] + 1;
                }
                else{
                    helper[i][j] = Math.max(helper[i - 1][j - 1],Math.max(helper[i][j - 1],helper[i - 1][j]));
                }
                
            }
        }
        return helper[A.length() - 1][B.length() - 1];
    }
}
