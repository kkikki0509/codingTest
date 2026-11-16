import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        
        int elementMax = 0;
        int elementMin = 0;
        
        for(int[] i : sizes){
            elementMax = Math.max(elementMax, Math.max(i[0], i[1]));
            elementMin = Math.max(elementMin, Math.min(i[0], i[1]));
        }
        
        return elementMax * elementMin;
    }
}