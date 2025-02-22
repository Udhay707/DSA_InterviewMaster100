import java.util.Arrays;

class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int numOfZeroes = 0;
        int totalProduct = 1;
        for (int i=0 ; i< nums.length; i++){
            if (nums[i]==0){
                numOfZeroes++;
                continue;
            }
            totalProduct *= nums[i];
        }
        int []result = new int[nums.length];

        if(numOfZeroes > 1){
            for(int i=0 ; i< result.length; i++){
                result[i] = 0;
            }
            return result;
        }

        if(numOfZeroes == 1){
            for(int i=0 ; i< result.length; i++){
                if(nums[i]==0){
                    result[i] = totalProduct;
                    continue;
                }
                result[i] = 0;
            } 
            return result;
        }
        
        for(int i=0 ; i< result.length; i++){
            result[i] = totalProduct / nums[i];
        }

        return result;
        
        
    }
    public static void main(String[] args) {
        int []nums = {1,2,3,4};

        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(nums)));
        
    }
}