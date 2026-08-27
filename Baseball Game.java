import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scoreStack = new Stack<>();
        
        for (String op : operations) {
            if (op.equals("+")) {
                // Get the last two scores without removing them permanentely yet
                int top = scoreStack.pop();
                int newScore = top + scoreStack.peek();
                // Push them all back in the correct order
                scoreStack.push(top);
                scoreStack.push(newScore);
            } else if (op.equals("D")) {
                // Double the last score
                scoreStack.push(2 * scoreStack.peek());
            } else if (op.equals("C")) {
                // Invalidate/remove the last score
                scoreStack.pop();
            } else {
                // It's an integer score, parse and record it
                scoreStack.push(Integer.parseInt(op));
            }
        }
        
        // Sum all the scores remaining in the stack
        int totalSum = 0;
        for (int score : scoreStack) {
            totalSum += score;
        }
        
        return totalSum;
    }
}
