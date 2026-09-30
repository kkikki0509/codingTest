import java.util.*;

class Solution {

    List<String> route = new ArrayList<>();
    boolean[] used;

    public String[] solution(String[][] tickets) {

        used = new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

        route.add("ICN");
        dfs("ICN", tickets);

        return route.toArray(new String[0]);
    }

    private boolean dfs(String current, String[][] tickets) {

        if(route.size() == tickets.length + 1){
            return true;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!used[i] && tickets[i][0].equals(current)){
                used[i] = true;
                route.add(tickets[i][1]);
                
                if(dfs(tickets[i][1], tickets)){
                    return true;
                }
                
                route.remove(route.size() - 1);
                used[i] = false;
            }
        }
        
        return false;
    }
}