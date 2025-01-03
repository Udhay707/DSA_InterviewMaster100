import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {

        Integer[] input = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        return backtrack(input, 0);
        
    }

    private List<List<Integer>> backtrack(Integer[] array,int fixed){
        List<List<Integer>> returnList = new ArrayList<>();

        if(array.length == fixed){
            returnList.add(List.of(array));
            return returnList;
        }

        //swap position of non fixed member with others on a loop
        //find the permutation and reverse it
        for(int i=fixed+1; i<array.length; i++){
            swap(array, fixed, i); //useless on the first time, but just to make the code look simple
            returnList.addAll(backtrack(array, fixed+1));
            swap(array, fixed, i);
        }
        return returnList;
        
    }  
    
    private void swap(Integer[] input, int pos1, int pos2){
        int temp = input[pos1];
        input[pos1] = input[pos2];
        input[pos2] = temp;

    }
                
    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        var k = permutation.permute(new int[]{1,2,3});
        System.out.println(k);
    }
}
