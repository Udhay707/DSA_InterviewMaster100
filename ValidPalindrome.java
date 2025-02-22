class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();

        int pointer1 = 0;
        int pointer2 = s.length()-1;
        while(pointer1 < pointer2){
            if(s.charAt(pointer1++) != s.charAt(pointer2--)){
                return false;
            }
        }
        return true;
    }
}

public class ValidPalindrome{
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(solution.isPalindrome(s));
    }
}