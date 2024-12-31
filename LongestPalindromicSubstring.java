public class LongestPalindromicSubstring {
    private int length;
    private String longestString;
    public String longestPalindrome(String s) {
        for(int i=0; i<s.length();i++){
            isPalindrome(s, i, i);
            isPalindrome(s, i, i+1);
        }
        return longestString;
        
    }
    private void isPalindrome(String s, int start, int end){
        while((start >= 0 && end<s.length()) && (s.charAt(start) == s.charAt(end))){
            if(end-start+1 > length){
                length = end-start+1;
                longestString = s.substring(start, end+1);
            }
            start--; end++;
        }
    }
}
