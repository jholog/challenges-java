package main.programmers.learn.challenges;

import java.util.Arrays;

public class Binary_1 {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long low = 0;
        long high = (long) times[times.length - 1] * n;

        while (low <= high) {
            long mid = (low + high) / 2;
            long cnt = 0;
            for (int time : times) cnt += mid / time;

            if (cnt < n)
                low = mid + 1;
            else {  // cnt >= n
                high = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
    
    public int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] < key)
                low = mid + 1;
            else if (arr[mid] > key)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public int binarySearchR(int[] arr, int key, int low, int high) {
        int mid;

        if (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] < key)
                return binarySearchR(arr, key, mid + 1, high);
            else if (arr[mid] > key)
                return binarySearchR(arr, key, low, mid - 1);
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        Binary_1 b = new Binary_1();
        System.out.println(b.solution(6, times));
        System.out.println(b.binarySearch(new int[]{1,2,3,4,5,6}, 1));
        System.out.println(b.binarySearchR(new int[]{1,2,3,4,5,6}, 3, 0, 5));
    }
}
