package main.programmers.learn.challenges;

import java.util.LinkedList;

public class FSearch_2 {
    class Graph {
        Node[] nodes;

        public Graph(int size) {
            this.nodes = new Node[size];
            for (int i = 0; i < size; i++) {
                nodes[i] = new Node(i);
            }
        }

        public void addEdge(int i, int j) {
            Node n1 = nodes[i];
            Node n2 = nodes[j];
            if (!n1.adjacent.contains(n2)) n1.adjacent.add(n2);
            if (!n2.adjacent.contains(n1)) n2.adjacent.add(n1);
        }

    }

    class Node {
        int data;
        boolean marked;
        LinkedList<Node> adjacent;

        public Node(int data) {
            this.data = data;
            this.marked = false;
            this.adjacent = new LinkedList<Node>();
        }
    }

    public void dfs(Node r) {
        if (r == null) return;
        r.marked = true;
        for (Node n  : r.adjacent) {
            if (!n.marked)
                dfs(n);
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        Graph g = new Graph(n);

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) g.addEdge(i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            Node r = g.nodes[i];
            if (!r.marked) {
                dfs(r);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        FSearch_2 s = new FSearch_2();
        System.out.println(s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
//        System.out.println(s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
        
    }
}
