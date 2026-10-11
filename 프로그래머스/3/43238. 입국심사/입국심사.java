
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long answer = 0;
        long start = 1;
        long end = (long) times[times.length - 1] * n;
        long mid = 0;

        while (start < end) {
            mid = (start + end) / 2;
            int code = cal(mid, times, n);

            if (code == 2) {
                end = mid;
            } 
            else if (code == 0) {
                start = mid + 1;
            }
        }

        answer = start;
        return answer;
    }

    public int cal(long mid, int[] times, int n) { // 0 - 부족 1 - 찾음 2 - 많음
        
        long sum = 0;

        for (int i = 0; i < times.length; i++) {
            sum += mid / times[i];

            if (sum >= n) {
                return 2;
            }
        }

        if (sum < n) {
            return 0;
        } 
        return 1;
    }
}
