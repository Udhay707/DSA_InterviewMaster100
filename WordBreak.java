import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict), 0, new int[301]);
         
    }
    //s.length is limited to 300
    private boolean wordBreak(String s, Set<String> wordDict, int start, int[]array){
        if (start == s.length()) {
            return true;
        }

        if (array[start] != 0) {
            return array[start] == 1;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i)) && wordBreak(s, wordDict, i, array)) {
                array[start] = 1;
                return true;
            }
        }

        array[start] = -1;
        return false;
    }

    public static void main(String[] args) {

        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        var wordList = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        WordBreak wordBreak = new WordBreak();
        boolean b= wordBreak.wordBreak(s, wordList);
        System.out.println(b);
        
    }
}
