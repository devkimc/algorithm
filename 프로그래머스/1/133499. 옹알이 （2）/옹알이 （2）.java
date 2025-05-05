class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String b: babbling) {
            if(b.contains("ayaaya") || b.contains("yeye") || b.contains("woowoo") || b.contains("mama")) continue;
                
            String target = b;
            while(target.contains("aya") || target.contains("ye") || target.contains("woo") || target.contains("ma")) {
                target = target.replace("aya", " ");
                target = target.replace("ye", " ");
                target = target.replace("woo", " ");
                target = target.replace("ma", " ");
            }
            
            if(target.trim().length() == 0) answer++;
        }
        
        return answer;
    }
}