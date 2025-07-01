class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder allNumber = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        // 0부터 해당 진수의 값을 모두 추가
        for (int i = 0; allNumber.length() < t * m; i++) {
            String string = Integer.toString(i, n);
            allNumber.append(string);
        }

        // 모든 값 중 튜브의 순서에 해당하는 값 추가
        for (int i = 0; answer.length() < t; i++) {
            if (i % m + 1 == p) {
                answer.append(allNumber.charAt(i));
            }
        }

        // 16진수의 a~f 값을 대문자로 치환
        return answer.toString().toUpperCase();
    }
}