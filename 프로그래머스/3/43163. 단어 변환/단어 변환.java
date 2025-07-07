import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // 최소 단계를 구해야 하므로 bfs 사용
        // Queue 생성, Queue 에 begin 입력
        
        // while 반복문 : Queue 가 존재할 경우 반복
            // Queue 출력
            // for words
            // 변환 가능 여부 조건문
            // words 중 변환할 수 있는 단어 = 한 알파벳만 다른 경우 (나머지 알파벳은 동일한 경우)
                // 단어 변환
        
        boolean[] visited = new boolean[words.length];
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin, 0));
        
        while(!queue.isEmpty()) {
            Word front = queue.poll();
            
            if (front.word.equals(target)) {
                return front.depth;
            }
            
            for (int i = 0; i < words.length; i++) {
                if(visited[i]) continue;
                
                int matchCharCount = 0;
                for (int j = 0; j < target.length(); j++) {
                    if (front.word.charAt(j) == words[i].charAt(j)) matchCharCount++;
                }
                
                if (matchCharCount == target.length() - 1) {
                    visited[i] = true;
                    queue.add(new Word(words[i], front.depth + 1));
                }
            }
        }
        
        return 0;
    }
    
    private static class Word {
        String word;
        int depth;
        
        Word (String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}