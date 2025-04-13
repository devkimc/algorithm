class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int nextCard1 = 0;
        int nextCard2 = 0;
        
        for (int i = 0; i < goal.length; i++) {
            if(nextCard1 < cards1.length && goal[i].equals(cards1[nextCard1])) {
                nextCard1++;
                continue;
            }
            
            if(nextCard2 < cards2.length && goal[i].equals(cards2[nextCard2])) {
                nextCard2++;
                continue;
            }
            
            return "No";
        }
        
        return "Yes";
    }
}

