import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), 0, returnList);
        return returnList;
        
    }

    private void backtrack(int nums[], List<Integer> selected, int selectedCount, List<List<Integer>> returnList){
        if(selectedCount == nums.length){
            returnList.add(new ArrayList<>(selected));
            return;
        }
        backtrack(nums, selected, selectedCount+1, returnList);
        selected.add(nums[selectedCount]);
        backtrack(nums, selected, selectedCount+1, returnList);
        selected.remove(selected.size()-1);
    }

    public static void main(String[] args) {

        int []array = {0};
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(array));

    }
}
