import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
       
        int[] ans = new int[commands.length];
        int j = 0;
        
        for(int[] r : commands){
            int s = r[0]; 
            int e = r[1];
            int k = r[2];
            
            int[] arr = new int[e - s + 1];
            
            for(int i = 0; i < arr.length; i++){
                arr[i] = array[s + i - 1];
            }
            
            Arrays.sort(arr);
            ans[j++] = arr[k - 1];
            
        }
        return ans;
    }
}