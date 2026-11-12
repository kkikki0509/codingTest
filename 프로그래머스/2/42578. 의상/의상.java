import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] s : clothes){
            map.put(s[1], map.getOrDefault(s[1], 1) + 1);
        }
        
        int mux = 1;
        for(int i : map.values()){
            mux *= i;
        }
     
        return mux - 1;
    }
}