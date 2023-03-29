package main.programmers.learn.challenges;

public class FSearch_4 {
    private String[] answer;
    private String[][] tickets;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        boolean [] visited = new boolean[tickets.length];
        String[] route = new String[tickets.length + 1];
        for (int i = 0; i < route.length; i++) route[i] = "";

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                visited[i] = true;
                route[0] = "ICN";
                dfs(tickets[i], visited, route, 1);
                visited[i] = false;
            }
        }
        return answer;
    }

    public void dfs(String[] ticket, boolean[] visited, String[] route, int depth) {
        if (depth == this.tickets.length) {
            route[depth] = ticket[1];
            if (this.answer == null) this.answer = route.clone();
            if (isSmall(route)) this.answer = route.clone();
            return;
        }
        for (int i = 0; i < this.tickets.length; i++) {
            if (visited[i]) continue;
            String from = this.tickets[i][0];
            if (ticket[1].equals(from)) {
                visited[i] = true;
                if (!route[depth].equals(ticket[1]))
                    route[depth] = ticket[1];
                dfs(this.tickets[i], visited, route, depth + 1);
                visited[i] = false;
            }
        }
    }

    public boolean isSmall(String[] route) {
        for (int i = 0; i < route.length; i++) {
            char[] A = this.answer[i].toCharArray();
            char[] B = route[i].toCharArray();
            for (int j = 0; j < A.length; j++) {
                if (A[j] > B[j]) return true;
                else if (A[j] < B[j]) return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        FSearch_4 s = new FSearch_4();
        System.out.println(s.solution(tickets));
    }
}