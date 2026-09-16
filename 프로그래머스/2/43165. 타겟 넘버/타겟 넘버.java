class Solution {
    int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        boolean[] invite = new boolean[numbers.length];
        int sum = 0;
        DFS(0, sum, numbers, target);
        
        return cnt;
    }
    
    public void DFS(int node, int sum, int[] numbers, int target){
        if(node == numbers.length){
            if(target == sum){
                cnt++;
            }
            return;
        }
        DFS(node + 1, sum + numbers[node], numbers, target);
        DFS(node + 1, sum - numbers[node], numbers, target);
    }
}