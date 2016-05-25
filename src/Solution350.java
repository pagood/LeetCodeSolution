import java.util.*;
//Given two arrays, write a function to compute their intersection.
//
//Example:
//Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
//
//Note:
//Each element in the result should appear as many times as it shows in both arrays.
//The result can be in any order.

public class Solution350 {
	public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i < nums1.length;i ++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i]) + 1);
            }
            else{
                map.put(nums1[i],1);
            }
            
        }
        List<Integer> helper = new ArrayList<>();
        for(int i = 0;i < nums2.length;i ++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                helper.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i]) - 1);
            }
            
        }
        int[] ans = new int[helper.size()];
        for(int i = 0;i < helper.size();i ++){
            ans[i] = helper.get(i);
        }
        return ans;
    }
}
