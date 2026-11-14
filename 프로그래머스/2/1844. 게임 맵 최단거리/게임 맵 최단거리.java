import java.util.*;

class Solution {
    int cnt = 0;
    
    public int solution(int[][] maps) {
        Deque<Node> deq = new ArrayDeque<>();
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        boolean flag = false;
        
        deq.offerLast(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while(!deq.isEmpty()){
            Node node = deq.pollFirst();    
            
            int x = node.x;
            int y = node.y;
            int dist = node.dist;
            
            if(x == n - 1 && y == m - 1){
                flag = true;
                cnt = dist;
                break;
            }
                
            // 좌
            if(x > 0 && maps[x - 1][y] == 1 && !visited[x - 1][y]){
                deq.offerLast(new Node(x - 1, y, dist + 1));
                visited[x - 1][y] = true;
            }
            // 우 
            if(x < n - 1 && maps[x + 1][y] == 1 && !visited[x + 1][y]){
                deq.offerLast(new Node(x + 1, y, dist + 1));
                visited[x + 1][y] = true;
            }                
            // 상
            if(y > 0 && maps[x][y - 1] == 1 && !visited[x][y - 1]){
                deq.offerLast(new Node(x, y - 1, dist + 1));
                visited[x][y - 1] = true;
            }
            // 하
            if(y < m - 1 && maps[x][y + 1] == 1 && !visited[x][y + 1]){
                deq.offerLast(new Node(x, y + 1, dist + 1));
                visited[x][y + 1] = true;
            }
            
        }
        
        if(!flag){
            cnt = -1;
        }
        
        return cnt;
    }
    
    class Node{
        int x;
        int y;
        int dist;
        
        public Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}