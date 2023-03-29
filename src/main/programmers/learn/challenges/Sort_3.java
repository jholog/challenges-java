package main.programmers.learn.challenges;

import java.util.Arrays;

public class Sort_3 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int h = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (h <= citations[i]) {
                answer = h;
                break;
            } else
                h--;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
//        int[] citations = {10, 10, 10, 10, 10};
        Sort_3 s = new Sort_3();
        System.out.println(s.solution(citations));
    }
}
