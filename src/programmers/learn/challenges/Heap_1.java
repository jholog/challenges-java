package programmers.learn.challenges;

import java.util.PriorityQueue;

public class Heap_1 {
    // 배열 중 값이 가장 낮은 두 개의 원소를 조건 a+(b*2)에 맞춰 계산해 모든 배열 값이 k 이상이 되도록 만드는 횟수를 return 하는 문제
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int val : scoville) heap.offer(val);    // .add(val) 성공 시 true, 실패 시 IllegalStateException

        while (heap.peek() <= K) {
            if (heap.size() == 1) return -1;
            int a = heap.poll();
            int b = heap.poll();

            int val = a + (b * 2);
            heap.offer(val);
            answer++;
        }
        return answer;
    }

//    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();  (낮은 숫자 우선)
//    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
//    PriorityQueue<String> priorityQueue = new PriorityQueue<>(); (낮은 숫자 우선)
//    PriorityQueue<String> priorityQueue = new PriorityQueue<>(Collections.reverseOrder())
//    priorityQueue.peak();       // priorityQueue에 첫번째 값을 반환, 비어있다면 null
//    priorityQueue.poll();       // priorityQueue에 첫번째 값을 반환하고 제거 비어있다면 null
//    priorityQueue.remove();     // priorityQueue에 첫번째 값 제거
//    priorityQueue.clear();      // priorityQueue에 초기화
    public static void main(String[] args) {
        Heap_1 h = new Heap_1();
        System.out.println(h.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
