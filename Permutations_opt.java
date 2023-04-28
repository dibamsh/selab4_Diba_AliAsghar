import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class Permutations_opt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        permute(str);
    }

    private static void permute(String str) {
        Deque<State> stack = new ArrayDeque<>();
        stack.push(new State("", str));

        while (!stack.isEmpty()) {
            State state = stack.pop();

            if (state.remaining.isEmpty()) {
                System.out.println(state.current);
            } else {
                for (int i = 0; i < state.remaining.length(); i++) {
                    String newCurrent = state.current + state.remaining.charAt(i);
                    String newRemaining = state.remaining.substring(0, i) + state.remaining.substring(i + 1);
                    stack.push(new State(newCurrent, newRemaining));
                }
            }
        }
    }

    private static class State {
        String current;
        String remaining;

        public State(String current, String remaining) {
            this.current = current;
            this.remaining = remaining;
        }
    }





}
