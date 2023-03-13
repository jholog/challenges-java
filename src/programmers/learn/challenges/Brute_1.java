package programmers.learn.challenges;

import java.util.ArrayList;

public class Brute_1 {
    private int[][] s = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public int[] solution(int[] answers) {
        int[] scores = new int[s.length];
        // scoring
        for (int i = 0; i < s.length; i++) {
            int j = 0;
            for (int a : answers) {
                if (s[i][j] == a)
                    scores[i]++;
                j++;
                if (j == s[i].length) j = 0;  // 모두 순회 했으므로 초기화
            }
        }
        // get max val
        int max = -1;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max)
                max = scores[i];
        }
        // select person
        ArrayList<Integer> person = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max)
                person.add(i+1);
        }
        int[] answer = person.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public static void main(String[] args) {
//        int[] answer = {1, 2, 3, 4, 5};
//        int[] answer = {1, 3, 2, 4, 2};
        int[] answer = {3, 3, 2, 1, 5};
        Brute_1 b = new Brute_1();
        System.out.println(b.solution(answer));
    }
}
