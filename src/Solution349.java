import java.util.*;
//Given two arrays, write a function to compute their intersection.
//
//Example:
//Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
public class Solution349 {
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < nums1.length;i ++){
            set.add(nums1[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i < nums2.length;i ++){
            if(set.contains(nums2[i]) && !ans.contains(nums2[i])){
                ans.add(nums2[i]);
            }
        }
        int[] res = new int[ans.size()];
        for(int i = 0;i < ans.size();i ++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
