package main.programmers.learn.challenges;

public class FSearch_3 {
    private String target;
    private int answer = 0;

    public int solution(String begin, String target, String[] words) {
        this.target = target;
        boolean [] visited = new boolean [words.length];
        dfs(begin, words, visited, 0);
        return answer;
    }

    public void dfs(String begin, String[] words, boolean[] visited, int depth) {
        if (begin.equals(this.target)) {
            if (answer == 0 || answer > depth) answer = depth;
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            if (diff(begin, words[i]) == 1) {
                visited[i] = true;
                dfs(words[i], words, visited, depth + 1);
                visited[i] = false;
            }
        }
    }

    public int diff(String a, String b) {
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) cnt ++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        FSearch_3 s = new FSearch_3();
//        System.out.println(s.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(s.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
}
