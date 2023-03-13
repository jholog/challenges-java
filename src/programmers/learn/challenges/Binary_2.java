package programmers.learn.challenges;

import java.util.Arrays;

public class Binary_2 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        while (left <= right) {
            int mid = (left + right) / 2;
            int remove = 0;
            int pre = 0;
            // 바위 제거
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - pre < mid) remove++;
                else pre = rocks[i];
            }
            if (distance - pre < mid) remove++;
            // 확인
            if (remove <= n) {
                left = mid + 1;
                answer = (answer >= mid) ? answer : mid;
            }
            else
                right = mid - 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Binary_2 b = new Binary_2();
//        System.out.println(b.solution(25, new int[]{2, 14, 11, 21, 17}, 2));
//        System.out.println(b.solution(18, new int[]{2, 8, 9, 10, 11, 12, 13}, 6));
        System.out.println(b.solution(42, new int[]{0, 20, 30, 40, 41}, 1));
    }
}
