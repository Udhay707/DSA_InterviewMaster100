import java.util.ArrayList;
import java.util.List;

class EncodeDecodeStrings {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str){
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < str.length();i++) {
            int digits = getDigits(i, str);
            int next = (digits+"").length();
            strs.add(str.substring(i+next+1, i+next+1+digits));
            i += digits + next;
        }
        return strs;
    }

    private int getDigits(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(i++));

        while(str.charAt(i) != '#'){
            sb.append(str.charAt(i++));
        }
        return Integer.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        EncodeDecodeStrings encodeDecodeStrings = new EncodeDecodeStrings();
        String encodedString = encodeDecodeStrings.encode(
            List.of("we","say",":","yes","!@#$%^&*()")
        );
        System.out.println(encodeDecodeStrings.decode(encodedString));
    }
}
