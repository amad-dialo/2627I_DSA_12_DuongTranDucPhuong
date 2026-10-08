package src.Week_03;
import java.io.*;
import edu.princeton.cs.algs4.Stack;

public class Simple_Text_Editor {
    static class Action {
        int type;
        String str; // chứa chuỗi bị xóa
        int len;    //chứa độ dài chuỗi để xóa

        // Constructor undo xóa
        Action(int type, String str) {
            this.type = type;
            this.str = str;
        }

        // Constructor undo append
        Action(int type, int len) {
            this.type = type;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        String firstLine = br.readLine();
        if (firstLine == null) return;

        int Q = Integer.parseInt(firstLine.trim());

        StringBuilder S = new StringBuilder();
        Stack<Action> stack = new Stack<>();

        for (int i = 0; i < Q; i++) {
            String line = br.readLine();
            if (line == null) break;


            int spaceIdx = line.indexOf(' ');
            int op;
            String arg = null;

            if (spaceIdx == -1) {
                op = Integer.parseInt(line);
            } else {
                op = Integer.parseInt(line.substring(0, spaceIdx));
                arg = line.substring(spaceIdx + 1);
            }

            if (op == 1) {
                stack.push(new Action(1, arg.length()));
                S.append(arg);

            } else if (op == 2) {
                int k = Integer.parseInt(arg);
                int start = S.length() - k;

                String deleted = S.substring(start, S.length());
                stack.push(new Action(2, deleted));

                S.delete(start, S.length());

            } else if (op == 3) {
                int k = Integer.parseInt(arg);
                out.println(S.charAt(k - 1));

            } else if (op == 4) {
                if (!stack.isEmpty()) {
                    Action lastAction = stack.pop();
                    if (lastAction.type == 1) {
                        S.delete(S.length() - lastAction.len, S.length());
                    } else if (lastAction.type == 2) {
                        S.append(lastAction.str);
                    }
                }
            }
        }

        out.flush();
        out.close();
        br.close();
    }
}

