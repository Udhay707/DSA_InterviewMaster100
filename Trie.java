import java.util.HashMap;
import java.util.Map;

public class Trie {
    class TriNode {


        private Map<Character, TriNode> triNodeMap;

        private boolean isLast;

        public Map<Character, TriNode> getTriNodeMap(){
            return this.triNodeMap;
        }

        public boolean isLast(){
            return this.isLast;
        }

        public void setIsLast(boolean isLast){
            this.isLast = isLast;
        }

        public TriNode(){
            this.triNodeMap = new HashMap<>();
        }

    }
    private TriNode triNode;

    public Trie() {
        this.triNode = new TriNode();
    }
    
    public void insert(String word) {
        TriNode temp = this.triNode;
        char[] characters = word.toCharArray();
        for(int i=0; i<characters.length;i++){
            if(!temp.getTriNodeMap().containsKey(characters[i]))
                temp.getTriNodeMap().put(characters[i], new TriNode());
            if(i == characters.length-1)
                temp.setIsLast(true);  
            temp = temp.getTriNodeMap().get(characters[i]);
        }

    }
    
    public boolean search(String word) {
        var temp = triNode;
        char[] characters = word.toCharArray();
        for(int i=0; i<characters.length; i++){
            if(!temp.getTriNodeMap().containsKey(characters[i])){
                return false;
            }
            if(i==characters.length-1 && !temp.isLast()){
                 return false;
            }
            temp = temp.getTriNodeMap().get(characters[i]);
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        var temp = triNode;
        char[] characters = prefix.toCharArray();
        for(char character : characters){
            if(! temp.getTriNodeMap().containsKey(character)){
                return false;
            }
            temp = temp.getTriNodeMap().get(character);
        }
        return true;
    }
}
