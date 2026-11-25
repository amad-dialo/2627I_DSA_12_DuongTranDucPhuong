package practice;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SimpleTextEditor {
    private static class Operation {
         int type;
         int length;
         String text;

         Operation(int type,int length,String text){
             this.type=type;
             this.length=length;
             this.text=text;
         }
    }
    public static void main(String[] args){
        int q = StdIn.readInt();
        StringBuilder currentText = new StringBuilder();
        Stack<Operation> history = new Stack<>();

        for(int i = 0; i<q;i++){
            int type = StdIn.readInt();
            if (type == 1){
                String in = StdIn.readString();
                currentText.append(in);
                history.push(new Operation(1,in.length(),null));
            }else if (type == 2){
                int k = StdIn.readInt();
                int start_idx = Math.max(0,currentText.length() -k);
                String deleted_part= currentText.substring(start_idx);
                currentText.delete(start_idx,currentText.length());
                history.push(new Operation(2,0,deleted_part));
            }else if (type==3){
                StdOut.println(currentText.toString());
            }else if (type ==4){
                if(!history.isEmpty()){
                    Operation last_ops= history.pop();
                    if (last_ops.type==1){
                        currentText.delete(currentText.length()-last_ops.length,currentText.length());
                    }else if(last_ops.type==2){
                        currentText.append(last_ops.text);
                    }
                }
            }
        }
    }

}
