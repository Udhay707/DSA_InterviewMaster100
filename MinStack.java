import java.util.ArrayList;
import java.util.List;

public class MinStack {
    private List<Integer> stack;
    private List<Integer> minStack;
    
    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        if(minStack.size()==0){
            minStack.add(val);
            return;
        }

        int min = minStack.get(minStack.size()-1);
        minStack.add(val>min ? min : val);
    }
    
    
    public void pop() {
        int length = stack.size()-1;
        if(length >= 0){
            stack.remove(length);
            minStack.remove(length);
        }    
    }
    
    public int top() {
        if(stack.size() != 0)
            return stack.getLast();
        return 0;    
    }
    
    public int getMin() {
        if(minStack.size() > 0)
            return minStack.get(minStack.size()-1);
        return 0;    
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
