package programmers.learn.challenges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_1 {
    boolean[] visited;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public int solution(int n, int[][] edge) {
        this.visited = new boolean[n+1];
        for (int i = 0; i <= n; i++)
            graph.add(i, new ArrayList<>());
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        return bfs();
    }

    public int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        
        int cnt = 0;
        while (true) {
            ArrayList<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (Integer adjacent : graph.get(cur)) {
                    if (!visited[adjacent]) {
                        visited[adjacent] = true;
                        list.add(adjacent);
                    }
                }
            }
            if (list.size() == 0) break;
            cnt = list.size();
            queue.addAll(list);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Graph_1 g = new Graph_1();
        System.out.println(g.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}
