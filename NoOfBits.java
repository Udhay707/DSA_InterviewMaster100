public class NoOfBits {

    public static void main(String[] args) {
        int noOf1 = hammingWeight(128);
        System.out.println(noOf1);
    }

    public static int hammingWeight(int n) {
        int numOf1 = 0;
        while(n != 0){
            n = n & n-1;
            numOf1++;
        }
        return numOf1;
    }
}