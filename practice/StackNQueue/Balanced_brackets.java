package practice;

import java.util.Stack;

public class Balanced_brackets {
    public Stack<String> stack = new Stack<String>();
    public String[] brackets;

    public boolean isBalanced(String s) {
        brackets = s.split("");
        for (String bracket : brackets) {
            if (bracket.equals("(") || bracket.equals("{") || bracket.equals("[")) {
                stack.push(bracket);
            } else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    String top = stack.pop();
                    if(bracket.equals(")") && !top.equals("(")|| bracket.equals("}")&& !top.equals("{")|| bracket.equals("]")&& !top.equals("[") ){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Balanced_brackets b = new Balanced_brackets();
        System.out.println(b.isBalanced("()[]{{{"));
    }
}