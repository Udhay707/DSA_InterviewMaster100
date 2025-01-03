import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> memberFrequencyMap = Arrays.stream(nums)
        .boxed()
        .collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum));

        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>((a, b) -> -1*a[0].compareTo(b[0]));

        memberFrequencyMap.entrySet().stream()
        .map(entry -> {
            Integer[] frequencyElement = new Integer[2];
            frequencyElement[0] = entry.getValue();
            frequencyElement[1] = entry.getKey();
            return frequencyElement;
        }).forEach(priorityQueue::add);

        return IntStream.range(0, k)
        .map(num -> (int)priorityQueue.poll()[1])
        .toArray();
    }

    public static void main(String[] args) {
        int array[] = {1};
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        var k = topKFrequentElements.topKFrequent(array, 1);
        System.out.println(Arrays.toString(k));
    }
}
