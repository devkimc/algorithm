class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        // 가로 세로 중 하나라도 지갑의 길이보다 클 경우 루프를 돌린다.
        while(bill[0] > wallet[0] || bill[1] > wallet[1]) {
            
            // 90도 회전했을 때는 지갑에 들어가는 경우, 루프를 종료한다.
            if (bill[0] <= wallet[1] && bill[1] <= wallet[0]) {
                break;
            }
            
            // 가로 세로 중 길이가 긴 곳의 길이를 반으로 줄인다.
            if(bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            // 접은 횟수를 증가시킨다.
            answer++;
        }
        return answer;
    }
}