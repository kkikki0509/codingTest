import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        
        int i = 1, idx = 0;
        int[] arr = new int[(int)Math.sqrt(yellow)];
        
        while(i <= Math.sqrt(yellow)){ // 약수
            if(yellow % i == 0){
                arr[idx++] = yellow / i;
            }
            
            i++;
        }
        
        for(int num : arr){
            int height = (yellow / num) + 2;
            int width = num + 2;
            int size = width * height; // 총 면적
            
            if(size == brown + yellow){
                return new int[] {width, height};
            }
        }
        
        return null;
    }
}