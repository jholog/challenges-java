package programmers.learn.challenges;

import java.util.Arrays;
import java.util.Comparator;

public class Sort_2 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            arr[i] = String.valueOf(numbers[i]);

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        for (String s : arr) answer += s;
        if (answer.charAt(0) == '0') return "0";
        return answer;
    }

    public static void main(String[] args) {
//        int[] numbers = {6, 10, 2};
//        int[] numbers = {3, 30, 34, 5, 9};
//        int[] numbers = {30, 34, 5, 9, 3, 1000, 0};
        int[] numbers = {0, 0, 0, 0};
        Sort_2 s = new Sort_2();
        System.out.println(s.solution(numbers));
    }
}
