import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int maxRepeating = 0;

        int res = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        for(int i=0, j=0; j<s.length(); j++){
            int freq = freqMap.getOrDefault(s.charAt(j), 0);
            freqMap.put(s.charAt(j), freq+1);
            maxRepeating = Math.max(maxRepeating, freq+1);
            while(i<j && (j - i + 1) > maxRepeating + k){
                freqMap.compute(s.charAt(i), (key,v) -> v-1);
                i++;
            }
            res = Math.max(res, j-i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        int res = new LongestRepeatingCharacterReplacement().characterReplacement(s, k);
        System.out.println(res);
    }
    
}
