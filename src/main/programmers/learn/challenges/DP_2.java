package main.programmers.learn.challenges;

public class DP_2 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            dp[i][0] = triangle[i][0] + dp[i-1][0];     // 가장자리 = 원본값 + 이전 계산값
            for (int j = 1; j < i + 1; j++) {
                // dp[i][j] = triangle[i][j] + 상단의 좌 우 중 최대값
                int left = dp[i-1][j-1];
                int right = dp[i-1][j];
                dp[i][j] = (left > right) ? triangle[i][j] + left : triangle[i][j] + right;
            }
        }
        for (int val : dp[dp.length - 1]) answer = (val > answer) ? val : answer;
        return answer;
    }

    public static void main(String[] args) {
        DP_2 dp = new DP_2();
        System.out.println(dp.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}
