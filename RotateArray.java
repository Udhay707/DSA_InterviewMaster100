import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            nums[start] = nums[start] + nums[end];
            nums[end] = nums[start] - nums[end];
            nums[start] = nums[start] - nums[end];
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        var array = new int[]{1,2,3,4,5,6,7};
        rotateArray.rotate(array, 3);
        System.out.println(Arrays.toString(array));
    }
}
