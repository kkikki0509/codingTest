import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int min = 100;
        
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        for(int[] wire : wires){
            boolean[] invited = new boolean[n + 1];
            int cnt = 1;
            invited[wire[0]] = true;
                
            int result = DFS(graph, invited, wire[0], wire[0], wire[1], cnt);
            System.out.println(result);
            min = Math.min(min, Math.abs(result - (n - result)));
        }
        
        return min;
    }
    
    public int DFS(ArrayList<Integer>[] graph, boolean[] invited, int nodeReal, int nodeA, int nodeB, 
                    int cnt){
        
        for(int next : graph[nodeReal]){
            if(next == nodeB && nodeReal == nodeA){
                continue;
            }
            
            if(!invited[next]){
                invited[next] = true;
                cnt += DFS(graph, invited, next, nodeA, nodeB, 1);
            }   
        }
        
        return cnt;
    }
}