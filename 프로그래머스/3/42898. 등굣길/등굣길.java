import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dist = new int[m][n];
        boolean flag = false;
        
        dist[0][0] = 1;
        
        for(int i = 0; i < dist.length; i++){
            for(int j = 0; j < dist[i].length; j++){
                flag = false;
                
                for(int k = 0; k < puddles.length; k++){
                    if(i == puddles[k][0] - 1 && j == puddles[k][1] - 1){
                        flag = true;
                        break;
                    }
                }
                
                if(flag){
                    continue;
                }
                
                if(i - 1 >= 0 && j - 1 >= 0){
                    dist[i][j] = (dist[i - 1][j] + dist[i][j - 1]) % 1000000007;
                }
                else if(i - 1 >= 0){
                    dist[i][j] = (dist[i][j] + dist[i - 1][j]) % 1000000007;
                }
                else if(j - 1 >= 0){
                    dist[i][j] = (dist[i][j] + dist[i][j - 1]) % 1000000007;
                }
            }
        }
        
        int r = dist.length - 1;
        int c = dist[r].length - 1;
        return dist[r][c];
        
    }
}