import java.util.Arrays;
import java.util.stream.IntStream;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length()){
            return false;
        }
        int[] s1FreqMap = new int[26];
        int[] s2FreqMap = new int[26];

        IntStream.range(0, s1.length())
            .forEach(index -> {
                s1FreqMap[s1.charAt(index) - 'a']++;
                s2FreqMap[s2.charAt(index) - 'a']++;
            });
        
        if(Arrays.equals(s1FreqMap, s2FreqMap)){
            return true;
        }

        for(int i=0, j=s1.length(); j<s2.length(); j++,i++){
            s2FreqMap[s2.charAt(i)-'a']--;            
            s2FreqMap[s2.charAt(j)-'a']++;

            if(Arrays.equals(s1FreqMap, s2FreqMap)){
                return true;
            }
        }

        return false;
        
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";

        PermutationInString permutationInString = new PermutationInString();
        boolean s = permutationInString.checkInclusion(s1, s2);
        System.out.println(s);
    }
}
