package Bitwise.Medium;

/**
 * Created by Shuhua Song
 */
public class _393_UTF_8_Validation {
    //Time = O(n), Space = O(1)
    public boolean validUtf8(int[] data) {
        //number of byte need to check
        int left = 0;
        for(int d : data){
            if(left==0){ //b = binary
                if((d >> 3) == 0b11110) left = 3; //11110xxx, need to check 3 more bytes after this
                else if((d >> 4) == 0b1110) left = 2; //1110xxxx, need to check 2 more bytes after this
                else if((d >> 5) == 0b110) left = 1; //110xxxxx, need to check 1 more bytes after this
                else if((d >> 7) == 0b0) left = 0;//0xxxxxxx, need to check 0 more bytes after this
                else return false; //not valid
            }else{
                if((d >> 6) != 0b10) return false; //10xxxxxx
                left--;
            }
        }
        //need to check if there are with less or more bytes
        return left == 0;
    }
}

/*
Basic Concept of UTF-8:
variable width character enconding 1 to 4 bytes that can
encode all 1,112,064 valid code points in Unicode
0 ~ 127 ASCII == UTF-8 1 byte
127-255 extended == > 2 bytes

for example:
1 int32==> 4 bytes
"1" String==> 1 bytes
123456789, int32 ==> 4 bytes
"123456789", string ==> 9 bytes
Need use delimiter to seperate(like comma) ==> encode

Character      ASCII      UTF-8
    h           104       [104]d [0 110 1000]b
    ©           174       [194, 174]d [110 00010, 10 101110]b
    花           -        [232, 138, 177]d [1110, 10 001010, 10 110001]b
    🌹           -        [240, 159, 140, 185]d [11110 000, 10 0011111, 10 001100, 10 111001]b

How to check the prefix in binary format ?
(a >> k) == mask, k = 8 - len(mask)
e.g mask = 110b, len(mask) = 3, (110 00010 >> (8-3)) = 110b = mask

*/
























