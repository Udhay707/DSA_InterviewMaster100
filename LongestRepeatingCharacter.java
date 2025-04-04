import java.util.HashMap;
import java.util.Map;

class LongestRepeatingCharacter{
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        for(int i=0, j=0; j<s.length(); j++){
            while(freqMap.containsKey(s.charAt(j))){
                freqMap.remove(s.charAt(i));
                i++;
            }
            longest = Math.max(longest, j-i+1);
            freqMap.put(s.charAt(j), 1);
        }
        
        return longest;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        LongestRepeatingCharacter longestRepeatingCharacter = new LongestRepeatingCharacter();

        int k = longestRepeatingCharacter.lengthOfLongestSubstring(s);
        System.out.println(k);
    }
}