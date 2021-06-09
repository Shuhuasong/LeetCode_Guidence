package Stack.Medium;

import java.util.Stack;

public class _946_ValidateStackSequence {
    /*
    idea: first, we traverse each element in pushed array, where is no element=popped[0], we keep push
    element into stack, once there is an equal, we pop the element. Then when we reach i=pushed.length-1, we
    continue checking if the stack.peek()== popped[j], if it is, we continue to pop until the stack is empty.
    Finally, check if pointer j==popped.length;
    */
    //Time = O(n) Space = O(n)
     public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();
        while(i < pushed.length && j < popped.length){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
            i++;
        }
        return j==popped.length;
    }
}
