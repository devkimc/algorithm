import java.util.*;

class Solution {
    public int solution(String dirs) {
        // Set 을 만들어서 길이 계산 = 처음 걸어본 길이, List: (이동 전 x, 이동 전 y, 이동 후 x, 이동 후 y)
        Set<List<Integer>> set = new HashSet<>();
        
        // 현재 위치
        int x = 0;
        int y = 0;
        
        // 방향에 따라 다음 이동할 길이를 map으로 저장
        Map<Character, int[]> movingMap = new HashMap<>();
        movingMap.put('U', new int[]{0,1});
        movingMap.put('D', new int[]{0,-1});
        movingMap.put('R', new int[]{1,0});
        movingMap.put('L', new int[]{-1,0});
        
        // Loop
        for(char dir: dirs.toCharArray()) {
            
            // 방향에 따라 다음 이동할 길이 계산
            int[] nextMoving = movingMap.get(dir);
            int nextX = x + nextMoving[0];
            int nextY = y + nextMoving[1];
            
            // 이동할 위치가 좌표 내부인 경우, 위치 이동
            if(isValidDistance(nextX, nextY)) {
                // 이동하기 전에 처음 걸은 걸이를 세팅해야 함, 다른 방향에서 걸어온 것도 추가하기 위해 2번 추가
                set.add(List.of(x, y, nextX, nextY));
                set.add(List.of(nextX, nextY, x, y));
                
                x = nextX;
                y = nextY;
            }
        }
        
        // 양방향 기준으로 계산했으므로 2로 나눔
        return set.size() / 2;
    }
    
    // 이동할 위치가 좌표를 벗어나는지 확인
    private static boolean isValidDistance(int x, int y) {
        if(x > 5 || x < -5 || y > 5 || y < -5) {
            return false;
        }
        return true;
    }
}