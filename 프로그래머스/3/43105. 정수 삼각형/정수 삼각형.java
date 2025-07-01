import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int[][] maxArray = new int[triangle.length][triangle.length];

        // 층 Loop (top -> bottom)
        for (int i = 0; i < triangle.length; i++) {
            // 각 층의 숫자 Loop (left -> right)
            for (int j = 0; j < triangle[i].length; j++) {

                // 해당 층의 첫번째의 경우, 이전 층의 첫번째 최댓값과 합산
                if (j == 0) {
                    // 꼭대기 층은 해당 층의 값을 최댓값으로 설정
                    if (i == 0) {
                        maxArray[i][j] = triangle[i][j];
                    } else {
                        maxArray[i][j] = maxArray[i-1][0] + triangle[i][j];
                    }
                }
                // 해당 층의 마지막의 경우, 이전 층의 마지막 최댓값과 합산
                else if (j == triangle.length - 1){
                    maxArray[i][j] = maxArray[i-1][maxArray[i-1].length-1] + triangle[i][j];
                }
                // 그 외인 경우 이전 층의 j-1, j 번째 값 중 큰값을 최댓값으로 계산하여 합산
                else {
                    maxArray[i][j] = Math.max(maxArray[i-1][j-1], maxArray[i-1][j]) + triangle[i][j];
                }
            }
        }
        // 마지막 층의 합산 최댓값 중 가장 큰 값을 반환
        return Arrays.stream(maxArray[maxArray.length-1]).max().getAsInt();
    }
}