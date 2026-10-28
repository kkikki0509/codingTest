import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();

        visited[1] = true;
        dist[1] = 0;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[now] + 1;
                    queue.offer(next);
                }
            }
        }

        Arrays.sort(dist);
        int max = dist[n];
        int answer = 0;

        for (int i = n; i >=0; i--) {
            if(dist[i] == max){
                answer++;
            }
        }

        return answer;
    }
}