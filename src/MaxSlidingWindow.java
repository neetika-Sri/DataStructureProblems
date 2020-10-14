import java.util.*;

public class MaxSlidingWindow {
    public static void main(String[] args) {

        maxSliding(Arrays.asList(1,2,4,5,5,5,3,1,1,1,2,9,0,0,0),3).stream().forEach(System.out::println);
    }
    public static List<Integer> maxSliding(List<Integer> inp,int k){
        // 1,2,4,5,3,1,2,9
        int i =0;
        k = Math.min(inp.size(), k);
        Deque<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        while(i < k ){
            while(!queue.isEmpty() && inp.get(i) >= inp.get(queue.getLast())){
                queue.removeLast();
            }
            queue.addLast(i);
            i++;
        }
        ans.add(inp.get(queue.peekFirst()));
        while(i < inp.size()){
            // remove indexes from queue not in window
            while(!queue.isEmpty() && queue.peekFirst() <= (i - k)){
                queue.removeFirst();
            }
            while(!queue.isEmpty() && inp.get(i) >= inp.get(queue.getLast())){
                queue.removeLast();
            }
            queue.addLast(i);
            ans.add(inp.get(queue.peekFirst()));
            i++;
        }
        return ans;
    }
}
