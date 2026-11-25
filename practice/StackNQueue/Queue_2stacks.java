package practice;

import edu.princeton.cs.algs4.Stack;

public class Queue_2stacks {
    private Stack<Integer> stack_in = new Stack<Integer>();
    private Stack<Integer> stack_out = new Stack<Integer>();

    private void push(int x){
        stack_in.push(x);
    }
    private void pop(){
        if(stack_out.isEmpty()){
            while(!stack_in.isEmpty()){
                stack_out.push(stack_in.pop());
            }
        }
        stack_out.pop();
    }
    private int peek() {
        if (stack_out.isEmpty()) {
            while (!stack_in.isEmpty()) {
                stack_out.push(stack_in.pop());
            }
        }
        return stack_out.peek();
    }

}
