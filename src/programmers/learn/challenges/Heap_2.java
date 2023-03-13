package programmers.learn.challenges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap_2 {
    // Job Scheduling, Shortest Job First or Greedy
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
//        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        return schedule(jobs);
    }

    public int schedule(int[][] jobs) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        heap.offer(jobs[0]);    // 처음 도착한 작업은 무조건 시작
        int cur = jobs[0][0];   // 현재 시점 갱신
        int sum = 0;
        int idx = 1;

        while (!heap.isEmpty()) {
            int[] job = heap.poll();// 작업 수행 완료
            cur += job[1];          // 현재 시점 갱신 = 작업 종료 시점
            sum += cur - job[0];    // sum += 현재 job의 대기~실행 시간
            // 작업 완료 시점에 쌓인 작업을 모두 등록
            while (idx < jobs.length && jobs[idx][0] <= cur) {
                heap.offer(jobs[idx++]);
            }

            if (heap.isEmpty() && idx < jobs.length) {
                cur = jobs[idx][0];     // 현재 시점 갱신
                heap.offer(jobs[idx++]);
            }
        }
        return sum / jobs.length;
    }

    public static void main(String[] args) {
        Heap_2 h = new Heap_2();
        System.out.println(h.solution(new int[][]{{1, 9}, {0, 3}, {0, 2}, {0, 4}, {2, 6}}));
    }
}
