public class MaximumProductSubarray {
    /*
     * dont under estimate a problem
     */

    public int maxProduct(int[] nums) {
        int numOfNegativeNumber=0;
        int max = Integer.MIN_VALUE;
        int firstNegativeIndex = -1;
        int lastNegativeIndex = -1;
        for(int i=0; i< nums.length; i++){
            if(nums[i] < 0){
                numOfNegativeNumber++;
                firstNegativeIndex = firstNegativeIndex == -1 ? i : firstNegativeIndex;
                lastNegativeIndex = i;
            }
                
            if(nums[i]>max) 
                max = nums[i];   
        }
        if(numOfNegativeNumber%2 == 0){
            max = Math.max(max, findMaxProduct(0, nums.length-1, nums));
        }else{
            max = Math.max(max, findMaxProduct(0, firstNegativeIndex-1, nums));
            max = Math.max(max, findMaxProduct(firstNegativeIndex+1, nums.length-1, nums));
            max = Math.max(max, findMaxProduct(0, lastNegativeIndex-1, nums));
            max = Math.max(max, findMaxProduct(lastNegativeIndex+1, nums.length-1, nums));
        }
        return max;
    }

    private int findMaxProduct(int start, int end, int[]nums){
        int max = Integer.MIN_VALUE;
        int product = 1;
        for(int i=start; i<=end; i++){
            if(nums[i] == 0){
                product = 1;
                continue;
            }
            product= nums[i]*product;
            max = Math.max(product, max);
        }
        product = 1;
        for(int i=end; i>=start; i--){
            if(nums[i] == 0){
                product = 1;
                continue;
            }
            product= nums[i]*product;
            max = Math.max(product, max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int maxProduct = maximumProductSubarray.maxProduct(new int[]{0, -1});
        System.out.println(maxProduct);
    }
}
