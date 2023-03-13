package programmers.learn.challenges;

public class FSearch_1 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int target, int i, int sum) {
        if (i == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        dfs(numbers, target, i+1, sum + numbers[i]);
        dfs(numbers, target, i+1, sum - numbers[i]);
    }

    public static void main(String[] args) {
        FSearch_1 s = new FSearch_1();
//        System.out.println(s.solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(s.solution(new int[]{4, 1, 2, 1}, 4));
    }
}
