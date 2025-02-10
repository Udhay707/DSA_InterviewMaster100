public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=nums.length-1; i<=j;){
            if(nums[j] == val){
                j--;
                continue;
            }
            if(nums[i]==val){
                nums[i] = nums[j] + nums[i];
                nums[j] = nums[i] - nums[j];
                nums[i] = nums[i] - nums[j];
                j--;
                i++;
            }
            else if(nums[i] != val)
                i++;
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int num = removeElement.removeElement(new int[]{3,2, 2, 3}, 2);
        System.out.println(num);
    }
}
