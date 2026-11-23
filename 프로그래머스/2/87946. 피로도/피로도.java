import java.util.*;
class Solution {
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        int depth = 0;
        int cnt = 0;
        DFS(dungeons, visited, depth, k, cnt);
        
        return max;
    }
    
    public void DFS(int[][] dungeons, boolean[] visited, int depth, int k, int cnt){
        if(depth == dungeons.length) {
            max = Math.max(max, cnt);
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++){
            
            if(k < dungeons[i][0] && !visited[i]){ // 던전 입장 불가
                visited[i] = true;
                DFS(dungeons, visited, depth + 1, k, cnt);
                visited[i] = false;
                continue;
            }
            
            if(!visited[i]){
                visited[i] = true;
                DFS(dungeons, visited, depth + 1, k - dungeons[i][1], cnt + 1);
                visited[i] = false;
            }
            
        }
    }
}