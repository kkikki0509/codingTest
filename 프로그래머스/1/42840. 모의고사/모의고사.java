import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] one = new int[]{1, 2, 3, 4, 5};
        int[] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[][] sorts = { {1, 0}, {2, 0}, {3, 0} };
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == one[i % one.length]){
                sorts[0][1]++;
            }
            if(answers[i] == two[i % two.length]){
                sorts[1][1]++;
            }
            if(answers[i] == three[i % three.length]){
                sorts[2][1]++;
            }
        }
        
        Arrays.sort(sorts, (a, b) -> {
            if(b[1] == a[1]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });
        
        int max = sorts[0][1];
        int equalsCnt = 1;
        for(int i = 1; i < 3; i++){
            if(max == sorts[i][1]){
                equalsCnt++;
            }
        }
        
        int[] ans = new int[equalsCnt];
        for(int i = 0; i < equalsCnt; i++){
            ans[i] = sorts[i][0];
        }
        return ans;
    }
}