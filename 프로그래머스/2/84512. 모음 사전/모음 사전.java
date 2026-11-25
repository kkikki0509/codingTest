class Solution {
    String[] s = {"A", "E", "I", "O", "U"};
    boolean flag = false;
    int ans = 0;
    
    public int solution(String word) {
        String alpha = "";
        
        DFS(word, alpha);
        return ans;
    }
    
    public void DFS(String word, String alpha){
        
        if(alpha.length() > 5){
            ans--;
            return;
        }
        
        if(alpha.equals(word)){
            flag = true;
            return;
        }
        
        for(int i = 0; i < s.length; i++){
            if(flag){
                break;
            }
            
            ans++;
            DFS(word, alpha + s[i]);
            
        }
    
    }
}