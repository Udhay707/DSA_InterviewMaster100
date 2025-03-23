import java.util.Stack;

class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int maxArea = 0;
        for(int i=1; i<heights.length; i++){
            int removed = i;
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){ //it can't be extended further

                removed = stack.pop();
                maxArea = Math.max(heights[removed]* (i - removed), maxArea);
            }
            stack.add(removed);   
        }
        return maxArea;
            
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        int sol = new LargestRectangleInHistogram().largestRectangleArea(heights);
        System.out.println(sol);

    }
}