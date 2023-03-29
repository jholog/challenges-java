package main.programmers.learn.challenges;

public class DP_4 {
    public int solution(int[] money) {
        int[][] dp = new int[2][money.length];  // 처음 집을 터는 경우, 아닌 경우
        dp[0][0] = money[0];    // 처음 집을 털면
        dp[0][1] = money[0];    // 마지막 집은 패스
        dp[1][0] = 0;           // 처음 집을 안 털면
        dp[1][1] = money[1];    // 두 번째 집 부터

        for (int i = 2; i < money.length; i++) {
            dp[0][i] = Math.max(money[i]+dp[0][i-2], dp[0][i-1]);   // 현재 집 금액 + 전전 까지 누적 금액 vs. 이전 까지 누적 금액
            dp[1][i] = Math.max(money[i]+dp[1][i-2], dp[1][i-1]);
        }
        // 마지막 집은 못 털었으니 그 전 집까지 누적 금액, 처음 집을 안 털었으니 마지막 집 까지의 누적 금액
        return Math.max(dp[0][money.length-2], dp[1][money.length-1]);
    }

    public static void main(String[] args) {
        DP_4 dp = new DP_4();
        System.out.println(dp.solution(new int[]{1, 2, 3, 1}));
    }
}
