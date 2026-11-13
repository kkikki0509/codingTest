import java.util.*;
class Solution {
    int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        recursive(0, numbers, target, 0);
        return cnt;
    }
    
    public void recursive(int current, int[] numbers, int target, int idx){
        
        if(idx == numbers.length){
            if(target == current){
                cnt++;
            }
            return;
        }
        
        recursive(current + numbers[idx], numbers, target, idx + 1);
        recursive(current - numbers[idx], numbers, target, idx + 1);

    }
}