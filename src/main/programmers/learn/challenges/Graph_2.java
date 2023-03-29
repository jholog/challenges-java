package main.programmers.learn.challenges;

import java.util.Arrays;

public class Graph_2 {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n][n];
        int inf = 10;

        for (int[] g : graph) {
            Arrays.fill(g, inf);
        }

        for (int[] r : results) {
            graph[r[0]-1][r[1]-1] = 1;
        }

        for (int k = 0; k < n; k++) {           // k = 경유 노드
            for (int i = 0; i < n; i++) {       // i = 출발 노드
                for (int j = 0; j < n; j++) {   // j = 도착 노드
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        System.out.println(graph[i][j] + " " +  graph[i][k] + " " + graph[k][j]);
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (graph[i][j] < inf || graph[j][i] < inf) cnt ++;
            }
            if (cnt == (n - 1)) answer++;   // 자신을 제외한 모든 선수 (n-1)명과 기록이 있으면 순위를 알 수 있다.
        }
        return answer;
    }

    public static void main(String[] args) {
        Graph_2 g = new Graph_2();
        System.out.println(g.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
}
