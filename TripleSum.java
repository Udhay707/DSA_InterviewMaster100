import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripleSum {
    public static void main(String[] args) {
        TripleSum tripleSum = new TripleSum();
        var triplets = tripleSum.threeSum(new int[]{-2,0,0,2,2});
        System.out.println(triplets);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        Arrays.sort(nums);
        int pointer =0;
        for(int i=0; i<nums.length-1; i++){
            if(i>0 && nums[i] == nums[i-1]) //avoid duplicates
                continue;
            for(int low=i+1, high=nums.length-1; low<high;){
                if (nums[i]+nums[low]+nums[high] == 0){
                    var newList = List.of(nums[i],nums[low],nums[high]);
                    if(pointer > 0 && returnList.get(pointer-1).equals(newList)){
                        low ++;
                        high --;
                    }
                    else{
                        returnList.add(newList);
                        pointer++;
                        low ++;
                        high--;
                    }
                    
                } else if(nums[i]+nums[low]+nums[high] > 0)
                    high--;
                else
                    low++;    
            }
        }
        return returnList;
    }
    
}
