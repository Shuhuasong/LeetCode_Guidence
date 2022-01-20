package Design;

/**
 * Created by Shuhua Song
 */
public class _1381_DesignAStackWithIncrementOperation {
    int[] dq;
    int bottom = -1, top = -1;
    int maxSize;
    public _1381_DesignAStackWithIncrementOperation(int maxSize) {
        dq = new int[maxSize];
        this.maxSize = maxSize;
    }
    public void push(int x) {
        if(top-bottom >= maxSize) return;
        top++;
        dq[top] = x;
    }

    public int pop() {
        if(top==-1) return -1;
        int res = dq[top];
        top--;
        return res;
    }

    public void increment(int k, int val) {
        for(int i=0; i<Math.min(k, top-bottom); i++){
            dq[i] = dq[i] + val;
        }
    }
}
