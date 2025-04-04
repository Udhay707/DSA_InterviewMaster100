import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class MaxSlidingWindow{

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ansList = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(0);
        for(int i=1; i<k; i++){
            while(!deque.isEmpty() && nums[deque.getLast()]<nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        ansList[0]=nums[deque.getFirst()];

        for(int left=1, right = k; right < nums.length; left++, right++){
            if(deque.getFirst() < left){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[right]){
                deque.removeLast();
            }
            deque.addLast(right);
            ansList[left] = nums[deque.getFirst()];
        }

        return ansList;
    }

    public static void main(String[] args) {

        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] ans = maxSlidingWindow.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(Arrays.toString(ans));
        
    }
    
}