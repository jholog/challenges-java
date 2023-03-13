package programmers.learn.kakao;

public class Recruitment_2019_2 {
    public String solution(String p) {
        String answer = this.validation(p);
        System.out.println(answer);
        return answer;
    }

    public String validation(String w) {
        if (w == null || w.isEmpty()) return "";
        int idx = this.split(w);
        String u = w.substring(0, idx+1);
        String v = w.substring(idx+1);
        if (isRight(u))
            return u + validation(v);
        else {
            String result = "(" + validation(v) + ")";
            for (int i = 1; i < u.length()-1; i++) {
                 char c = u.charAt(i);
                 if (c == '(') result += ")";
                 else result += "(";
            }
            return result;
        }
    }

    public int split(String w) {
        int idx = -1;
        int cnt = 0;
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if (c == '(') cnt++;
            else cnt--;
            if (cnt == 0) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    public boolean isRight(String u) {
        int cnt = 0;
        for (int i = 0; i < u.length(); i++) {
            char c = u.charAt(i);
            if (c == '(') cnt++;
            else if (c == ')') cnt--;
            if (cnt < 0) return false;
        }
        if (cnt == 0) return true;
        else return false;
    }

    public static void main(String[] args) {
        String s = "()(())()";
//        s = "(()())()";
//        s = ")(";
        Recruitment_2019_2 r = new Recruitment_2019_2();
        r.solution(s);
    }
}
