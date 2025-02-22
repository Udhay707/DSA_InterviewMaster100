import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> returnList = new ArrayList<>();
        combinationSum(candidates, target, new ArrayList<>(), returnList, 0);
        return returnList;
    }

    public void combinationSum(int []candidates, int remaining, List<Integer> currentList, List<List<Integer>> result, int start){
        if(remaining == 0){
            result.add(new ArrayList<>(currentList));
            return;
        }
        if (remaining < 0){
            return;
        }
        for(int i=start; i<candidates.length;i++){
            currentList.add(candidates[i]);
            combinationSum(candidates, remaining - candidates[i], currentList, result, i);
            currentList.remove(currentList.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] candidates = {2,3,6, 7};
        CombinationSum combinationSum = new CombinationSum();
        var result = combinationSum.combinationSum(candidates, 7);
        System.out.println(result);
    }
}
