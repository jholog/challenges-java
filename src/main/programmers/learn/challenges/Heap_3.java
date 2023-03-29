package main.programmers.learn.challenges;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap_3 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (String op : operations) {
            int val = Integer.parseInt(op.split(" ")[1]);
            if (op.contains("I")) {
                minHeap.offer(val);
                maxHeap.offer(val);
                continue;
            }
            if (val > 0)
                minHeap.remove(maxHeap.poll());
            else if (val < 0)
                maxHeap.remove(minHeap.poll());
        }
        if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        Heap_3 h = new Heap_3();
//        h.solution(new String[]{"I 16","D 1"});
        h.solution(new String[]{"I 7","I 5","I -5","D -1"});
    }
}
