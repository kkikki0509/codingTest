import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        Set<Integer> count = new HashSet<>();
        int[] root = new int[computers.length];
        boolean[] invite = new boolean[computers.length];
        
        for(int i = 1; i < root.length; i++){
            root[i] = -1;
        }
        
        for(int i = 0; i < computers.length; i++){
            DFS(i, root, invite, computers);
        }
        
        int prev = root[0];
        for(int i = 0; i < root.length; i++){
            count.add(root[i]);
        }
        
        return count.size();
    }
    
    public void DFS(int node, int[] root, boolean[] invite, int[][] computers){
        invite[node] = true;
        
        if(root[node] == -1){
            root[node] = node;
        }
        
        for(int i = 0; i < computers[node].length; i++){
            if(computers[node][i] == 0) {
                continue;
            }
            
            if(node == i || invite[i]){
                continue;
            }
         
            if(root[i] != -1){
                for(int k = 0; k < root.length; k++){
                    if(root[k] == root[i]){
                        root[k] = root[node];
                    }
                }
            }
                
            else{
                root[i] = root[node];
            }
                  
            DFS(i, root, invite, computers);
             
        }
    }
}