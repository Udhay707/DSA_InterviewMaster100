import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        int length = s.length();
        int operator = +1;
        int answer = 0;
        int currentNumber = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<length; i++){
            if(Character.isDigit(s.charAt(i))){
                currentNumber = s.charAt(i) - '0';
                while(i+1 < length && Character.isDigit(s.charAt(i+1))){
                    currentNumber = currentNumber*10 + s.charAt(++i) - '0';
                }
                currentNumber = currentNumber * operator;
                answer += currentNumber;
                currentNumber = 0;
            } else if(s.charAt(i) == '+'){
                operator = +1;
            } else if(s.charAt(i) == '-'){
                operator = -1;
            } else if(s.charAt(i) == '('){
                stack.push(answer);
                stack.push(operator);
                answer = 0;
                currentNumber = 0;
                operator = +1;
            } else if(s.charAt(i)== ')'){
                int prevSign = stack.pop();
                answer = prevSign * answer;
                int prevValue = stack.pop();
                answer = answer + prevValue;
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        BasicCalculator basicCalculator = new BasicCalculator();
        int result = basicCalculator.calculate(s);
        System.out.println(result);
    }

}
