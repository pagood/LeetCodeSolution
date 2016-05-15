import java.util.*;
//Given a non-empty array of integers, return the k most frequent elements.
//
//For example,
//Given [1,1,1,2,2,3] and k = 2, return [1,2].
//维护一个大小为k的优先队列，时间复杂度O(nLogk);
public class Solution347 {
	class Element{
        int num;
        int f;
        public Element(int num,int f){
            this.num  =num;
            this.f = f;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map  =new HashMap<>();
        for(int i = 0;i < nums.length;i ++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        Set<Integer> keys = map.keySet();
        List<Element> list = new ArrayList<>();
        for(Integer i:keys){
            list.add(new Element(i,map.get(i)));
        }
        Queue<Element> queue = new PriorityQueue<>(new Comparator<Element>(){
            @Override
            public int compare(Element a,Element b){
                return a.f - b.f;
            }
        });
        for(int i = 0;i < list.size();i ++){
            queue.add(list.get(i));
            if(queue.size() > k) queue.poll();
        }
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            ans.add(0,queue.poll().num);
        }
        return ans;
    }
}
