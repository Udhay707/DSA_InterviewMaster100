public class BitWiseAnd {
    public int rangeBitwiseAnd(int left, int right) {
        int i=0;
        while(left != right){
            left = left >> 1;
            right = right >> 1;
            i++;
        }
        return left << i;
    }

    /*
     * right shift, shifts the bit to right which means remove the least significant bit
     * left sift, adds 0 in the places of least significant bit
     * 
     * checkout neet code last 5 mins video
     */

    public static void main(String[] args) {
        BitWiseAnd bitWiseAnd = new BitWiseAnd();
        System.out.println(bitWiseAnd.rangeBitwiseAnd(8, 9));
    }
}

