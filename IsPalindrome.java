public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int totalDigits = (int) Math.log10(x) + 1;
        int newNum = 0;
        int temp = x;
        for(int i =totalDigits; i>0; i--){
            newNum *= 10;
            newNum += temp%10;
            temp = temp/10;
        }
        return x==newNum;
        
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(121));
    }
}
