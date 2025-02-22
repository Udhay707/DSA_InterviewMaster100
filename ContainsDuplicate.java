import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        boolean containsDuplicate = ContainsDuplicate.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2});
        System.out.println(containsDuplicate);
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(!set.add(nums[i]))
            return true;
        }
        return false;    
    } 
}
