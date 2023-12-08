class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        System.out.println(s.lastIndexOf("n"));
        for(int i = 0; i < s.length(); i++) {
            int nearIndex = s.substring(0, i).lastIndexOf(s.charAt(i));
            
            if(nearIndex == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - nearIndex;
            }
        }
        
        return answer;
    }
}