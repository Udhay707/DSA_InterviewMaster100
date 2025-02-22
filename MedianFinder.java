import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
     private Queue<Integer> minQueue;

     private Queue<Integer> maxQueue;

     private boolean isEven = true;

     public MedianFinder(){
        maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        minQueue = new PriorityQueue<>();
     }

     public void addNum(int num) {
        maxQueue.add(num);
        if(minQueue.size() < maxQueue.size()-1){
            int maxNumber = maxQueue.poll();
            minQueue.add(maxNumber);
        }

        if(!minQueue.isEmpty() && maxQueue.element() > minQueue.element()){
            int removed = maxQueue.poll();
            maxQueue.add(minQueue.poll());
            minQueue.add(removed);
        }
        isEven = !isEven;
    }

    public double findMedian() {
        if(isEven){
            return (minQueue.element() + maxQueue.element()) / 2.0;
        }

        return maxQueue.element();
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
