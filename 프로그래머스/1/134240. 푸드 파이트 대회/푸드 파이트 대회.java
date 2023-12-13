class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i = 1; i < food.length; i++) {
            int foodCount = food[i] / 2;
            answer += Integer.toString(i).repeat(foodCount);
        }
        
        String reverse = "";
        for(int i = answer.length() - 1; i >= 0; i--) {
            reverse += answer.charAt(i);
        }
        
        return answer + "0" + reverse;
    }
}