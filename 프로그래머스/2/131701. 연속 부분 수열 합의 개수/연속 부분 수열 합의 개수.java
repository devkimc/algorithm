import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int len = elements.length;
        
        Set<Integer> setResult = new HashSet<>();
        
        // i = 수열의 길이
        for(int i = 1; i < len + 1; i++) {
            // 모든 수를 더하는 경우는 하나의 경우이므로 결과값만 증가시키고 루프를 돌리지 않음
            if(i == len) {
                answer++;
                break;
            }
            
            // j = 각 수열의 시작 index
            for(int j = 0; j < len; j++) {
                int sum = 0;
                
                // k = 더하려는 수열의 index, 수열의 길이만큼 합을 구한다.
                for(int k = 0; k < i; k++) {
                    // 더하려는 수열의 index가 배열의 마지막 index를 초과할 경우 길이만큼 값을 뺀다.
                    int indexOfSumNum = j + k > len - 1 ? j + k - len : j + k;
                    sum += elements[indexOfSumNum];
                }
                
                setResult.add(Integer.valueOf(sum));
            }
        }
        
        return answer + setResult.size();
    }
}