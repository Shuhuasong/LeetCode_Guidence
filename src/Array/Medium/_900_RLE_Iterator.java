package Array.Medium;

public class _900_RLE_Iterator {
    int index;
    int[] encoding;
    public _900_RLE_Iterator(int[] encoding) {
        index = 0;
        this.encoding = encoding;
    }

    public int next(int n) {
        int lastEle = -1;
        while(n > 0 && index < encoding.length){
            if(n < encoding[index]){
                encoding[index] -=  n;
                lastEle = encoding[index+1];
                break;
            }else if(n==encoding[index]){
                encoding[index] = 0;
                lastEle = encoding[index+1];
                index += 2;
                break;
            }else{
                n -= encoding[index];
                encoding[index] = 0;
                index += 2;
            }
        }
        return lastEle;
    }
}
