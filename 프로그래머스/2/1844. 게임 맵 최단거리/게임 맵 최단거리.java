import java.util.*;

class Solution {

    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;

        boolean[][] invite = new boolean[n][m];

        Queue<int[]> queue = new ArrayDeque<>();

        // 시작점
        queue.offer(new int[]{0, 0});
        invite[0][0] = true;

        // 동, 서, 남, 북
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];

            // 상대 팀 도착
            if (x == n - 1 && y == m - 1) {
                return maps[x][y];
            }

            // 동, 서, 남, 북 탐색
            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵 밖
                if (nx <= -1 || nx >= n || ny <= -1 || ny >= m) {
                    continue;
                }

                // 벽
                if (maps[nx][ny] == 0) {
                    continue;
                }

                // 이미 방문
                if (invite[nx][ny]) {
                    continue;
                }

                invite[nx][ny] = true;

                // 거리 기록
                maps[nx][ny] = maps[x][y] + 1;

                queue.offer(new int[]{nx, ny});
            }
        }

        // 상대 팀 진영에 도착할 수 없음
        return -1;
    }
}