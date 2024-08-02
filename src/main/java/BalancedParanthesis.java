import java.util.Stack;

public class BalancedParanthesis {
    boolean balanceParanthesis(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='{' ){
                stack.push('}');
            } else if (c =='[' ){
                stack.push(']');
            } else if (c == '('){
                stack.push(')');
            } else {
                if(!stack.isEmpty() && !stack.pop().equals(c)){
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        BalancedParanthesis testObj = new BalancedParanthesis();
        System.out.println(testObj.balanceParanthesis("{}[(])[]"));
    }
}
