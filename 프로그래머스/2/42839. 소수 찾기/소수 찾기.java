import java.util.*;

class Solution {
    Set<Integer> arr = new HashSet<>();
    public int solution(String numbers) {
        char[] c = numbers.toCharArray();
        int ans = 0;
        
        for(int i = 0; i < c.length; i++){
            boolean[] invited = new boolean[c.length];
            int cnt = 1;
            
            invited[i] = true;
            String s = String.valueOf(c[i] - '0');
            arr.add((int)c[i] - '0');
            
            DFS(cnt, invited, c, s);    
        }
        
        Iterator<Integer> iter = arr.iterator();
        
        while(iter.hasNext()){
            boolean flag = true;
            int num = iter.next();
            
            if(num < 2){ // 소수 아님
                continue;
            }
            
            for(int j = 2; j <= Math.sqrt(num); j++){
                if(num % j == 0){
                    flag = false;
                }
            }
            
            if(flag){
                ans++;
            }
        }
        
        System.out.println(arr);
        return ans;
    }
    
    public void DFS(int cnt, boolean[] invited, char[] c, String s){
        
        if(cnt == c.length + 1){ // 한 조합을 다 탐색했다면
            return;
        }
        
        for(int i = 0; i < c.length; i++){
            if(!invited[i]){ // 방문하지 않았다면
                invited[i] = true;
                
                arr.add(Integer.parseInt(s + c[i]));
                DFS(cnt + 1, invited, c, s + c[i]);
                invited[i] = false;
            }
        }
        
    }
}