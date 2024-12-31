import java.util.List;

public class MinHeap {
    private List<Integer> heap;
    
    public void insert(Integer number){
        insert(number, heap.size()-1);
    }

    private void insert(Integer number, int index){
        heap.add(number);
        if(number > heap.get(index/2)){
            heap.add(number);
        }
        swap(heap, index, parent(index));
    }

    private void swap(List<Integer> list, int index1, int index2){
        int temp = list.get(index1);
        list.set(list.get(index2), index1);
        list.set(temp, index2);
    }

    public boolean delete(int number){
        var index = findIndex(number, 0);
        if(index < 0){
            return false;
        }
        heap.set(index, Integer.MAX_VALUE);
        moveUp(number, index);
        return true;
    }

    private void moveUp(int number, int index){
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(left(index) < heap.size()){
            left = heap.get(left(index));
        }
        if(right(index) < heap.)
    }



    private Integer findIndex(int number, int index){
        if(heap.get(index)>number){
            return -1;
        }
        if(heap.get(index) == number){
            return number;
        }
        int left = -1;
        int right = -1;
        if(left(index) < heap.size())
            left = findIndex(number, left(index));
        if(right(index) < heap.size())    
            right = findIndex(number, right(index));
        return left > right ? left : right;
    }

    private int parent(int index){
        return (index-1)/2;
    }

    private int left(int index){
        return index*2 + 1;
    }

    private int right(int index){
        return index*2;
    }


}
