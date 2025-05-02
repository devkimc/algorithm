import java.util.*;

class Solution {
    public long solution(int n) {
        int[] array = new int[2001];
        array[1] = 1;
        array[2] = 2;
        
        // DP 알고리즘 사용 - 아래의 식이 성립되므로
        // dp[n] = dp[n-1] + dp[n-2];
        for(int i = 3; i <= n; i++) {
            array[i] = (array[i-1] + array[i-2]) % 1234567;
        }
        
        return array[n];
    }
}