import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        
        for(String city: cities) {
            String upperCaseCity = city.toUpperCase();
            
            // 도시가 캐시에 존재할 경우, 해당 도시의 순서를 가장 뒤로 변경 (Least Recently Used)
            if(cache.contains(upperCaseCity)) {
                cache.remove(upperCaseCity);
                cache.add(upperCaseCity);
                answer += 1;
            // 도시가 캐시에 존재하지 않을 경우
            } else {
                // 캐시 크기가 최대치일 경우 선입선출
                if(cache.size() == cacheSize) {
                    cache.poll();
                }
                
                if(cacheSize != 0) {
                    cache.add(upperCaseCity);
                }
                
                answer += 5;
            }
        }
        
        return answer;
    }
}