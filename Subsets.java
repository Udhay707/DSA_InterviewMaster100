import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        return backtrack(nums, new ArrayList<>(), 0);
        
    }

    private List<List<Integer>> backtrack(int nums[], List<Integer> selected, int selectedCount){
        List<List<Integer>> returnList = new ArrayList<>();
        if(selectedCount == nums.length){
            returnList.add(new ArrayList<>(selected));
            return returnList;
        }
        returnList.addAll(backtrack(nums, selected, selectedCount+1));
        selected.add(nums[selectedCount]);
        returnList.addAll(backtrack(nums, selected, selectedCount+1));
        if(selected.size()>0)
            selected.remove(selected.size()-1);
        return returnList;

    }

    public static void main(String[] args) {

        int []array = {0};
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(array));

    }
}
