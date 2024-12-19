public class MaxSubarray {

    public static void main(String[] args) {
        int nums[] = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentSum = nums[0];
        int startIndex = 0;
        int withoutStartIndex;

        for(int i=1; i<nums.length; i++){
            currentSum += nums[i];
            if(nums[i] > currentSum){
                currentSum = nums[i];
                startIndex = i;
            } else {
                withoutStartIndex = currentSum - nums[startIndex];
                if(withoutStartIndex > currentSum){
                    currentSum = withoutStartIndex;
                    startIndex += 1;
                }
            }
            if(max < currentSum){
                max = currentSum;
            }
        }



        return max;
    }
}