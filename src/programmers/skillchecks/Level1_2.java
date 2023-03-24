package programmers.skillchecks;

public class Level1_2 {
    public String solution(int a, int b) {
        String answer = "";

        // 2016년 1월 1일은 금요일
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] month_val = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = 2016;

        // check leap year
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            month_val[1] = 29;

        int total = 0;
        for (int i = 0; i < (a - 1); i++)
            total += month_val[i];
        total = (total + b) % 7;

        answer = day[total - 1];
        return answer;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 24;

        Level1_2 l = new Level1_2();
        System.out.println(l.solution(a, b));
    }
}
