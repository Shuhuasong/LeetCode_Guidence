package Bitwise.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _2166_DesignBitset {

    int[] bits, flips;
    int size;
    int count;
    public _2166_DesignBitset(int size) {
        bits = new int[size];
        flips = new int[size];
        count = 0;
        this.size = size;
        Arrays.fill(flips, 1);
    }

    public void fix(int idx) {
        if(bits[idx]==0) count++;
        bits[idx] = 1;
        flips[idx] = 0;
    }

    public void unfix(int idx) {
        if(bits[idx]==1) count--;
        bits[idx] = 0;
        flips[idx] = 1;
    }

    public void flip() {
        int[] temp = flips;
        flips = bits;
        bits = temp;
        count = size - count;
    }

    public boolean all() {
        return count == size;
    }

    public boolean one() {
        return count > 0;
    }

    public int count() {
        return count;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int b : bits){
            sb.append(b);
        }
        return sb.toString();
    }


    /*
      //Time = O(n)
      char[] bits;
    int size, count;
    boolean isFlip; // if isFlip is true, then treat '1' as '0', and '0' as '1'
    public Bitset(int size) {
        bits = new char[size];
        this.size = size;
        isFlip = false;
        count = 0;
        Arrays.fill(bits, '0');
    }

    //1) no flip exist, if bits[idx] = '0', then we need to change it to '1'
    //2) with Flip exist, bits[idx] = '1'  actually is bits[idx] = '0' ===> so we need change it from '0' to '1'
    //               set bits[idx] = '1' , then set it's opposite bits[idx] = '0' to reflect the flip is true
    public void fix(int idx) {
        if(!isFlip && bits[idx]=='0'){
            count++;
            bits[idx] = '1';
        }else if(isFlip && bits[idx]=='1'){
            count++;
            bits[idx] = '0';
        }
    }
    //1) no Flip exist, if bits[idx] = '1', then we need to change it to '0'
    //2) with Flip exist, bits[idx] = '0', actaully is bits[idx] = '1' after flip ==> so we need to change it from '1' to '0'
    //                set bits[idx] = '0', then set it's opposited bits[idx] = '1' to refllect the flip is true
    public void unfix(int idx) {
         if(!isFlip && bits[idx]=='1'){
             count--;
             bits[idx] = '0';
         }else if(isFlip && bits[idx]=='0'){
             count--;
             bits[idx] = '1';
         }
    }

    public void flip() {
        isFlip = !isFlip;
        count = size - count;
    }

    public boolean all() {
        return count==size;
    }

    public boolean one() {
       return count > 0;
    }

    public int count() {
       return count;
    }

    public String toString() {
        if(!isFlip) return new String(bits);
        StringBuilder sb = new StringBuilder();
        for(char c : bits){
            sb.append(c=='1' ? '0' : '1');
        }
        return sb.toString();
    }
     */
}

//TLE reason: in the flip function, it may cause time: 10^5(size) * 10^5 (#calls), which will be very slow
