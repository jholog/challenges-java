package main.programmers.learn.challenges;

public class DP_3 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int[] p : puddles) dp[p[1]-1][p[0]-1] = -1;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i != 0) dp[i][j] += dp[i-1][j] % 1000000007;
                if (j != 0) dp[i][j] += dp[i][j-1] % 1000000007;
            }
        }
        return dp[n-1][m-1] % 1000000007;
    }

    public static void main(String[] args) {
        DP_3 dp = new DP_3();
        System.out.println(dp.solution(4, 3, new int[][]{{2, 2}}));
        System.out.println(dp.solution(4, 4, new int[][]{{3, 2}, {2, 4}}));
        System.out.println(dp.solution(7, 4, new int[][]{{2, 1}, {2, 2}, {2, 3}, {4, 2}, {4, 3}, {4, 4}, {6, 2}, {6, 3}}));
        System.out.println(dp.solution(100, 100, new int[][]{}));
    }
}
