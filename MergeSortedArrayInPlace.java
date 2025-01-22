import java.util.Arrays;

public class MergeSortedArrayInPlace {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0, j=0, pointer =m;
        while(j<n && i<nums1.length){
            if(nums1[i] > nums2[j]){
                push(nums1, i, pointer++);
                nums1[i++] = nums2[j++];
            }else{
                i++;
            }
        }
        while(j<n){
            nums1[pointer++] = nums2[j++]; 
        }

    }
    private void push(int []array, int index, int pointer){
        for(int i=pointer; i>index; i--){
            array[i] = array[i-1];
        }
    }
    public static void main(String[] args) {
        MergeSortedArrayInPlace mergeSortedArrayInPlace = new MergeSortedArrayInPlace();
        int[] nums1 = new int[]{4,0,0,0,0,0};
        mergeSortedArrayInPlace.merge(nums1, 1, new int[]{1,2,3,5,6}, 5);
        System.out.println(Arrays.toString(nums1));
    }
}
