import java.util.*;
//Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
//
//For example:
//
//Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

//第一遍xor 找出两个数的xor值，任意取一个为1的位将数组分成两组分别xor
public class Solution260 {
	public int[] singleNumber(int[] nums) {
        int helper = 0;
        for(int i = 0;i < nums.length;i ++){
            helper = helper ^ nums[i];
        }
        helper &= -helper;
        int[] ans = {0,0};
        for(int i = 0;i < nums.length;i ++){
            if((nums[i] & helper) == 0){
                ans[0] = ans[0] ^ nums[i];
            }
            else{
                ans[1] = ans[1] ^ nums[i];
            }
        }
        return ans;
    }
}
