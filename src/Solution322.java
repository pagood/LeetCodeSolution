import java.util.*;
public class Solution322 {
	 public int coinChange(int[] coins, int amount) {
	        int[] helper = new int[amount + 1];
	        for(int i = 0;i < coins.length;i ++){
	            if(coins[i] < helper.length) helper[coins[i]] = 1;
	        }
	        for(int i = 1;i < helper.length;i ++){
	            if(helper[i] == 0) helper[i] = Integer.MAX_VALUE - 1;
	            for(int j = 0;j < coins.length;j ++){
	                if(i >= coins[j]){
	                    helper[i] = Math.min(helper[i - coins[j]] + 1,helper[i]);
	                }
	            }
	            if(helper[i] == Integer.MAX_VALUE - 1) helper[i] = -1;
	        }
	        return helper[amount];
	    }
	   
    public static void main(String[] args){
    	Solution322 s = new Solution322();
    	System.out.println(s.coinChange(new int[]{1,2,5},11));
    }
}
