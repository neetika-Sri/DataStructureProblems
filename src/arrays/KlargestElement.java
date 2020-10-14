package arrays;

import java.util.PriorityQueue;

public class KlargestElement {
    public static void main(String[] args) {
        int h = kthLargetElement(new int[]{1, 4, 6, 2, 1, 4, 10},2);
        System.out.println(h);
    }
    public static int kthLargetElement(int[] arr, int k){
        if(arr == null || arr.length < k)
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : arr){
            if(pq.size() < k){
                pq.add(i);
            }
            if(pq.size() == k && pq.peek() < i){
                pq.remove();
                pq.add(i);
            }
        }
        return pq.poll();
    }

}
