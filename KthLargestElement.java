import java.util.PriorityQueue;
import java.util.Comparator;

public class KthLargestElement {
    
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(nums.length, Comparator.reverseOrder());
        for(int num : nums){
            minHeap.add(num);
        }

        for(int i=0; i<k-1; i++){
            minHeap.poll();
        }

        return minHeap.poll();
        
    }

}
