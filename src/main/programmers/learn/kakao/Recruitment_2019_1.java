package main.programmers.learn.kakao;

public class Recruitment_2019_1 {
    public int solution(String s) {
        int answer = 0;

        // Constraint check
        if (s.length() > 1000 || s.length() < 1)  return answer;
        if (s.length() == 1) return 1;
        s = s.toLowerCase();

        for (int i = 1; i <= s.length()/2; i++) {
            int min = compress(s, i);
            if (answer == 0)
                answer = min;
            else if (answer > min)
                answer = min;

        }
        return answer;
    }

    public int compress(String s, int ngram) {
        String newStr = "";
        for (int i = 0; i < (s.length() - ngram) ; i+=ngram) {
            newStr += s.substring(i, i+ngram);
            if (i < s.length()-1) newStr += ",";
        }
        int n = s.length() % ngram;
        if (n != 0)
            newStr += s.substring(s.length() - n);
        else
            newStr += s.substring(s.length() - ngram);

        String[] arr = newStr.split(",");
        String pre = "";
        int cnt = 0;
        newStr = "";
        for (int i = 0; i < arr.length; i++) {
            if (pre.length() == 0) {
                pre = arr[i];
                continue;
            }

            if (pre.equals(arr[i]))
                cnt++;
            else {
                if (cnt != 0) {
                    newStr += String.valueOf(cnt + 1) + pre;
                    cnt = 0;
                }
                else
                    newStr += pre;
                pre = arr[i];
            }
        }
        if (cnt != 0) newStr += String.valueOf(cnt + 1) + pre;
        else  newStr += pre;

        return newStr.length();
    }

    public static void main(String[] args) {
        String s = "a";

        Recruitment_2019_1 r = new Recruitment_2019_1();
        System.out.println(r.solution(s));
    }
}
