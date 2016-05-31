import java.util.*;
//Given two strings s and t, write a function to determine if t is an anagram of s.
//
//For example,
//s = "anagram", t = "nagaram", return true.
//s = "rat", t = "car", return false.
public class Solution242 {
	public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map  = new HashMap<>();
        for(int i = 0;i < s.length();i ++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }
            else map.put(c,map.get(c) + 1);
        }
        for(int i = 0;i < t.length();i ++){
            char c = t.charAt(i);
            if(map.containsKey(c) && map.get(c) > 0){
                map.put(c,map.get(c) - 1);
            }
            else return false;
        }
        Set<Character> keys = map.keySet();
        for(Character c:keys){
            if(map.get(c) != 0) return false;
        }
        return true;
    }
}
