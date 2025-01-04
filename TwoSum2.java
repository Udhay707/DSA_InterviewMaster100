import java.util.Arrays;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int sum = 0;
        for(int i=0, j=numbers.length-1; i<j;){
            sum = numbers[i] + numbers[j];
            if(sum == target)
                return new int[]{i+1,j+1};
            if(sum < target)
                i++;
            else
                j--;
        }
        return new int[]{-1,-1};     
    }
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        TwoSum2 twoSum2 = new TwoSum2();
        int []result = twoSum2.twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }
}
