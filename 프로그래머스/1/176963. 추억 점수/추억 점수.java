import java.util.Arrays;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        for(int i = 0; i < photo.length; i++) {
            int score = 0;
            
            for(int j = 0; j < photo[i].length; j++) {
                int yearningIndex = Arrays.asList(name).indexOf(photo[i][j]);
                
                if(yearningIndex != -1) {
                    score += yearning[yearningIndex];
                }
            }
            
            answer[i] = score;
        }
        
        return answer;
    }
}