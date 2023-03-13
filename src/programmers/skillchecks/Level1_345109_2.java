package programmers.skillchecks;

public class Level1_345109_2 {
    public String solution(int a, int b) {
        String answer = "";

        String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int[] month_val = {31,28,31,30,31,30,31,31,30,31,30,31 };
        int year = 2016;

        // check leap year
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            month_val[1] = 29;

        int total = 0;

        for (int i = 0; i < (a - 1); i++)
            total += month_val[i];
        total += b - 1;     // day string array 의 index 값에 접근하기 위해 -1

        int answer_val = (5 + total) % 7;
        answer = day[answer_val];

        return answer;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 24;

        Level1_345109_2 l = new Level1_345109_2();
        System.out.println(l.solution(a, b));
    }
}
