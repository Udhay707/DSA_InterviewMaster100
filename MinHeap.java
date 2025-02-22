import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<Integer> heap;
    
    public MinHeap(){
        heap = new ArrayList<>();
    }
    
    private int parent(int index){
        return (index-1) /2;
    }

    private int leftChild(int index){
        int left = index*2 + 1;
        if(left < heap.size()){
            return left;
        }
        return -1;
    }

    private int rightChild(int index){
        int right = index*2 + 2;
        if(right < heap.size()){
            return right;
        }
        return -1;
    }

    public void insert(int number){
        heap.add(number);
        checkAndSwap(heap.size()-1);
    }

    private void checkAndSwap(int index){
        int parentIndex = parent(index);
        while(parentIndex >=0 && heap.get(index) < heap.get(parentIndex)){
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = parent(index);
        }
    }

    private void swap(int index1, int index2){
        int num = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, num);
    }

    public void remove(int index){
        swap(index, heap.size()-1);
        heap.remove(heap.size()-1);

        while((leftChild(index)!= -1 && heap.get(index) > heap.get(leftChild(index))) || 
            (rightChild(index)!=-1 && heap.get(index) > heap.get(rightChild(index)))){
            int smallerIndex = rightChild(index) != - 1 && heap.get(leftChild(index)) < heap.get(rightChild(index)) 
                                            ? leftChild(index) : rightChild(index);
            swap(index, smallerIndex);
            index = smallerIndex;
        }
    }

    public String toString(){
        return heap.toString();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(10);
        minHeap.insert(7);
        minHeap.insert(9);
        System.out.println(minHeap);
        minHeap.insert(5);
        System.out.println(minHeap);
        minHeap.remove(2);
        System.out.println(minHeap);
    }

}
