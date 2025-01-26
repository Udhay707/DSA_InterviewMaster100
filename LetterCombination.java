import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {

    private Map<Character, List<String>> phoneNumberMap;

    public LetterCombination(){
        phoneNumberMap = new HashMap<>();
        phoneNumberMap.put('2', List.of("a", "b", "c"));
        phoneNumberMap.put('3', List.of("d", "e", "f"));
        phoneNumberMap.put('4', List.of("g", "h", "i"));
        phoneNumberMap.put('5', List.of("j", "k", "l"));
        phoneNumberMap.put('6', List.of("m", "n", "o"));
        phoneNumberMap.put('7', List.of("p", "q", "r", "s"));
        phoneNumberMap.put('8', List.of("t", "u", "v"));
        phoneNumberMap.put('9', List.of("w", "x", "y", "z"));

    }
    public List<String> letterCombinations(String digits) {
        if(digits.isBlank()){
            return new ArrayList<>();
        }
        return findCombination(digits, 0);
    }

    public List<String> findCombination(String digits, int position){
        if(position == digits.length()-1){
            return new ArrayList<>(phoneNumberMap.get(digits.charAt(position)));
        }
        List<String> nextPositionList = findCombination(digits, position+1);
        List<String> newList = new ArrayList<>();
        for(String letter : phoneNumberMap.get(digits.charAt(position))){
            for(String member : nextPositionList){
                newList.add(letter + member);
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        LetterCombination letterCombination = new LetterCombination();
        var list = letterCombination.letterCombinations("");
        System.out.println(list);
    }
}
