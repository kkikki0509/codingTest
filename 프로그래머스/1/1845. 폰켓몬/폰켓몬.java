import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = nums.length / 2;
        int ans = 0;
        
        for(int i : nums){
            set.add(i);
        }
        
        int kind = set.size();
        if(kind < max){
            ans = kind;
        }
        else{
            ans = max;
        }
        
        return ans;
    }
}